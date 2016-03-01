/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controler.TokenType2;

/**
 *
 * @author fil
 */
public interface IItem {

    String getName();

    String getState();

    void setName(String name);

    void setState(String state);
    
    void regToToken(TokenType2 tokenType);
    
    public String getImgFile();
    
}
