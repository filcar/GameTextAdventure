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
public class State {
    ILocation location;

    public State(ILocation location) {
        this.location = location;
    }

    public ILocation getLocation() {
        return location;
    }

    public void setLocation(ILocation location) {
        this.location = location;
    }
    
    public void  showCurentState(){
    //Runtime.getRuntime().exec("cls");
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.println(location.getLocationTitle());
    System.out.println(location.getLocationDescription());
    System.out.println("There are exit to go:"+location.getMapGate().keySet());
    System.out.println("\n\n\n");
}
}
