/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author fil
 */
public interface IDoorState {
    void setState(String state);
    String getState();
    
    String open(Object obj);
    String close(Object obj);
    String lock(Object obj,IItemKey key);
    String unlock(Object obj,IItemKey key);
    
    
}
