/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametextadventure;

import command.Exit;
import command.Go;
import command.ICommand;
import command.Look;
import command.Take;
import controler.HandlerCommand;
import java.util.Scanner;
import controler.Parser;
import model.Gate;
import model.IGate;
import model.IItem;
import model.ILocation;
import model.IPlayer;
import model.ItemKey;
import model.LocationRoom;
import model.Player;
import model.State;

/**
 *
 * @author fil
 */
public class GameTextAdventure {

    /**
     * @param args the command line arguments
     */
 public static void main(String[] args) {
    //initialization    
        boolean running = true;
        IPlayer player = new Player("fil");
        ICommand go = new Go();
        ICommand take = new Take();
        ICommand exit = new Exit();
        ICommand look = new Look();
        HandlerCommand hc = new HandlerCommand();
     //register commands
        hc.register(go);
        hc.register(take);
        hc.register(exit);
        hc.register(look);

    //Room
        ILocation room1  = new LocationRoom("Room1","This is the first room");
        ILocation room2  = new LocationRoom("Room2","This is the second room");
        ILocation room3  = new LocationRoom("Room3","This is the third room");
        
    //Gate of room
        IGate westGateLoc1 = new Gate("WEST",room2);
        IItem key = new ItemKey("KEY");
        room1.registerGate(westGateLoc1);
        room1.addItem(key);
        IGate eastGateLoc2 = new Gate("EAST",room1); 
        room2.registerGate(eastGateLoc2);
        IGate northGateLoc2=new Gate("NORTH",room3);
        room2.registerGate(northGateLoc2);
        IGate southGateLoc3=new Gate("SOUTH",room2);
        room3.registerGate(southGateLoc3);
    //initialize State    
        State curentState=new State(room1, player);
        curentState.showCurentState();
    //loop fo running
    while(running){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        Parser parser= new Parser(input);
        String word1 = parser.getCommand().toUpperCase();
        String word2 = parser.getObject().toUpperCase();
        hc.handle(word1, word2,curentState);
        
    }        
        
    }
    
}
