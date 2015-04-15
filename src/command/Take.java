/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import static controler.Lexer.tokenType;
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

    public Take() {
        this.name="TAKE";
        tokenType.addList(this);
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
            result=("I can't take this!!!");
        }    
        return result;
    }  
   
    @Override
    public String action1 (State curentState){
        String result=("Not implement!!!");
        return result;
    }
}
