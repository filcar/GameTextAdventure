/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import command.ICommand;
import java.util.HashMap;
import model.State;

/**
 *
 * @author fil
 */
public class HandlerCommand {

private State curentState;
private HashMap<String, ICommand> mapCommand = new HashMap<String, ICommand>();

public HandlerCommand(State curentState) {
        this.curentState = curentState;
    }
    
public void register (ICommand command){
            mapCommand.put(command.getName(), command);
        }
        
public String handle(String word1, String word2){
    String result="";
    if (mapCommand.containsKey(word1)){
        result=mapCommand.get(word1).action(curentState,word2);
    
    }
    else {
        result =("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        result =result+("Command not found!!\n\n\n\n");
    }
       return result;//System.out.println(result);
    }

public String handle1(String word1){
    String result="";
    if (mapCommand.containsKey(word1)){
     result=mapCommand.get(word1).action1(curentState);
    
    }
    else {
        result =("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        result =result+("Command not found!!\n\n\n\n");
    }
    return result;
    }    
    
public String handle2(String verb,String item1, String prepos, String item2){
    String result="";
    if (mapCommand.containsKey(verb)){
     result=mapCommand.get(verb).action2(curentState,item1, prepos, item2);
    
    }
    else {
        result =("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        result =result+("Command not found!!\n\n\n\n");
    }
    return result;
}

}
