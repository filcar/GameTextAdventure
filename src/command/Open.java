/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import controler.TokenType2;
import java.util.HashMap;
import model.IGate;
import model.State;

/**
 *
 * @author fil
 */
public class Open implements ICommand {
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
    
    public Open(HashMap<String,Integer> syntaxs,TokenType2 tokenType) {
        this.name="OPEN";
        tokenType.addList(this);
        syntaxs.put("<"+name+">"+"<DIRECTION>", 2);
        syntaxs.put("<"+name+">"+"<ITEM>", 2);
    }

    @Override
    public String toString() {
        return "Open{" + "name=" + name + '}';
    }

    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String action (State curentState,String word2){
    //    curentState.showCurentState();
        if(curentState.getLocation().getMapGate().containsKey(word2)){
            IGate gate=curentState.getLocation().getMapGate().get(word2);
            result=(gate.getDoorState().open(gate));
//            IDoorState doorState=gate.getDoorState().open(gate);
//            gate.setDoorState(doorState);
            

        }
        else {
            result=("What do you want to open?");
        }
        return result;
    }  
    @Override
    public String action1 (State curentState){
        String result=("Not implement!!!");
        return result;
    }
    
    @Override
    public String action2 (State curentState,String item1, String prepos, String item2){
        String result=("Not implement!!!");
        return result;
    }
}
