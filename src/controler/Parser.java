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
public class Parser {

    private String input;
    private  String words[];
    private  String command;
    private  String object;  
    
    public Parser(String input) {
        this.input = input;
        words=input.split(" ",2);
        command=words[0].trim();
        if(words.length<2) object="NONE";
        else object=words[1].trim();    

    }

    public String getCommand() {
        return command;
    }

    public String getObject() {
        return object;
    }
    
    
      

    
}
