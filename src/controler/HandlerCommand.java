/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import command.ICommand;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.State;

/**
 *
 * @author fil
 */
public class HandlerCommand {
   //     private List<ICommand> commands = new ArrayList<>();
        private HashMap<String, ICommand> mapCommand = new HashMap<String, ICommand>();
        
        public void register (ICommand command){
     //       commands.add(command);
            mapCommand.put(command.getName(), command);
        }
        
public void handle(String word1, String word2, State curentState){
    if (mapCommand.containsKey(word1)){
    mapCommand.get(word1).action(curentState,word2);
    
    }
    else {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Command not found!!\n\n\n\n");
    }
    
    }
    
    
}
