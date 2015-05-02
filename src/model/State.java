/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Iterator;
import java.util.Map.Entry;

/**
 *
 * @author fil
 */
public class State {
    ILocation location;
    IPlayer player;
    String direction;


    public void setPlayer(IPlayer player) {
        this.player = player;
    }
    
    public IPlayer getPlayer() {
        return player;
    }
    
    public State(ILocation location, IPlayer player) {
        this.location = location;
        this.player = player;
    }
    public void setLocation(ILocation location) {
        this.location = location;
    }
    
    public ILocation getLocation() {
        return location;
    }
    
    public void  showCurentState(){
    //Runtime.getRuntime().exec("cls");
        String result1="\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n->"+location.getLocationTitle();
        result1=result1+"\n"+(location.getLocationDescription());
    //Λήψη στοιχείων για τις εξόδους
        Iterator<IGate> gateIterator = location.getMapGate().values().iterator();
        while(gateIterator.hasNext()){
            IGate door = gateIterator.next();
            String doorState = door.getDoorState().getState();
            ILocation nextLocation = door.getLeadToLocation(location);
            String leads = nextLocation.getLocationTitle();
        //--------Λήψη του direction από το Hasmap
            for (Entry<String, IGate> entry : location.getMapGate().entrySet()) {
                if (entry.getValue().equals(door)) {
                    direction=entry.getKey();
                }
            }
        //-----------
            result1=result1+"\n"+("At the "+ direction +" there is a "+doorState+" "+door.getName()+" door that leads to "+leads+".");
        
        } 
    result1=result1+("\nExisting items in the room:"+location.getMapItem().keySet());
    result1=result1+("\n=========ABOUT YOU==========");
    if(player.getMapItem().isEmpty())
        result1=result1+("\nYou haven't taken any item!!!");
    else
        result1=result1+("\nYou have taken these items:"+ player.getMapItem().keySet().toString());
    if (player.getCurrentItem()==null){}
    else 
        result1=result1+("\nYou have a "+player.getCurrentItem().getName().toLowerCase()+" in your hands");
    System.out.println(result1+"\n\n\n");
    
//    System.out.println("There are exit to go:"+location.getMapGate().keySet());
    
}
}
