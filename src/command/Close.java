/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import static controler.Lexer.tokenType;
import model.IGate;
import model.State;

/**
 *
 * @author fil
 */
public class Close implements ICommand {
    private String name;
    private String result="";

    public Close() {
        this.name="CLOSE";
        tokenType.addList(this);
    }

    @Override
    public String toString() {
        return "Close{" + "name=" + name + '}';
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
            result=(gate.getDoorState().close(gate));
            
        }
        else {
            result=("I can't close something!!!");
        }
        return result;
    }  
    @Override
    public String action1 (State curentState){
        result=("Not implement!!!");
        return result;
    }
    
}
