/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import controler.TokenType2;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.InstanceGame;
import model.State;

/**
 *
 * @author fil
 */
public class Save implements ICommand {
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

    public Save(HashMap<String,Integer> syntaxs,TokenType2 tokenType, InstanceGame instanceGame) {
        this.name="SAVE";
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
        String result=("Error!!!");
        return result;
   
    }

    @Override
    public String action1 (State curentState){
        String result;
        instanceGame.setState(curentState);
        try {
            result = saving();
        } catch (IOException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
            result = "Game is not saving";
        }
    return result;   
    } 
    public String saving() throws FileNotFoundException, IOException{
    // Write to disk with FileOutputStream
        FileOutputStream f_out = new FileOutputStream("myobject.txt");
    // Write object with ObjectOutputStream
        ObjectOutputStream obj_out = new ObjectOutputStream (f_out);
    // Write object out to disk
        obj_out.writeObject ( instanceGame );
        return "GAME SAVED!!";
    }
    
    @Override
    public String action2 (State curentState,String item1, String prepos, String item2){
        String result=("Error!!!");
        return result;
    }
}
