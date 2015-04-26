/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static controler.Lexer.tokenType;
import typeOfItem.IShootable;

/**
 *
 * @author fil
 */
public class DoorKey implements IItemKey {
    private String name;
    private String state;
  
    
    //isos mia lista apo pragamta poy mporei na kanei

    @Override
    public String getName() {
        return name;
        
    }

    public DoorKey(String name) {
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
