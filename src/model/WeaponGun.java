/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controler.TokenType2;
import java.io.Serializable;
import typeOfItem.ICanBePut;
import typeOfItem.ICanShoot;
import typeOfItem.IConteiner;
import typeOfItem.IShootable;

/**
 *
 * @author fil
 */
public class WeaponGun implements IWeapon, ICanShoot,IConteiner,Serializable {
    private String name;
    private int bullet=5;
    private int damage=50;
    private String result;

    public WeaponGun(String name,TokenType2 tokenType) {
        this.name = name;
        tokenType.addList(this);
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
    public int shoot(IShootable obj){
        int temp=1;
        if(bullet<1){
            temp =-1;
        }
        else{
            if(obj.shooting(damage)<0) {
                temp=0;
            }
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
    
    @Override
    public String put(ICanBePut bullets){
        String result="";
        BulletSet bulletset= (BulletSet)bullets;
        int temp=bulletset.getBullet();
        Integer sumBullet=temp+bullet;
        Integer restBullet=sumBullet.compareTo(5);
        if(restBullet>=0)     {   
            bullet = 5;
            temp = sumBullet-bullet;
            bulletset.setBullet(temp);
        }
            result = name+" having now "+bullet+" bullets\nRest of "+bulletset.getName()+": "+temp;
        
        return result;
    }
    
}
