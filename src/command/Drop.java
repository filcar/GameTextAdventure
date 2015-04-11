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
public class Drop implements ICommand {
    private String name;
    private String result="";

    public Drop() {
        this.name="DROP";
    }


    @Override
    public String toString() {
        return "Drop{" + "name=" + name + '}';
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
            if(!(curentState.getPlayer().getCurrentItem()==null) 
                    && curentState.getPlayer().getCurrentItem().equals(item))
                curentState.getPlayer().setCurrentItem(null);
            curentState.getPlayer().removeItem(item);            
            curentState.getLocation().addItem(item);
            result=("\nDropped.\n");
           // curentState.showCurentState();
        }
        else {
            result=("I can't drop this!!!");
        }
        return result;
    }  
    
}
