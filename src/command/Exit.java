/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import controler.TokenType2;
import java.util.HashMap;
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

    public Exit(HashMap<String,Integer> syntaxs,TokenType2 tokenType) {
        this.name="EXIT";
        tokenType.addList(this);
        syntaxs.put("<"+name+">", 1);
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
    @Override
    public String action2 (State curentState,String item1, String prepos, String item2){
        String result=("Not implement!!!");
        return result;
    }
}
