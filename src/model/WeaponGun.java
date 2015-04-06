/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import typeOfItem.ICanShoot;
import typeOfItem.IShootable;

/**
 *
 * @author fil
 */
public class WeaponGun implements IWeapon, ICanShoot {
    private String name;
    private int bullet=5;
    private int damage=50;

    public WeaponGun(String name) {
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
     //   System.out.println("I shooted!!");
        int temp=1;
        if(bullet<1){
            temp =-1;
        }
        else{
            if(obj.shooting(damage)<0) temp=0;
            bullet=bullet-1;
        }
        return temp;
            
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
