/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import controler.TokenType2;
import java.util.HashMap;
import model.Food;
import model.IItem;
import model.Ieatable;
import model.State;

/**
 *
 * @author fil
 */
public class Eat implements ICommand{
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

    public Eat(HashMap<String,Integer> syntaxs,TokenType2 tokenType) {
        this.name="EAT";
        tokenType.addList(this);
        syntaxs.put("<"+name+">"+"<ITEM>", 2);
    }


    @Override
    public String toString() {
        return "Eat{" + "name=" + name + '}';
    }

    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String action (State curentState,String word2){
    //    curentState.showCurentState();     
         if(curentState.getPlayer().getMapItem().containsKey(word2)){
    //    if(curentState.getLocation().getMapItem().containsKey(word2)){
            IItem item =curentState.getPlayer().getMapItem().get(word2);
            if((item instanceof Ieatable)){
               int a= ((Food)item).getEnergy();
                curentState.getPlayer().setEnergy(a+curentState.getPlayer().getEnergy());
                curentState.getPlayer().removeItem(item);
                result=("\nEaten.\n");
            }
            else {
                result=("You can't eat "+item.getName());
            }
          //  curentState.showCurentState();
        }
        else if (word2.equals("NONE")) {
            result=("What do you want to eat?");        
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
