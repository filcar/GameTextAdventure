/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import model.State;

/**
 *
 * @author fil
 */
public class Look implements ICommand {
    private String name;

    public Look() {
        this.name="LOOK";
    }

    @Override
    public String toString() {
        return "Look{" + "name=" + name + '}';
    }

    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void action (State curentState,String word2){
       curentState.showCurentState();
    }
    
}
