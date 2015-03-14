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
    void registerGate (IGate gate);
    void registerItem (IItem item);
    HashMap<String, IGate> getMapGate();
    HashMap<String, IItem> getMapItem();
}