/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controler.TokenType2;
import java.io.Serializable;
import typeOfItem.IShootable;

/**
 *
 * @author fil
 */
public class DoorKey implements IItem, IItemKey,Serializable {
    private String name;
    private String state;
    private String imgFile="/image/key.png";

    public DoorKey() {
    }

    public String getImgFile() {
        return imgFile;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }
  
    public void regToToken(TokenType2 tokenType){
        tokenType.addList(this);
    }    
    //isos mia lista apo pragamta poy mporei na kanei

    @Override
    public String getName() {
        return name;
        
    }

    public DoorKey(String name,TokenType2 tokenType) {
        this.name = name;
        tokenType.addList(this);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }
    
}
