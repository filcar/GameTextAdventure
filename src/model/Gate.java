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
    private IDoorState doorState=new DoorStateOpen();
    private ILocation leadToLocation;

//constractor
    public Gate(String name, String direction, ILocation leadToLocation) {
        this.name=name;
        this.direction = direction;
        this.leadToLocation = leadToLocation;
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
    public ILocation getLeadToLocation() {
        return leadToLocation;
    }

    @Override
    public void setLeadToLocation(ILocation leadToLocation) {
        this.leadToLocation = leadToLocation;
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
