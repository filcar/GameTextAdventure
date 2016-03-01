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
public interface IPlayer {
    public IItem getCurrentItem();
    
    public void setCurrentItem(IItem currentItem);

    void addItem(IItem item);

    int getHealth();
    
    int getEnergy();

    HashMap<String, IItem> getMapItem();

    String getName();

    void removeItem(IItem item);

    void setHealth(int health);
    
    void setEnergy(int energy);

    void setName(String name);
    
    String damageAttack(IPlayer player);
    
}
