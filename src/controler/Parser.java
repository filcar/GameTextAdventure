/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import command.ICommand;
import static command.ICommand.syntaxs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.State;

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
    private State currentState; 
    private Lexer lexer=new Lexer();
    private ArrayList<Token> tokens=new ArrayList<>();
    private HandlerCommand hc;    
    private String syntax;  
    private HashMap<String,Integer> syntaxs = new HashMap<>();
    private String result;
    
    public Parser(HandlerCommand hc,ArrayList<Token> tokens, State currentState) {
    //Παρεμβολή του lexer για τον νέο parser===============================
        this.hc=hc;
        this.currentState=currentState;
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
        
////        Integer j=0;
////        if(tokens.isEmpty()) 
////            System.out.println("Command not found!!!");
////        else if(!tokens.get(0).type.equals(TokType.VERB.name())){
////            System.out.println("Syntax error!!!");
////                 j=-1;
////           }   
        //if(!syntaxs.containsKey(syntax)) System.out.println("Syntax error!!!");
////        switch (tokens.size()){
////            case 1:
////                
////                System.out.println("1-"+tokens.get(0));
////                break;
////            case 2:
////                if(tokens.get(1).type.equals(TokType.ITEM.name())){
////                    System.out.println("verb Item !!!");
////                    j=1;}
////                if(tokens.get(1).type.equals(TokType.DIRECTION.name())){
////                if (tokens.get(0).data.matches("(GO|OPEN|CLOSE|LOCK|UNLOCK)")){
////                    j=1;
////                    System.out.println("verb gate !!!");
////                }
////                else {System.out.println("Syntax error!!!");
////                  j=-1;
////                }
////            }  
////                System.out.println("2-"+tokens);
////                break;
////            case 3:
////                System.out.println("3-"+tokens);
////                break; 
////            case 4:
////
////                System.out.println("4-"+tokens);
////                break;                 
////            default:
////                break;
////        }
////     
////        
////        for (Token token : tokens)
////        
////            System.out.println(token);
        
        //-=====================================================


    }
    
    public String parsing(){
        if(!syntaxs.containsKey(syntax)) 
            result =("Syntax error!!!");
        else {
                switch (syntaxs.get(syntax)){
                case 1:        
                    command=tokens.get(0).data.toString();
                    result=hc.handle1(command, currentState);
                    
                    

                break;
                case 2:      
                    command=tokens.get(0).data.toString();
                    obj=tokens.get(1).data.toString();
                    result=hc.handle(command,obj,currentState);
                    //result="ok2" ;
                break;
                case 4:        
                    command=tokens.get(0).data.toString() ;
                    obj=tokens.get(1).data.toString();
                    prepos=tokens.get(2).data.toString();
                    obj2=tokens.get(3).data.toString();
                    result=hc.handle2(command,obj, prepos, obj2, currentState);
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
