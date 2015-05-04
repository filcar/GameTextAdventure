/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import controler.TokenType2;
import java.util.HashMap;
import java.util.Map;
import model.IItem;
import model.IPlayer;
import typeOfItem.IShootable;
import model.State;
import model.WeaponGun;

/**
 *
 * @author fil
 */
public class Shoot implements ICommand {
    private String name;


    public Shoot(HashMap<String,Integer> syntaxs,TokenType2 tokenType) {
        this.name="SHOOT";
        tokenType.addList(this);
        syntaxs.put("<"+name+">"+"<ITEM>", 2);
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
    public String action (State curentState,String word2){
         String result="";
    //    curentState.showCurentState();
        if(curentState.getLocation().getMapItem().containsKey(word2)){
            IItem item =curentState.getLocation().getMapItem().get(word2);
            if(item instanceof IShootable){
                if (curentState.getPlayer().getCurrentItem() instanceof WeaponGun){
                    WeaponGun weapon=(WeaponGun)curentState.getPlayer().getCurrentItem();
                    int a=weapon.shoot((IShootable) item);
                    result=((IShootable) item).getResult();
                    if(a==0) 
                    {
                        if ((item instanceof IPlayer) & !((IPlayer)item).getMapItem().isEmpty())
                            for (Map.Entry<String, IItem> entry : ((IPlayer)item).getMapItem().entrySet()) {
                            result = result+"\na "+entry.getKey()+" dropted from "+item.getName();                                
                            ((IPlayer)item).removeItem(entry.getValue());
                            curentState.getLocation().addItem(entry.getValue());
                        } 
                        curentState.getLocation().removeItem(item);
                    
                    }
                    if(a==1) {
                        result=((IShootable) item).getResult();
                        if (item instanceof IPlayer){
                            result = result+"\n"+((IPlayer)item).damageAttack(curentState.getPlayer());
                        }
                    }
                    if(a==-1) result=("You don't have any bullet!\n Your gun is empty!"); 
                }
                else    result=("You must have and use a weapon to shoot " +item.getName());
            }
            else result=("\nYou can't shoot "+ word2 +".\n");
          //  curentState.showCurentState();
        }
        else if (word2.equals("NONE")) {
            result=("What do you want to shoot?");        
        }
        else {
            result=("There is'nt such item!");
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
