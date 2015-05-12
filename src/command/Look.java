/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import controler.TokenType2;
import java.util.HashMap;
import model.State;

/**
 *
 * @author fil
 */
public class Look implements ICommand {
    private String name;
    private String result="";
    private String description;

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Look(HashMap<String,Integer> syntaxs,TokenType2 tokenType) {
        this.name="LOOK";
        tokenType.addList(this);
        syntaxs.put("<"+name+">", 1);
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
    public String action (State curentState,String word2){
       result=curentState.showCurentState();
       return result;
    }
    @Override
    public String action1 (State curentState){
       result=curentState.showCurentState();
       return result;
    }
    
    @Override
    public String action2 (State curentState,String item1, String prepos, String item2){
        result=("Not implement!!!");
        return result;
    }
}
