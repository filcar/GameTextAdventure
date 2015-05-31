/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controler.TokenType2;
import java.io.Serializable;
import typeOfItem.IShootable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import typeOfItem.INonTakeable;

/**
 *
 * @author fil
 */
public class Monster implements IPlayer, IItem,IShootable,INonTakeable,Serializable{
    private String name;    
    private Random rand = new Random();
    private int health=(rand.nextInt(50))+70;
    private int damage=(rand.nextInt(10))+5;
    private String result="";

    @Override
    public String damageAttack(IPlayer player) {
        int temp=player.getHealth()-damage;
        player.setHealth(temp);
        result = "Now it is angry, attacking you and causes -"+damage+" damage."
                   + "\n"+player.getName()+" having now "+player.getHealth()+ " life!!!";
        return result;
    }

    @Override
    public String getResult() {
        return result;
    }

    private HashMap<String, IItem> mapItem = new HashMap<String, IItem>();
    
    public Monster() {
    }
    
    public Monster(String name,TokenType2 tokenType) {
        this.name = name;
        tokenType.addList(this);
    }
    
    public void regToToken(TokenType2 tokenType){
        tokenType.addList(this);
    }
    
    @Override
    public void addItem(IItem item) {
        mapItem.put(item.getName(), item);
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public HashMap<String, IItem> getMapItem() {
        return mapItem;    
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void removeItem(IItem item) {
       mapItem.remove(item.getName(), item);
    }

    @Override
    public void setHealth(int health) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String name) {
      this.name = name;
    }

    @Override
    public IItem getCurrentItem() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    @Override
    public void setCurrentItem(IItem currentItem) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getState() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    @Override
    public void setState(String state) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Integer shooting(Integer damage){
       health = health-damage;
       if (health<1) {
           result=("You killed the "+this.getName());

       }
       else if(health>1 && health<100)
           result=("The "+this.getName()+" is still alive but it has "+this.getHealth()+"% health");    
       return health;
       } 
}
