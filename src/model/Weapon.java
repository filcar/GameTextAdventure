/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import typeOfItem.IShootable;

/**
 *
 * @author fil
 */
public class Weapon implements IWeapon {
    private String name;
    private int damage=50;

    public Weapon(String name) {
        this.name = name;
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
    public int getDamages() {
        return damage;
    }

    @Override
    public void setDamages(int damages) {
        this.damage = damages;
    }
    
    @Override
    public Integer shoot(IShootable obj){
        System.out.println("I shooted!!");
        return (obj.shooting(damage));
            
    }

    @Override
    public String getState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setState(String state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
