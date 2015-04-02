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
//        ILocation room1  = new LocationRoom("Room1","This is the first room");
//        ILocation room2  = new LocationRoom("Room2","This is the second room");
//        ILocation room3  = new LocationRoom("Room3","This is the third room");
     // ground floor
        ILocation startupR  = new LocationRoom("startupRoom","This is the entrance of the player");
        ILocation filtersR  = new LocationRoom("filtersRoom","This is the filters' room");
        ILocation truncheonsR  = new LocationRoom("weaponsRoom","This is the weapons' room");
     // first floor
        ILocation witchNest  = new LocationRoom("witchNest","This is the nests of the witches");
        ILocation monsterLair  = new LocationRoom("monsterLair","This is the lairs of the monsters");
     // top floor
        ILocation treasureR  = new LocationRoom("treasureRoom","This is the treasure's room");
     // basement
        ILocation dungeonR  = new LocationRoom("dungeonRoom","This is the dungeon room");
                
//Items
        //startup room
        IItem key = new DoorKey("KEY");
        IItem pistol = new Weapon("PISTOL");
        IItem monster = new Monster("MONSTER");
        
        //filters room
        IItem aluminiumKey = new DoorKey("ALUMINIUMKEY");
        IItem toadstools = new Weapon("TOADSTOOLS");
        IItem belladonna = new Weapon("BELLADONNA");
        IItem mandrake = new Weapon("MANDRAKE");
        IItem cobra = new Monster("COBRA");
        IItem viper = new Monster("VIPER");
        IItem coralsnake = new Monster("CORALSNAKE");
        
        //truncheons room
        IItem fashionKey = new DoorKey("FASHIONKEY");
        IItem truncheon = new Weapon("TRUNCHEON");
        IItem crossbow = new Weapon("CROSSBOW");
        IItem yataghan = new Weapon("YATAGHAN");
        IItem ork = new Monster("ORK");
        IItem darkelf = new Monster("DARKELF");
        IItem hecatonchires = new Monster("HECATONCHIRES");
        
        //witch nest
        IItem goldenKey = new DoorKey("GOLDENKEY");
        IItem blade = new Weapon("BLADE");
        IItem hammer = new Weapon("HAMMER");
        IItem kalchas = new Monster("KALCHAS");
        IItem circe = new Monster("CIRCE");
        IItem cassandra = new Monster("CASSANDRA");
        
        //monster lair
        IItem silverKey = new DoorKey("SILVERKEY");
        IItem scissors = new Weapon("SCISSORS");
        IItem razors = new Weapon("RAZORS");
        IItem griffin = new Monster("GRIFFIN");
        IItem dragon = new Monster("DRAGON");
        IItem centaur = new Monster("CENTAUR");
        
        //treasure room
        IItem bronzeKey = new DoorKey("BRONZEKEY");
        IItem diamondSword = new Weapon("DIAMONDSWORD");
        IItem scepter = new Weapon("SCEPTER");
        IItem elf = new Monster("ELF");
        IItem dwarf = new Monster("DWARF");
        IItem angel = new Monster("ANGEL");
        
        //dungeon room
        IItem diamondKey = new DoorKey("DIAMONDKEY");
        IItem doubleax = new Weapon("DOUBLEAX");
        IItem bludgeon = new Weapon("BLUDGEON");
        IItem drizzt = new Monster("DRIZZTDOURDEN");
        IItem zaknafein = new Monster("ZAKNAFEIN");
        IItem mielikki = new Monster("MIELIKKI");
 
        
       
//Gate of room
    //    IGate GateLoc1 = new Gate("blue",room1,room2);
    //    room1.registerGate(Direction.Direct.WEST,GateLoc1);
    //    room2.registerGate(Direction.Direct.EAST,GateLoc1);
    //    IGate GateLoc2 = new Gate("red",room2,room3,(IItemKey)key);
//              GateLoc2.setDoorState(doorLock);
    //    room2.registerGate(Direction.Direct.NORTH,GateLoc2);
    //    room3.registerGate(Direction.Direct.SOUTH,GateLoc2);
        
    
        IGate GateLoc1 = new Gate("blue",startupR,filtersR);
        startupR.registerGate(Direction.Direct.WEST,GateLoc1);
        filtersR.registerGate(Direction.Direct.EAST,GateLoc1);
        
        IGate GateLoc2 = new Gate("red",startupR,truncheonsR);
        startupR.registerGate(Direction.Direct.NORTH,GateLoc2);
        truncheonsR.registerGate(Direction.Direct.SOUTH,GateLoc2);
        
        IGate GateLoc3 = new Gate("green",filtersR,witchNest);
        filtersR.registerGate(Direction.Direct.UP,GateLoc3);
        witchNest.registerGate(Direction.Direct.SOUTHWEST,GateLoc3);
        
        IGate GateLoc4 = new Gate("yellow",truncheonsR,monsterLair);
        truncheonsR.registerGate(Direction.Direct.UP,GateLoc4);
        monsterLair.registerGate(Direction.Direct.DOWN,GateLoc4);
        
        IGate GateLoc5 = new Gate("orange",witchNest,treasureR);
        witchNest.registerGate(Direction.Direct.NORTHEAST,GateLoc5);
        treasureR.registerGate(Direction.Direct.SOUTHWEST,GateLoc5);
        
        IGate GateLoc6 = new Gate("purple",monsterLair,treasureR);
        monsterLair.registerGate(Direction.Direct.NORTHWEST,GateLoc6);
        treasureR.registerGate(Direction.Direct.SOUTHEAST,GateLoc6);
        
        IGate GateLoc7 = new Gate("magenta",treasureR,filtersR);
        treasureR.registerGate(Direction.Direct.WEST,GateLoc7);
        filtersR.registerGate(Direction.Direct.WEST,GateLoc7);
        
        IGate GateLoc8 = new Gate("white",treasureR,truncheonsR);
        treasureR.registerGate(Direction.Direct.EAST,GateLoc8);
        truncheonsR.registerGate(Direction.Direct.NORTH,GateLoc8);
        
        IGate GateLoc9 = new Gate("black",witchNest,dungeonR);
        witchNest.registerGate(Direction.Direct.WEST,GateLoc9);
        dungeonR.registerGate(Direction.Direct.NORTHWEST,GateLoc9);
        
        IGate GateLoc10 = new Gate("turquoise",monsterLair,dungeonR);
        monsterLair.registerGate(Direction.Direct.NORTHEAST,GateLoc10);
        dungeonR.registerGate(Direction.Direct.EAST,GateLoc10);
        
        IGate GateLoc11 = new Gate("light blue",filtersR,dungeonR);
        filtersR.registerGate(Direction.Direct.SOUTH,GateLoc11);
        dungeonR.registerGate(Direction.Direct.UP,GateLoc11);
        
        IGate GateLoc12 = new Gate("light green",truncheonsR,dungeonR);
        truncheonsR.registerGate(Direction.Direct.SOUTHEAST,GateLoc12);
        dungeonR.registerGate(Direction.Direct.NORTH,GateLoc12);
       

//Add Items to room
        startupR.addItem(key);
        startupR.addItem(pistol);
        startupR.addItem(monster);
        
        filtersR.addItem(aluminiumKey);
        filtersR.addItem(toadstools);
        filtersR.addItem(belladonna);
        filtersR.addItem(mandrake);
        filtersR.addItem(cobra);
        filtersR.addItem(viper);
        filtersR.addItem(coralsnake);
        
        truncheonsR.addItem(fashionKey);
        truncheonsR.addItem(truncheon);
        truncheonsR.addItem(crossbow);
        truncheonsR.addItem(yataghan);
        truncheonsR.addItem(ork);
        truncheonsR.addItem(darkelf);
        truncheonsR.addItem(hecatonchires);
        
        witchNest.addItem(goldenKey);
        witchNest.addItem(blade);
        witchNest.addItem(hammer);
        witchNest.addItem(kalchas);
        witchNest.addItem(circe);
        witchNest.addItem(cassandra);
 
        monsterLair.addItem(silverKey);
        monsterLair.addItem(scissors);
        monsterLair.addItem(razors);
        monsterLair.addItem(griffin);
        monsterLair.addItem(dragon);
        monsterLair.addItem(centaur);
        
        treasureR.addItem(bronzeKey);
        treasureR.addItem(diamondSword);
        treasureR.addItem(scepter);
        treasureR.addItem(elf);
        treasureR.addItem(dwarf);
        treasureR.addItem(angel);
        
        dungeonR.addItem(diamondKey);
        dungeonR.addItem(doubleax);
        dungeonR.addItem(bludgeon);
        dungeonR.addItem(drizzt);
        dungeonR.addItem(zaknafein);
        dungeonR.addItem(mielikki);
        
        
        
    //initialize CurentState    
        State curentState=new State(startupR, player);
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
