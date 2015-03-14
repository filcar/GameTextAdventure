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
    private String direction;
    private int state=0;
    private ILocation leadToLocation;

    public Gate(String direction, ILocation leadToLocation) {
        this.direction = direction;
        this.leadToLocation = leadToLocation;
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
    public int getState() {
        return state;
    }

    @Override
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public ILocation getLeadToLocation() {
        return leadToLocation;
    }

    @Override
    public void setLeadToLocation(ILocation leadToLocation) {
        this.leadToLocation = leadToLocation;
    }
    
    
}
