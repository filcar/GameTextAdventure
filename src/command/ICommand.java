/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.util.HashMap;
import model.State;

/**
 *
 * @author fil
 */
public interface ICommand {

    public String getName();
    public String action1(State curentState);
    public String action(State curentState,String word2);
    static public HashMap<String,Integer> syntaxs = new HashMap<>();
    
}
