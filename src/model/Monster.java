/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import typeOfItem.IShootable;
import java.util.HashMap;
import java.util.Random;
import typeOfItem.INonTakeable;

/**
 *
 * @author fil
 */
public class Monster implements IPlayer, IItem,IShootable,INonTakeable{
    private String name;    
    Random rand = new Random();
    private int health=(rand.nextInt(50))+70;

    private HashMap<String, IItem> mapItem = new HashMap<String, IItem>();
    
    public Monster() {
    }
    
    public Monster(String name) {
        this.name = name;
    }
    
    @Override
    public void addItem(IItem item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public HashMap<String, IItem> getMapItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void removeItem(IItem item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHealth(int health) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IItem getCurrentItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCurrentItem(IItem currentItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setState(String state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Integer shooting(Integer damage){
       health = health-damage;
       if (health<1) 
           System.out.println("You killed the "+this.getName());
       else if(health>1 && health<100)
           System.out.println("The "+this.getName()+" is still alive but they have "+this.getHealth()+"% health");    
       return health;
       } 
}
