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
import command.Lock;
import command.Look;
import command.Open;
import command.Shoot;
import command.Take;
import command.UnLock;
import command.Use;
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
import model.DoorKey;
import model.IItemKey;
import typeOfItem.IShootable;
import model.LocationRoom;
import model.Monster;
import model.Player;
import model.State;
import model.Weapon;

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
        ICommand lock = new Lock();
        ICommand unlock = new UnLock();
        ICommand shoot= new Shoot(); 
        ICommand use =  new Use();
        
        
    //IDooreState
        IDoorState doorClose = new DoorStateClose();
        IDoorState doorLock = new DoorStateLock();
        HandlerCommand hc = new HandlerCommand();
     //register commands
        hc.register(go);
        hc.register(take);
        hc.register(exit);
        hc.register(look);
        hc.register(drop);
        hc.register(open);
        hc.register(close);
        hc.register(lock);
        hc.register(unlock);
        hc.register(shoot);
        hc.register(use);
        
//Room
        ILocation room1  = new LocationRoom("Room1","This is the first room");
        ILocation room2  = new LocationRoom("Room2","This is the second room");
        ILocation room3  = new LocationRoom("Room3","This is the third room");
//Items
        IItem key = new DoorKey("KEY"); 
        IItem pistol = new Weapon("PISTOL");
        IItem monster = new Monster("MONSTER");  
        
        
//Gate of room
        IGate GateLoc1 = new Gate("blue",room1,room2);
        room1.registerGate(Direction.Direct.WEST,GateLoc1);
        room2.registerGate(Direction.Direct.EAST,GateLoc1);
        IGate GateLoc2 = new Gate("red",room2,room3,(IItemKey)key);
//              GateLoc2.setDoorState(doorLock);
        room2.registerGate(Direction.Direct.NORTH,GateLoc2);
        room3.registerGate(Direction.Direct.SOUTH,GateLoc2);

//Add Items to room
        room1.addItem(key);
        room1.addItem(pistol);
        room1.addItem(monster);
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
