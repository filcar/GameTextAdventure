/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import controler.TokenType;
import java.util.Scanner;
import model.DoorStateOpen;
import model.IDoorState;
import model.IGate;
import model.ILocation;
import model.State;

/**
 *
 * @author fil
 */
public class Open implements ICommand {
    private String name;
    private String result="";
    
    public Open() {
        this.name="OPEN";
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
    
}
