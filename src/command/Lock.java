/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import model.IGate;
import model.IItemKey;
import model.State;

/**
 *
 * @author fil
 */
public class Lock implements ICommand {
    private String name;

    public Lock() {
        this.name="LOCK";
    }

    @Override
    public String toString() {
        return "Lock{" + "name=" + name + '}';
    }

    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void action (State curentState,String word2){
    //    curentState.showCurentState();
        if(curentState.getLocation().getMapGate().containsKey(word2)){
            IGate gate=curentState.getLocation().getMapGate().get(word2);
            if (curentState.getPlayer().getCurrentItem() instanceof IItemKey){
                IItemKey key = (IItemKey)(curentState.getPlayer().getCurrentItem());
                ///
                System.out.println(gate.getDoorState().lock(gate,key));
            }
            else    System.out.println("You must have and use a key to lock " +gate.getName()+" door");
        }
        else {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("I can't Lock something!!!");
            System.out.println("\n\n\n");
        }
    }  
    
}
