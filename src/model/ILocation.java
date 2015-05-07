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
public interface ILocation {

    String getLocationDescription();
    String getLocationTitle();
    void registerGate (Direct2 direction,IGate gate);
    void addItem (IItem item);
    void removeItem (IItem item);
    HashMap<String, IGate> getMapGate();
    HashMap<String, IItem> getMapItem();
}