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

    String getDirection();

    ILocation getLeadToLocation();

    int getState();

    void setDirection(String gateName);

    void setLeadToLocation(ILocation leadToLocation);

    void setState(int state);
    
}
