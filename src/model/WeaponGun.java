/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controler.TokenType2;
import typeOfItem.ICanBePut;
import typeOfItem.ICanShoot;
import typeOfItem.IConteiner;
import typeOfItem.IShootable;

/**
 *
 * @author fil
 */
public class WeaponGun implements IWeapon, ICanShoot,IConteiner {
    private String name;
    private int bullet=5;
    private int damage=50;

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
            result = "Rest of "+bulletset.getName()+": "+temp;
        
        return result;
    }
    
}
