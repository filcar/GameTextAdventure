/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametextadventure;

import command.Close;
import command.Drop;
import command.Exit;
import command.Go;
import command.ICommand;
import command.Look;
import command.Open;
import command.Take;
import controler.HandlerCommand;
import java.util.Scanner;
import controler.Parser;
import model.Direction;
import model.DoorStateClose;
import model.DoorStateLock;
import model.DoorStateOpen;
//import model.DoorStateUnlock;
import model.Gate;
import model.IDoorState;
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
        ICommand drop = new Drop();
        ICommand exit = new Exit();
        ICommand look = new Look();
        ICommand open = new Open();
        ICommand close= new Close();
        
    //IDooreState
      //  IDoorState doorOpen = new DoorStateOpen();
        IDoorState doorClose = new DoorStateClose();
        IDoorState doorLock = new DoorStateLock();
       // IDoorState doorUnlock = new DoorStateUnlock();
        HandlerCommand hc = new HandlerCommand();
     //register commands
        hc.register(go);
        hc.register(take);
        hc.register(exit);
        hc.register(look);
        hc.register(drop);
        hc.register(open);
        hc.register(close);
        
    //Room
        ILocation room1  = new LocationRoom("Room1","This is the first room");
        ILocation room2  = new LocationRoom("Room2","This is the second room");
        ILocation room3  = new LocationRoom("Room3","This is the third room");
       
    //Gate of room
        IGate GateLoc1 = new Gate("blue",room1,room2);
        room1.registerGate(Direction.Direct.WEST,GateLoc1);
        room2.registerGate(Direction.Direct.EAST,GateLoc1);
        IGate GateLoc2 = new Gate("red",room2,room3);
              GateLoc2.setDoorState(doorClose);
        room2.registerGate(Direction.Direct.NORTH,GateLoc2);
 //       IGate southGateLoc3=new Gate("yelow",room3,room2);
        room3.registerGate(Direction.Direct.SOUTH,GateLoc2);
    //Items of room
        IItem key = new ItemKey("KEY");    
        room1.addItem(key);
        
    //initialize CurentState    
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
