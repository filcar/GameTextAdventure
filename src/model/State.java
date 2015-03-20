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
    IPlayer player;

    public IPlayer getPlayer() {
        return player;
    }

    public void setPlayer(IPlayer player) {
        this.player = player;
    }

    
    public State(ILocation location, IPlayer player) {
        this.location = location;
        this.player = player;
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
    System.out.println("Existing items in the room:"+location.getMapItem().keySet());
    System.out.println("There are exit to go:"+location.getMapGate().keySet());
    System.out.println("You have items:"+ player.getMapItem().keySet());
    System.out.println("\n\n\n");
}
}
