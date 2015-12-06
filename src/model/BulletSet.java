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
    private String name;
    private String state;
    private Integer bullet=5;
    private String imgFile="/image/bullets.png";
    
    public BulletSet() {
    }
    
    public String getImgFile(){
    return imgFile;
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
