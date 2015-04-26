/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import static controler.Lexer.tokenType;
import model.IGate;
import model.IItemKey;
import model.State;

/**
 *
 * @author fil
 */
public class UnLock implements ICommand {
    private String name;
    private String result="";

    public UnLock() {
        this.name="UNLOCK";
        tokenType.addList(this);
        syntaxs.put("<"+name+">"+"<DIRECTION>", 2);
        syntaxs.put("<"+name+">"+"<ITEM>", 2);
    }

    @Override
    public String toString() {
        return "UnLock{" + "name=" + name + '}';
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
                
                result=(gate.getDoorState().unlock(gate,key));
            }
            else    
                result=("You must have and use a key to unlock " +gate.getName()+" door");
        }
        else {
            result=("I can't unlock something!!!");
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
