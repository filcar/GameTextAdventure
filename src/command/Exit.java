/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import model.IGate;
import model.ILocation;
import model.IPlayer;
import model.Player;
import model.State;

/**
 *
 * @author fil
 */
public class Exit implements ICommand {
    private String name;

    public Exit() {
        this.name="EXIT";
    }

    @Override
    public String toString() {
        return "Exit{" + "name=" + name + '}';
    }

    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void action (State curentState,String word2){
    //ISOS APOTHIKEYSH TOY STATE
     System.out.println("Thank you for playing '"+curentState.getPlayer().getName()+"'\nBye-bye!!!");
     System.exit(0);
    }
    
}