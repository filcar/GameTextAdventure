/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import model.IItem;
import model.State;

/**
 *
 * @author fil
 */
public class Use implements ICommand {
    private String name;

    public Use() {
        this.name="USE";
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
    public void action (State curentState,String word2){
    //    curentState.showCurentState();
        if(curentState.getPlayer().getMapItem().containsKey(word2)){
            IItem item =curentState.getPlayer().getMapItem().get(word2);
            curentState.getPlayer().setCurrentItem(item);
            System.out.println("\nNow you can use the "+item.getName()+" .\n");
          //  curentState.showCurentState();
        }
        else if (word2.equals("NONE")) {
            System.out.println("What do you want to use?");        
        }
        else {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("I can't use this!!!");
            System.out.println("\n\n\n");
        }
    }  
    
}
