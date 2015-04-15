/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import static controler.Lexer.tokenType;
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
    private String result="";

    public Exit() {
        this.name="EXIT";
        tokenType.addList(this);
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
    public String action (State curentState,String word2){
    //ISOS APOTHIKEYSH TOY STATE
     System.out.println("Thank you for playing '"+curentState.getPlayer().getName()+"'\nBye-bye!!!");
     System.exit(0);
    return "";     
    }

    @Override
    public String action1 (State curentState){
     System.out.println("Thank you for playing '"+curentState.getPlayer().getName()+"'\nBye-bye!!!");
     System.exit(0);
    return "";   
    } 
}
