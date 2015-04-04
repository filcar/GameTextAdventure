/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import model.IItem;
import model.State;

/**
 *
 * @author fil
 */
public class Use implements ICommand {
    private String name;
    private String result="";

    public Use() {
        this.name="USE";
    }


    @Override
    public String toString() {
        return "Use{" + "name=" + name + '}';
    }

    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String action (State curentState,String word2){
    //    curentState.showCurentState();
        if(curentState.getPlayer().getMapItem().containsKey(word2)){
            IItem item =curentState.getPlayer().getMapItem().get(word2);
            curentState.getPlayer().setCurrentItem(item);
            result=("\nNow you can use the "+item.getName()+" .\n");
          //  curentState.showCurentState();
        }
        else if (word2.equals("NONE")) {
            result=("What do you want to use?");        
        }
        else {
            result=("I can't use this!!!");
        }
        return result;
    }  
    
}
