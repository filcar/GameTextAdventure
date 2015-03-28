/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import model.IItem;
import typeOfItem.IShootable;
import model.State;
import model.Weapon;

/**
 *
 * @author fil
 */
public class Shoot implements ICommand {
    private String name;

    public Shoot() {
        this.name="SHOOT";
    }


    @Override
    public String toString() {
        return "Shoot{" + "name=" + name + '}';
    }

    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void action (State curentState,String word2){
    //    curentState.showCurentState();
        if(curentState.getLocation().getMapItem().containsKey(word2)){
            IItem item =curentState.getLocation().getMapItem().get(word2);
            if(item instanceof IShootable){
                if (curentState.getPlayer().getCurrentItem() instanceof Weapon){
                    Weapon weapon=(Weapon)curentState.getPlayer().getCurrentItem();
                    Integer a =weapon.shoot((IShootable) item);
                    if(a<1) 
                        curentState.getLocation().removeItem(item);
                }
                else    System.out.println("You must have and use a weapon to shoot " +item.getName());
            }
            else System.out.println("\nYou can't shoot "+ word2 +".\n");
          //  curentState.showCurentState();
        }
        else if (word2.equals("NONE")) {
            System.out.println("What do you want to shoot?");        
        }
        else {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("There is'nt such item!");
            System.out.println("\n\n\n");
        }
    }  
    
}
