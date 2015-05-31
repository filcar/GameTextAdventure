/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import static java.lang.reflect.Modifier.TRANSIENT;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fil
 */
public class Gate implements IGate, Serializable{
    private String name;
    private String direction;
    private String locTitle1;
    private String locTitle2;
    private IDoorState doorState;
    private IItemKey key;
    private ILocation loc1;
    private ILocation loc2;

    public void setName(String name) {
        this.name = name;
    }


    public Gate()
    {
        
    }
//constractor
 public Gate(String name, ILocation loc1, ILocation loc2) {
        this.name=name;
        this.locTitle2=(String)loc2.getLocationTitle();        
        this.locTitle1=(String)loc1.getLocationTitle();
        this.loc1 = (LocationRoom)loc1;
        this.loc2 = (LocationRoom)loc2;
        this.doorState=new DoorStateOpen();
    }
 
 //constractor2
 public Gate(String name, ILocation loc1, ILocation loc2,IItem key) {
        this.name=name; 
        this.locTitle2=(String)loc2.getLocationTitle();        
        this.locTitle1=(String)loc1.getLocationTitle();
        this.loc1 = (LocationRoom)loc1;
        this.loc2 = (LocationRoom)loc2;
        this.doorState = new DoorStateLock();   
        this.key = (IItemKey)key;
    }

    public String getLocTitle1() {
        return locTitle1;
    }

    public void setLocTitle1(String locTitle1) {
        this.locTitle1 = locTitle1;
    }

    public String getLocTitle2() {
        return locTitle2;
    }

    public void setLocTitle2(String locTitle2) {
        this.locTitle2 = locTitle2;
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
    public void setJoinLocations(HashMap<String,ILocation> map) {
      loc1=map.get(locTitle1);
      loc2=map.get(locTitle2);
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
