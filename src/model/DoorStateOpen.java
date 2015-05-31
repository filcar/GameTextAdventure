/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author fil
 */
public class DoorStateOpen implements IDoorState,Serializable{
    private String state;
    private String result;
//    private IDoorState openState = new DoorStateOpen();
//    private IDoorState lockState = new DoorStateLock();
//    private IDoorState closeState = new DoorStateClose();

    
    public DoorStateOpen() {
        state="opened";
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }
    
  //------------------------------   
    @Override
    public String open(Object obj){
        IDoorState openState = new DoorStateOpen();
        if(obj instanceof IGate)
            result=("The door is allready opened!!!");
        return result;
        
    }
 
    @Override
    public String close(Object obj){
        IDoorState closeState = new DoorStateClose();
        if(obj instanceof IGate){
            IGate gate =(IGate)obj;
            gate.setDoorState(closeState);
            result=("The door is closed!");
        }
        return result;
    }
    
    @Override
    public String lock(Object obj,IItemKey key){
      //  IDoorState openState = new DoorStateOpen();
        if(obj instanceof IGate){
            result=("Close the door first!");
        }
    return result;
    }
    @Override
    public String unlock(Object obj,IItemKey key){
     //   IDoorState openState = new DoorStateOpen();
        if(obj instanceof IGate){
            result=("There is not locked door!");
        }
    return result;
    }    
}