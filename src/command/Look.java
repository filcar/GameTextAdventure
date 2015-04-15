/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import static controler.Lexer.tokenType;
import model.State;

/**
 *
 * @author fil
 */
public class Look implements ICommand {
    private String name;
    private String result="";

    public Look() {
        this.name="LOOK";
        tokenType.addList(this);
    }

    @Override
    public String toString() {
        return "Look{" + "name=" + name + '}';
    }

    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String action (State curentState,String word2){
       curentState.showCurentState();
       return result;
    }
    @Override
    public String action1 (State curentState){
       curentState.showCurentState();
       return result;
    }
    
}
