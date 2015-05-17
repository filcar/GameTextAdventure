/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import controler.StarterGame;
import controler.TokenType2;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.InstanceGame;
import model.State;

/**
 *
 * @author fil
 */
public class Load implements ICommand {
    private String name;
    private String result="";
    private String description;
    private InstanceGame instanceGame;
    
    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Load(HashMap<String,Integer> syntaxs,TokenType2 tokenType, InstanceGame instanceGame) {
        this.name="LOAD";
        tokenType.addList(this);
        syntaxs.put("<"+name+">", 1);
        this.instanceGame= instanceGame;

        
    }

    @Override
    public String toString() {
        return "Exit{" + "name=" + name + '}';
    }

    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String action (State curentState,String word2){
        result=("Error!!!");
        return result;
   
    }

    @Override
    public String action1 (State curentState){

        try {
            result = loading();
            curentState.setLocation(instanceGame.getState().getLocation());
            curentState.setPlayer(instanceGame.getState().getPlayer());
        } catch (IOException ex) {
            Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
           result = "Game is not loading"; 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
           result = "Game is not loading";  
        }
      
    return result;   
    } 
    public String loading() throws FileNotFoundException, IOException, ClassNotFoundException{
// Read from disk using FileInputStream
        FileInputStream f_in = new FileInputStream("myobject.txt");

// Read object using ObjectInputStream
        ObjectInputStream obj_in = new ObjectInputStream (f_in);

// Read an object
        instanceGame = (InstanceGame)obj_in.readObject();
        result= "GAME LOADED!!";
        return  result;
    }
    
    @Override
    public String action2 (State curentState,String item1, String prepos, String item2){
        String result=("Error!!!");
        return result;
    }
}
