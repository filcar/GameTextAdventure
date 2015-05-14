/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author fil
 */
public class InstanceGame implements Serializable{
    private State state;
    private List<ILocation> locations = new ArrayList<>();

    public void addLocations(ILocation location) {
        locations.add(location);
    }
    public void setState(State state) {
        this.state = state;
    }
    public State getState() {
        return state;
    }
    public List<ILocation> getLocations() {
        return locations;
    }

    
}
