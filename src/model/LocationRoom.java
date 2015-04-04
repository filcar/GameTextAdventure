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
public class LocationRoom implements ILocation {
    private String locationTitle;
    private String locationDescription;
    private HashMap<String, IGate> mapGate = new HashMap<String, IGate>();
    private HashMap<String, IItem> mapItem = new HashMap<String, IItem>();

    public LocationRoom() {
    }

    public LocationRoom(String locationTitle, String locationDescription) {
        this.locationTitle = locationTitle;
        this.locationDescription = locationDescription;
    }
    
    @Override
    public void registerGate (Direct2 direction,IGate gate){
            mapGate.put(direction.toString(), gate);
           
        }
    
    @Override
    public void addItem (IItem item){
            mapItem.put(item.getName(), item);
        }
    
    @Override
    public void removeItem (IItem item){
        mapItem.remove(item.getName(), item);
    }    
    
    @Override
    public String getLocationTitle() {
        
        return locationTitle;
    }

    @Override
    public String getLocationDescription() {
        return locationDescription;
    }

    @Override
    public HashMap<String, IGate> getMapGate() {
        return mapGate;
    }


    @Override
    public HashMap<String, IItem> getMapItem() {
        return mapItem;
    }

  
    
    
}
