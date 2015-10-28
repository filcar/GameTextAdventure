/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controler.TokenType2;
import java.io.Serializable;

/**
 *
 * @author fil
 */
public class Food implements IItem,Ieatable, Serializable{
    private String name;
    private String state;
    private String imgFile="";
    private int energy;
    
    public Food() {
    }

    public Food(String name,TokenType2 tokenType) {
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

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
    
    @Override
    public String getState() {
        return state;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String getImgFile() {
        return imgFile;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }

    @Override
    public void regToToken(TokenType2 tokenType) {
        tokenType.addList(this);
    }

    
}
