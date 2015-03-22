/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

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
public class Close implements ICommand {
    private String name;

    public Close() {
        this.name="CLOSE";
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
    public void action (State curentState,String word2){
    //    curentState.showCurentState();
        if(curentState.getLocation().getMapGate().containsKey(word2)){
            IGate gate=curentState.getLocation().getMapGate().get(word2);
            System.out.println(gate.getDoorState().close(gate));
            

        }
        else {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("I can't close something!!!");
            System.out.println("\n\n\n");
        }
    }  
    
}
