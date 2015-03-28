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
public interface IGate {
    
    public String getName();

    String getDirection();

    ILocation getLeadToLocation(ILocation curentLocation);

    void setDirection(String gateName);

    void setLeadToLocation(ILocation leadToLocation);

    public IDoorState getDoorState();
    
    public void setDoorState(IDoorState doorState);
   
    public IItemKey getKey();
   
    public void setKey(IItemKey key);
    
}
