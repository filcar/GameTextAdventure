/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import model.ILocation;
import model.State;

/**
 *
 * @author fil
 */
public class Go implements ICommand {
    private String name;

    public Go() {
        this.name="GO";
    }

    @Override
    public String toString() {
        return "Go{" + "name=" + name + '}';
    }

    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void action (State curentState,String word2){
    //    curentState.showCurentState();
        if(curentState.getLocation().getMapGate().containsKey(word2)){
            ILocation location =curentState.getLocation().getMapGate().get(word2).getLeadToLocation();
            curentState.setLocation(location);
            curentState.showCurentState();
        }
        else {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("I can't go there, this is no way out!!!");
            System.out.println("\n\n\n");
        }
    }  
    
}
