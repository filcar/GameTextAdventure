/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

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
    private ArrayList<Token> tokens=new ArrayList<>();
    private HandlerCommand hc;    
    private String syntax;  
    private HashMap<String,Integer> syntaxs = new HashMap<>();
    private String result;
    private HashMap tokenType;
    
    public Parser(HandlerCommand hc,HashMap tokenType,HashMap<String,Integer> syntaxs) {
            //public Parser(HandlerCommand hc,ArrayList<Token> tokens,HashMap<String,Integer> syntaxs) {
    //Παρεμβολή του lexer για τον νέο parser===============================
        this.hc=hc;
        this.tokenType=tokenType;
        this.syntaxs=syntaxs;
//        syntaxs.put("<VERB>",1);
//        syntaxs.put("<VERB><ITEM>",2);
//        syntaxs.put("<VERB><DIRECTION>",2);
//        syntaxs.put("<VERB><ITEM><PREPOSITION><ITEM>",4);
        syntax="";

    }
    
    public String parsing(String input){
        Lexer lexer=new Lexer();
        this.tokens = lexer.lex(" "+input+" ",tokenType); 
        for(Token token : tokens){
            if (token.type.equals("VERB")) syntax="<"+token.data+">";
            else syntax=syntax+"<"+token.getType()+">";
        }
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
