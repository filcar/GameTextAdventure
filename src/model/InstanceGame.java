/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author fil
 */
public class InstanceGame implements Serializable{
    private State state=null;
    private ArrayList<ILocation> locations = new ArrayList<>();
    
    public InstanceGame() {
    }
       
    public void addLocations(ILocation location) {
        locations.add(location);
    }
    public void setState(State state) {
        this.state= state;
        
    }
    public State getState() {
        return state;
    }
    public List<ILocation> getLocations() {
        return locations;  
    }

     
}
