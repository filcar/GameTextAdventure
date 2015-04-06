/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import typeOfItem.IShootable;

/**
 *
 * @author fil
 */
public interface IWeapon extends IItem{

    int getDamages();

    String getName();

    void setDamages(int damages);

    void setName(String name);

    
}
