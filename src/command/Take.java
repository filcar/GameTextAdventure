/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import controler.TokenType2;
import java.util.HashMap;
import model.IItem;
import model.State;
import typeOfItem.INonTakeable;

/**
 *
 * @author fil
 */
public class Take implements ICommand {
    private String name;
    private String result="";
    private String description;

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Take(HashMap<String,Integer> syntaxs,TokenType2 tokenType) {
        this.name="TAKE";
        tokenType.addList(this);
        syntaxs.put("<"+name+">"+"<ITEM>", 2);
    }


    @Override
    public String toString() {
        return "Take{" + "name=" + name + '}';
    }

    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String action (State curentState,String word2){
    //    curentState.showCurentState();       
        if(curentState.getLocation().getMapItem().containsKey(word2)){
            IItem item =curentState.getLocation().getMapItem().get(word2);
            if(!(item instanceof INonTakeable)){
                curentState.getLocation().removeItem(item);
                curentState.getPlayer().addItem(item);
                result=("\nTaken.\n");
            }
            else {
                result=("You can't take "+item.getName());
            }
          //  curentState.showCurentState();
        }
        else if (word2.equals("NONE")) {
            result=("What do you want to take?");        
        }
        else {
            result=(word2+" doesn't exists!!");
        }    
        return result;
    }  
   
    @Override
    public String action1 (State curentState){
        String result=("Not implement!!!");
        return result;
    }
    
    @Override
    public String action2 (State curentState,String item1, String prepos, String item2){
        String result=("Not implement!!!");
        return result;
    }
}
