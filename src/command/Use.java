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

/**
 *
 * @author fil
 */
public class Use implements ICommand {
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

    public Use(HashMap<String,Integer> syntaxs,TokenType2 tokenType) {
        this.name="USE";
        tokenType.addList(this);
        syntaxs.put("<"+name+">"+"<ITEM>", 2);
    }


    @Override
    public String toString() {
        return "Use{" + "name=" + name + '}';
    }

    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String action (State curentState,String word2){
    //    curentState.showCurentState();
        if(curentState.getPlayer().getMapItem().containsKey(word2)){
            IItem item =curentState.getPlayer().getMapItem().get(word2);
            curentState.getPlayer().setCurrentItem(item);
            result=("\nNow you can use the "+item.getName()+" .\n");
          //  curentState.showCurentState();
        }
        else if (word2.equals("NONE")) {
            result=("What do you want to use?");        
        }
        else {
            result=("I can't use this!!!");
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
