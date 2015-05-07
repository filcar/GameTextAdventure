/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import controler.TokenType2;
import java.util.HashMap;
import model.IGate;
import model.IItemKey;
import model.State;

/**
 *
 * @author fil
 */
public class Lock implements ICommand {
    private String name;
    private String result="";

    public Lock(HashMap<String,Integer> syntaxs,TokenType2 tokenType) {
        this.name="LOCK";
        tokenType.addList(this);
        syntaxs.put("<"+name+">"+"<DIRECTION>", 2);
        syntaxs.put("<"+name+">"+"<ITEM>", 2);
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
    public String action (State curentState,String word2){
    //    curentState.showCurentState();
        if(curentState.getLocation().getMapGate().containsKey(word2)){
            IGate gate=curentState.getLocation().getMapGate().get(word2);
            if (curentState.getPlayer().getCurrentItem() instanceof IItemKey){
                IItemKey key = (IItemKey)(curentState.getPlayer().getCurrentItem());
                ///
                result=(gate.getDoorState().lock(gate,key));
            }
            else    
                result=("You must have and use a key to lock " +gate.getName()+" door");
        }
        else {
            result=("I can't Lock something!!!");
        }
        return result;
    }  
    
    @Override
    public String action1 (State curentState){
        result=("Do you wont lock something. What???");
    return result;
    }
    
    @Override
    public String action2 (State curentState,String item1, String prepos, String item2){
        String result=("Not implement!!!");
        return result;
    }
}
