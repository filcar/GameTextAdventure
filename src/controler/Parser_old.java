/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author fil
 */
public class Parser_old {

    private String input;
    private  String words[];
    private String[] ingnoreWord = {" to ", " the "," for "," with "};
    private  String command;
    private  String obj;  
    
    public Parser_old(String input2) {
        //Παρεμβολή του lexer για τον νέο parser
        
        
        
        //
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
