/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author fil
 */
public class Parser {

    private String input;
    private  String words[];
    private  String[] ingnoreWord = {" to ", " the "," for "," with "};
    private  String command;
    private String obj;  
    private Lexer lexer=new Lexer();
    private ArrayList<Token> tokens=new ArrayList<>();
    private HandlerCommand hc;    
    private String syntax;  
    private HashMap<String,Integer> syntaxs = new HashMap<String,Integer>();
    private String result;
    
    public Parser(HandlerCommand hc, String input2) {
    //Παρεμβολή του lexer για τον νέο parser===============================
        this.hc=hc;
        tokens = lexer.lex(" "+input2+" "); 
        syntaxs.put("<VERB>",1);
        syntaxs.put("<VERB><ITEM>",2);
        syntaxs.put("<VERB><DIRECTION>",2);
        syntaxs.put("<VERB><ITEM><PREPOSITION><ITEM>",4);
        syntax="";
        for(Token token : tokens){
        syntax=syntax+"<"+token.type+">";
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
        //αγνοησε τις λέξεις του πίνακα ingnoreWord
        for (int i=0;i<ingnoreWord.length;i++)
           input2=input2.replaceAll(ingnoreWord[i], "");
        //αφαίρεσε τα διπλα κενά
        while(input2.contains("  "))
           input2= input2.replaceAll("  "," ");        
        //αφαίρεσε τα κενά της αρχής
        while(input2.startsWith(" "))
           input2= input2.replaceFirst(" ","");
                
        this.input = input2;
        words=input.split(" ",3);
        command=words[0].trim();
        if(words.length<2) obj="NONE";
        else obj=words[1].trim();    

    }
    
    public String parsing(){
        if(!syntaxs.containsKey(syntax)) 
            result =("Syntax error!!!");
        else {
                switch (syntaxs.get(syntax)){
                case 1:        
                    result="case 1" ;
                break;
                case 2:        
                    result="case 2" ;
                break;
                case 4:        
                    result="case 4" ;
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
