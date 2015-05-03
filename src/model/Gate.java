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
public class Gate implements IGate {
    private String name;
    private String direction;
    private IDoorState doorState;
    private IItemKey key;
    private ILocation loc1;
    private ILocation loc2;

//constractor
 public Gate(String name, ILocation loc1, ILocation loc2) {
        this.name=name;
        this.loc1 = loc1;
        this.loc2 = loc2;
        this.doorState=new DoorStateOpen();
    }
 
 //constractor2
 public Gate(String name, ILocation loc1, ILocation loc2,IItem key) {
        this.name=name;
        this.loc1 = loc1;
        this.loc2 = loc2;
        this.doorState = new DoorStateLock();   
        this.key = (IItemKey)key;
    }

    @Override
    public IItemKey getKey() {
        return key;
    }

    @Override
    public void setKey(IItemKey key) {
        this.key = key;
    }
        
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDirection() {
       
        return direction;
    }

    @Override
    public void setDirection(String gateName) {
        this.direction = gateName;
    }


    @Override
    public ILocation getLeadToLocation(ILocation curentLocation) {
        
            if(curentLocation.equals(loc1)){
                return loc2;
            }
            else return loc1;
    }

    @Override
    public void setLeadToLocation(ILocation leadToLocation) {
        System.out.println(leadToLocation);
    }

    @Override
    public IDoorState getDoorState() {
        return doorState;
    }

    @Override
    public void setDoorState(IDoorState doorState) {
        this.doorState = doorState;
    }
    
    
    
}
