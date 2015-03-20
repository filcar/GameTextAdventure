/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import model.IItem;
import model.ILocation;
import model.State;

/**
 *
 * @author fil
 */
public class Take implements ICommand {
    private String name;

    public Take() {
        this.name="TAKE";
    }


    @Override
    public String toString() {
        return "Take{" + "name=" + name + '}';
    }

    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void action (State curentState,String word2){
    //    curentState.showCurentState();
        if(curentState.getLocation().getMapItem().containsKey(word2)){
            IItem item =curentState.getLocation().getMapItem().get(word2);
            curentState.getLocation().removeItem(item);
            curentState.getPlayer().addItem(item);
            curentState.showCurentState();
        }
        else {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("I can't take this!!!");
            System.out.println("\n\n\n");
        }
    }  
    
}
