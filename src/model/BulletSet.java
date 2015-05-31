/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controler.TokenType2;
import java.io.Serializable;
import typeOfItem.ICanBePut;

/**
 *
 * @author fil
 */
public class BulletSet implements IItem,ICanBePut,Serializable{
    String name;
    String state;
    Integer bullet=5;

    public BulletSet() {
    }

    public BulletSet(String name,TokenType2 tokenType) {
        this.name = name;
        tokenType.addList(this);
    }
    
    public void regToToken(TokenType2 tokenType){
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
