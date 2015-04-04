/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import model.State;

/**
 *
 * @author fil
 */
public interface ICommand {

    public String getName();
    public String action(State curentState,String word2);
    
}
