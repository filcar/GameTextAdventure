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
public class DoorStateClose implements IDoorState,Serializable {
    private String state;
    private String result; 
//    private IDoorState openState = new DoorStateOpen();
//    private IDoorState lockState = new DoorStateLock();
//    private IDoorState closeState = new DoorStateClose();

    public DoorStateClose() {
        state="closed";
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
        if(obj instanceof IGate){
            IGate gate= (IGate)obj;
            gate.setDoorState(openState);
            result=("The "+gate.getName()+" door opened!!!");}
        return result;
        
    }
 
    @Override
    public String close(Object obj){
       // IDoorState closeState = new DoorStateClose();
        if(obj instanceof IGate)
          result=("The door is allready closed!");
        return result;
    }
    
    @Override
    public String lock(Object obj,IItemKey key){
        IDoorState lockState = new DoorStateLock();
        //nead key
        if(obj instanceof IGate){
            IGate gate = (IGate)obj;
            gate.setDoorState(lockState);
            gate.setKey(key);
            result=("The door is locked!");
        }
    return result;
    }
    @Override
    public String unlock(Object obj,IItemKey key){
     //   IDoorState closeState = new DoorStateClose();
        if(obj instanceof IGate){
            result=("The door is closed but not locked!");
        }
    return result;
    }    
}
