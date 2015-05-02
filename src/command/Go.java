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
import model.State;

/**
 *
 * @author fil
 */
public class Go implements ICommand {
    private String name;

    public Go(HashMap<String,Integer> syntaxs,TokenType2 tokenType) {
        this.name="GO";
        tokenType.addList(this);
        syntaxs.put("<"+name+">"+"<DIRECTION>", 2);
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
    public String action (State curentState,String word2){
        String result="";
        if(curentState.getLocation().getMapGate().containsKey(word2)){
            ILocation curentLocation=curentState.getLocation();
            IGate gate=curentState.getLocation().getMapGate().get(word2);
            ILocation location =curentState.getLocation().getMapGate().
                    get(word2).getLeadToLocation(curentLocation);
            String state = curentState.getLocation().getMapGate().get(word2).getDoorState().getState();

            if (state.equals("opened")){
                curentState.setLocation(location);
                curentState.showCurentState(); 
            }
            else {
                result=("the Door is "+state);
            }
        }
        else {
            result=("I can't go there, this is no way out!!!");

        }
        return result;
    }  
    
    @Override
    public String action1 (State curentState){
        String result=("Where are you want to go???");
        return result;
    }
    
    @Override
    public String action2 (State curentState,String item1, String prepos, String item2){
        String result=("Not implement!!!");
        return result;
    }
}
