/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author fil
 */
public interface IGate {
    
    public String getName();

    String getDirection();

    ILocation getLeadToLocation(ILocation curentLocation);

    void setDirection(String gateName);

    void setJoinLocations(HashMap<String,ILocation> map);

    public IDoorState getDoorState();
    
    public void setDoorState(IDoorState doorState);
   
    public IItemKey getKey();
   
    public void setKey(IItemKey key);
    
}
