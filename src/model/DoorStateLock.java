/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author fil
 */
public class DoorStateLock implements IDoorState {
    private String state;
    private String result;
//    private IDoorState openState = new DoorStateOpen();
//    private IDoorState lockState = new DoorStateLock();
//    private IDoorState closeState = new DoorStateClose();

    
    public DoorStateLock() {
        state="locked";
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
      //  IDoorState lockState = new DoorStateLock();
        if(obj instanceof IGate)
            result=("I cant open the locked door. You mast have key to unlock that!!!!!!");
        return result;
        
    }
 
    @Override
    public String close(Object obj){
      //  IDoorState lockState = new DoorStateLock();
        if(obj instanceof IGate)
          result=("The door is closed and locked!");
        return result;
    }
    
    @Override
    public String lock(Object obj){
      //  IDoorState lockState = new DoorStateLock();
        //nead key
        if(obj instanceof IGate){
            result=("The door is allready locked!");
        }
    return result;
    }
    @Override
    public String unlock(Object obj){
        //nead key
        IDoorState closeState = new DoorStateClose();
        if(obj instanceof IGate){
            IGate gate = (IGate)obj;
            gate.setDoorState(closeState);
            result=("The door is unlocked but still closed!");
        }
    return result;
    }    
}
