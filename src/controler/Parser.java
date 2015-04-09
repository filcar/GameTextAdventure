/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.ArrayList;

/**
 *
 * @author fil
 */
public class Parser {

    private String input;
    private  String words[];
    private String[] ingnoreWord = {" to ", " the "," for "," with "};
    private  String command;
    private  String obj;  
    Lexer lexer=new Lexer();
    
    public Parser(String input2) {
    //Παρεμβολή του lexer για τον νέο parser===============================
        ArrayList<Token> tokens = lexer.lex(input2); 
        Integer j=0;
        if(tokens.isEmpty()) 
            System.out.println("Command not found!!!");
        else if(!tokens.get(0).type.equals(TokType.VERB.name())){
            System.out.println("Syntax error!!!");
                 j=-1;
           }   
        
        switch (tokens.size()){
            case 1:
           
                System.out.println("1-"+tokens.get(0));
                break;
            case 2:
                if(tokens.get(1).type.equals(TokType.ITEM.name())){
                    System.out.println("verb Item !!!");
                    j=1;}
                if(tokens.get(1).type.equals(TokType.DIRECTION.name())){
                if (tokens.get(0).data.matches("(OPEN|CLOSE|LOCK|UNLOCK)")){
                    j=1;
                    System.out.println("verb gate !!!");
                }
                else {System.out.println("Syntax error!!!");
                  j=-1;
                }
            }  
                System.out.println("2-"+tokens);
                break;
            case 3:
                System.out.println("3-"+tokens);
                break; 
            case 4:

                System.out.println("4-"+tokens);
                break;                 
            default:
                break;
        }
     
        
        for (Token token : tokens)
        
            System.out.println(token);
        
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

    public String getCommand() {
        return command;
    }

    public String getObject() {
        return obj;
    }
    
    
      

    
}
