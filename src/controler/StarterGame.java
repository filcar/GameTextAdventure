/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import command.Close;
import command.Drop;
import command.Exit;
import command.Go;
import command.ICommand;
import command.Load;
import command.Lock;
import command.Look;
import command.Open;
import command.Put;
import command.Save;
import command.Shoot;
import command.Take;
import command.UnLock;
import command.Use;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import model.BulletSet;
import model.Direct2;
import model.DoorKey;
import model.DoorStateClose;
import model.DoorStateLock;
import model.Gate;
import model.IDoorState;
import model.IGate;
import model.IItem;
import model.ILocation;
import model.IPlayer;
import model.InstanceGame;
import model.LocationRoom;
import model.Monster;
import model.MultiGun;
import model.Player;
import model.State;
import model.WeaponGun;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;


/**
 *
 * @author fil
 */
public class StarterGame {
//initialization 
        HashMap<String,Integer>  syntaxs = new  HashMap<>();
        HashMap<String,ILocation> locations = new HashMap<>();
        TokenType2 tokenType=new TokenType2();   
        private InstanceGame instanceGame = new InstanceGame();
      //  COMMANDS
        IPlayer player = new Player("fil");
        ICommand go = new Go(syntaxs,tokenType);
        ICommand take = new Take(syntaxs,tokenType);
        ICommand drop = new Drop(syntaxs,tokenType);
        ICommand exit = new Exit(syntaxs,tokenType);
        ICommand look = new Look(syntaxs,tokenType);
        ICommand open = new Open(syntaxs,tokenType);
        ICommand close= new Close(syntaxs,tokenType);
        ICommand lock = new Lock(syntaxs,tokenType);
        ICommand unlock = new UnLock(syntaxs,tokenType);
        ICommand shoot= new Shoot(syntaxs,tokenType); 
        ICommand use =  new Use(syntaxs,tokenType);
        ICommand put = new Put(syntaxs,tokenType);
        ICommand save = new Save(syntaxs,tokenType,instanceGame);
        ICommand load = new Load(syntaxs,tokenType,instanceGame);
    //IDooreState
       IDoorState doorClose = new DoorStateClose();
        IDoorState doorLock = new DoorStateLock();
//Room
     // ground floor
        ILocation startupR;//  = new LocationRoom("startupRoom","This is the entrance of the player");
        ILocation filtersR;//  = new LocationRoom("filtersRoom","This is the filters' room");
        ILocation truncheonsR;//  = new LocationRoom("weaponsRoom","This is the weapons' room");
     // first floor
        ILocation witchNest;//  = new LocationRoom("witchNest","This is the nests of the witches");
        ILocation monsterLair;//  = new LocationRoom("monsterLair","This is the lairs of the monsters");
     // top floor
        ILocation treasureR;//  = new LocationRoom("treasureRoom","This is the treasure's room");
     // basement
        ILocation dungeonR;//  = new LocationRoom("dungeonRoom","This is the dungeon room");
//-------

//Items
        //startup room
//////        IItem key = new DoorKey("KEY",tokenType);
//////        IItem pistol = new WeaponGun("PISTOL",tokenType);
//////        IItem kalasnikof = new MultiGun("KALASNIKOF",tokenType);
//////        IItem monster = new Monster("MONSTER",tokenType);
//////        IItem bullet9 = new BulletSet("BULLET",tokenType);
        
        //filters room
//////        IItem aluminiumKey = new DoorKey("ALUMINIUMKEY",tokenType);
//////        IItem toadstools = new WeaponGun("TOADSTOOLS",tokenType);
//////        IItem belladonna = new WeaponGun("BELLADONNA",tokenType);
//////        IItem mandrake = new WeaponGun("MANDRAKE",tokenType);
//////        IItem cobra = new Monster("COBRA",tokenType);
//////        IItem viper = new Monster("VIPER",tokenType);
//////        IItem coralsnake = new Monster("CORALSNAKE",tokenType);
        
//////        //truncheons room
//////        IItem fashionKey = new DoorKey("FASHIONKEY",tokenType);
//////        IItem truncheon = new WeaponGun("TRUNCHEON",tokenType);
//////        IItem crossbow = new WeaponGun("CROSSBOW",tokenType);
//////        IItem yataghan = new WeaponGun("YATAGHAN",tokenType);
//////        IItem ork = new Monster("ORK",tokenType);
//////        IItem darkelf = new Monster("DARKELF",tokenType);
//////        IItem hecatonchires = new Monster("HECATONCHIRES",tokenType);
//////        
//////        //witch nest
//////        IItem goldenKey = new DoorKey("GOLDENKEY",tokenType);
//////        IItem blade = new WeaponGun("BLADE",tokenType);
//////        IItem hammer = new WeaponGun("HAMMER",tokenType);
//////        IItem kalchas = new Monster("KALCHAS",tokenType);
//////        IItem circe = new Monster("CIRCE",tokenType);
//////        IItem cassandra = new Monster("CASSANDRA",tokenType);
//////        
//////        //monster lair
//////        IItem silverKey = new DoorKey("SILVERKEY",tokenType);
//////        IItem scissors = new WeaponGun("SCISSORS",tokenType);
//////        IItem razors = new WeaponGun("RAZORS",tokenType);
//////        IItem griffin = new Monster("GRIFFIN",tokenType);
//////        IItem dragon = new Monster("DRAGON",tokenType);
//////        IItem centaur = new Monster("CENTAUR",tokenType);
//////        
//////        //treasure room
//////        IItem bronzeKey = new DoorKey("BRONZEKEY",tokenType);
//////        IItem diamondSword = new WeaponGun("DIAMONDSWORD",tokenType);
//////        IItem scepter = new WeaponGun("SCEPTER",tokenType);
//////        IItem elf = new Monster("ELF",tokenType);
//////        IItem dwarf = new Monster("DWARF",tokenType);
//////        IItem angel = new Monster("ANGEL",tokenType);
//////        
//////        //dungeon room
//////        IItem diamondKey = new DoorKey("DIAMONDKEY",tokenType);
//////        IItem doubleax = new WeaponGun("DOUBLEAX",tokenType);
//////        IItem bludgeon = new WeaponGun("BLUDGEON",tokenType);
//////        IItem drizzt = new Monster("DRIZZTDOURDEN",tokenType);
//////        IItem zaknafein = new Monster("ZAKNAFEIN",tokenType);
//////        IItem mielikki = new Monster("MIELIKKI",tokenType);
        private String result;
                //=============
        private IGate gateLoc1;
        private Object mapper;
        private State curentState;
        private HandlerCommand hc;
        //=============
        
public StarterGame() {
  loadNew(); 
    
     //initialize CurentState    
        curentState=new State(startupR, player);
        hc = new HandlerCommand(curentState);  
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
        hc.register(put);
        hc.register(save);
        hc.register(load);
                
        
//Gate of room
 
    
//////        gateLoc1 = new Gate("blue",startupR,filtersR,key);
//////        startupR.registerGate(Direct2.WEST,gateLoc1);
//////        filtersR.registerGate(Direct2.EAST,gateLoc1);
//////        
//////        IGate GateLoc2 = new Gate("red",startupR,truncheonsR,key);
//////       startupR.registerGate(Direct2.NORTH,GateLoc2);
//////        truncheonsR.registerGate(Direct2.SOUTH,GateLoc2);
//////        
//////        IGate GateLoc3 = new Gate("green",filtersR,witchNest);
//////        filtersR.registerGate(Direct2.UP,GateLoc3);
//////        witchNest.registerGate(Direct2.SOUTHWEST,GateLoc3);
//////        
//////        IGate GateLoc4 = new Gate("yellow",truncheonsR,monsterLair);
//////        truncheonsR.registerGate(Direct2.UP,GateLoc4);
//////        monsterLair.registerGate(Direct2.DOWN,GateLoc4);
//////        
//////        IGate GateLoc5 = new Gate("orange",witchNest,treasureR);
//////        witchNest.registerGate(Direct2.NORTHEAST,GateLoc5);
//////        treasureR.registerGate(Direct2.SOUTHWEST,GateLoc5);
//////        
//////        IGate GateLoc6 = new Gate("purple",monsterLair,treasureR);
//////        monsterLair.registerGate(Direct2.NORTHWEST,GateLoc6);
//////        treasureR.registerGate(Direct2.SOUTHEAST,GateLoc6);
//////        
//////        IGate GateLoc7 = new Gate("magenta",treasureR,filtersR);
//////        treasureR.registerGate(Direct2.WEST,GateLoc7);
//////        filtersR.registerGate(Direct2.WEST,GateLoc7);
//////        
//////        IGate GateLoc8 = new Gate("white",treasureR,truncheonsR);
//////        treasureR.registerGate(Direct2.EAST,GateLoc8);
//////        truncheonsR.registerGate(Direct2.NORTH,GateLoc8);
//////        
//////        IGate GateLoc9 = new Gate("black",witchNest,dungeonR);
//////        witchNest.registerGate(Direct2.WEST,GateLoc9);
//////        dungeonR.registerGate(Direct2.NORTHWEST,GateLoc9);
//////        
//////        IGate GateLoc10 = new Gate("turquoise",monsterLair,dungeonR);
//////        monsterLair.registerGate(Direct2.NORTHEAST,GateLoc10);
//////        dungeonR.registerGate(Direct2.EAST,GateLoc10);
//////        
//////        IGate GateLoc11 = new Gate("red",filtersR,dungeonR);
//////        filtersR.registerGate(Direct2.SOUTH,GateLoc11);
//////        dungeonR.registerGate(Direct2.UP,GateLoc11);
//////        
//////        IGate GateLoc12 = new Gate("green",truncheonsR,dungeonR);
//////        truncheonsR.registerGate(Direct2.SOUTHEAST,GateLoc12);
//////        dungeonR.registerGate(Direct2.NORTH,GateLoc12);
       

//Add Items to room
////        //startupR.addItem(key);
////        startupR.addItem(pistol);
////        startupR.addItem(kalasnikof);
////        startupR.addItem(monster);
////        startupR.addItem(bullet9);
////        ((IPlayer)monster).addItem(key);
        
////        filtersR.addItem(aluminiumKey);
////        filtersR.addItem(toadstools);
////        filtersR.addItem(belladonna);
////        filtersR.addItem(mandrake);
////        filtersR.addItem(cobra);
////        filtersR.addItem(viper);
////        filtersR.addItem(coralsnake);
////        
////        truncheonsR.addItem(fashionKey);
////        truncheonsR.addItem(truncheon);
////        truncheonsR.addItem(crossbow);
////        truncheonsR.addItem(yataghan);
////        truncheonsR.addItem(ork);
////        truncheonsR.addItem(darkelf);
////        truncheonsR.addItem(hecatonchires);
////        
////        witchNest.addItem(goldenKey);
////        witchNest.addItem(blade);
////        witchNest.addItem(hammer);
////        witchNest.addItem(kalchas);
////        witchNest.addItem(circe);
////        witchNest.addItem(cassandra);
//// 
////        monsterLair.addItem(silverKey);
////        monsterLair.addItem(scissors);
////        monsterLair.addItem(razors);
////        monsterLair.addItem(griffin);
////        monsterLair.addItem(dragon);
////        monsterLair.addItem(centaur);
////        
////        treasureR.addItem(bronzeKey);
////        treasureR.addItem(diamondSword);
////        treasureR.addItem(scepter);
////        treasureR.addItem(elf);
////        treasureR.addItem(dwarf);
////        treasureR.addItem(angel);
////        
////        dungeonR.addItem(diamondKey);
////        dungeonR.addItem(doubleax);
////        dungeonR.addItem(bludgeon);
////        dungeonR.addItem(drizzt);
////        dungeonR.addItem(zaknafein);
////        dungeonR.addItem(mielikki);
            tokenType.addHashmap();  
//////        
        instanceGame.setState(curentState);
        instanceGame.addLocations(startupR);        
        instanceGame.addLocations(filtersR);
        instanceGame.addLocations(truncheonsR);
        instanceGame.addLocations(witchNest);
        instanceGame.addLocations(monsterLair);
        instanceGame.addLocations(treasureR);
        instanceGame.addLocations(dungeonR);
//     
//////       locations.put(startupR.getLocationTitle(), startupR);
//////       locations.put(filtersR.getLocationTitle(), filtersR);
//////       locations.put(truncheonsR.getLocationTitle(), truncheonsR);
//////       locations.put(witchNest.getLocationTitle(), witchNest);
//////       locations.put(monsterLair.getLocationTitle(), monsterLair);
//////       locations.put(treasureR.getLocationTitle(), treasureR);   
//////       locations.put(dungeonR.getLocationTitle(), dungeonR);   
 
////json
//   
//        
//         Gson gson = new GsonBuilder().setPrettyPrinting().create();
//   //     Gson gson = new Gson();
//          String json = gson.toJson(locations);  
//        
//    
//  try {  
//   
//   FileWriter writer = new FileWriter("firstLoad.json");  
//   writer.write(json);  
//   writer.close();  
//    
//  } catch (IOException e) {  
//    e.printStackTrace();  
//  }  
//      
////end json
//jackson
//////	ObjectMapper mapper = new ObjectMapper();
//////        mapper.enableDefaultTyping();
//////        mapper.writerWithDefaultPrettyPrinter();
//////        
////// 
//////	try {
////// 		// convert user object to json string, and save to a file
//////		mapper.writeValue(new File("c:\\tmp\\test.json"),locations);
//////		// display to console
//////		//System.out.println(mapper.writeValueAsString(locations));
//////	} catch (JsonGenerationException e) {
//////		e.printStackTrace();
////// 	} catch (JsonMappingException e) {
////// 		e.printStackTrace();
////// 	} catch (IOException e) {
////// 		e.printStackTrace();
////// 	}
////// 
//////        
//////        
//end jackson
//loadNew();
 }



public String getResult() {        
        result = curentState.showCurentState();
        return result;
    }


public String go(String input){
       Parser parser= new Parser(hc,tokenType.getTokenTypes(),syntaxs);
       result=parser.parsing(input);
       return result;
    }   

public int getHealth(){
        int health=curentState.getPlayer().getHealth();
        return health;
    }

private void loadNew() {
//// GSON
//Gson gson = new Gson();
//    //Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
//    BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\fil\\tei\\Τεχνολογία Λογισμικού\\GameTextAdventure\\firstLoad1.json"));
//    Type listType = new TypeToken<HashMap<String,LocationRoom>>(){}.getType();
//    locations = gson.fromJson(br, listType);
//    for (ILocation loc_t:locations.values()) {
//        Iterator<IGate> iterG=loc_t.getMapGate().values().iterator();
//        while(iterG.hasNext()){
//            IGate gate = iterG.next();
//            gate.setJoinLocations(locations);
//        }
//    }
////end gson
//jackson
    ObjectMapper mapper = new ObjectMapper();
    mapper.enableDefaultTyping();
    
    try {
	locations = mapper.readValue(new File("test_2.json"), HashMap.class);
        for (ILocation loc_t:locations.values()) {
            Iterator<IGate> iterG=loc_t.getMapGate().values().iterator();
            while(iterG.hasNext()){
                IGate gate = iterG.next();
                gate.setJoinLocations(locations);
            }
            Iterator<IItem> iterI=loc_t.getMapItem().values().iterator();
            while(iterI.hasNext()){
                IItem item = iterI.next();
                item.regToToken(tokenType);
                if (item instanceof IPlayer){
                  IPlayer itemPlayer= (IPlayer)item;
                  Iterator<IItem> iter_pl=itemPlayer.getMapItem().values().iterator();
                  while(iter_pl.hasNext())
                  {
                      iter_pl.next().regToToken(tokenType);
                  }
                }
            }
        }
        startupR=locations.get("startupRoom");
        filtersR  = locations.get("filtersRoom");
        truncheonsR  = locations.get("weaponsRoom");
        witchNest  = locations.get("witchNest");
        monsterLair  = locations.get("monsterLair");
        treasureR  = locations.get("treasureRoom");
        dungeonR  = locations.get("dungeonRoom");

    } catch (JsonGenerationException e) {
		e.printStackTrace();
 	} catch (JsonMappingException e) {
 		e.printStackTrace();
 	} catch (IOException e) {
 		e.printStackTrace();
	}
     
//jackson
}
    
}
