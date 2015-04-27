/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import command.ICommand;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author fil
 */
public class Parser {

    private String input;
    private  String words[];
    private  String[] ingnoreWord = {" to ", " the "," for "," with "};
    private  String command;
    private String obj,obj2,prepos;  
    private Lexer lexer=new Lexer();
    private ArrayList<Token> tokens=new ArrayList<>();
    private HandlerCommand hc;    
    private String syntax;  
    private HashMap<String,Integer> syntaxs = new HashMap<>();
    private String result;
    
    public Parser(HandlerCommand hc,ArrayList<Token> tokens) {
    //Παρεμβολή του lexer για τον νέο parser===============================
        this.hc=hc;
        this.tokens = tokens;//lexer.lex(" "+input2+" "); 
         syntaxs=(HashMap)ICommand.syntaxs.clone();
//        syntaxs.put("<VERB>",1);
//        syntaxs.put("<VERB><ITEM>",2);
//        syntaxs.put("<VERB><DIRECTION>",2);
//        syntaxs.put("<VERB><ITEM><PREPOSITION><ITEM>",4);
        syntax="";
        for(Token token : tokens){
            if (token.type.equals("VERB")) syntax="<"+token.data+">";
            else syntax=syntax+"<"+token.getType()+">";
        }
    }
    
    public String parsing(){
        if(!syntaxs.containsKey(syntax)) 
            result =("Syntax error!!!");
        else {
                switch (syntaxs.get(syntax)){
                case 1:        
                    command=tokens.get(0).data.toString();
                    result=hc.handle1(command);
                    
                    

                break;
                case 2:      
                    command=tokens.get(0).data.toString();
                    obj=tokens.get(1).data.toString();
                    result=hc.handle(command,obj);
                    //result="ok2" ;
                break;
                case 4:        
                    command=tokens.get(0).data.toString() ;
                    obj=tokens.get(1).data.toString();
                    prepos=tokens.get(2).data.toString();
                    obj2=tokens.get(3).data.toString();
                    result=hc.handle2(command,obj, prepos, obj2);
                break;                    
                }
            }       
    return result;
    }

    public String getCommand() {
        return command;
    }

    public String getObject() {
        return obj;
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }
    
    
      

    
}
