/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author fil
 */
public class Player implements IPlayer {
    private String name;
    private int health=100;
    private HashMap<String, IItem> mapItem = new HashMap<String, IItem>();
    private IItem currentItem;
    public Player() {
    }

     public Player(String name) {
        this.name = name;
    }
    
    @Override
    public IItem getCurrentItem() {
        return currentItem;
    }

    @Override
    public void setCurrentItem(IItem currentItem) {
        this.currentItem = currentItem;
    }

     
    @Override
    public void addItem (IItem item){
        mapItem.put(item.getName(), item);
    }
    @Override
    public void removeItem (IItem item){
        mapItem.remove(item.getName(), item);
    }    

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public HashMap<String, IItem> getMapItem() {
        return mapItem;
    }


    
}
