/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static controler.Lexer.tokenType;
import typeOfItem.ICanBePut;

/**
 *
 * @author fil
 */
public class BulletSet implements IItem,ICanBePut{
    String name;
    String state;
    Integer bullet=5;

    public BulletSet(String name) {
        this.name = name;
        tokenType.addList(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getState() {
        return state;
  
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    public Integer getBullet() {
        return bullet;
    }
    
    public void setBullet(int bullet) {
        this.bullet=bullet;
    }
    
}
