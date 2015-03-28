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
    public void action (State curentState,String word2){
    //    curentState.showCurentState();
        if(curentState.getPlayer().getMapItem().containsKey(word2)){
            IItem item =curentState.getPlayer().getMapItem().get(word2);
            curentState.getPlayer().removeItem(item);
            curentState.getLocation().addItem(item);
            System.out.println("\nDropped.\n");
           // curentState.showCurentState();
        }
        else {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("I can't drop this!!!");
            System.out.println("\n\n\n");
        }
    }  
    
}
