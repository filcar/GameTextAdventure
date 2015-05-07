/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

//import static controler.Lexer.tokenType;
import controler.TokenType2;
import java.util.HashMap;
import model.IItem;
import model.State;

/**
 *
 * @author fil
 */
public class Drop implements ICommand {
    private String name;
    private String result="";

    public Drop(HashMap<String,Integer> syntaxs,TokenType2 tokenType) {
        this.name="DROP";
        tokenType.addList(this);
        syntaxs.put("<"+name+">"+"<ITEM>", 2);
    }


    @Override
    public String toString() {
        return "Drop{" + "name=" + name + '}';
    }

    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String action (State curentState,String word2){
    //    curentState.showCurentState();
        if(curentState.getPlayer().getMapItem().containsKey(word2)){
            IItem item =curentState.getPlayer().getMapItem().get(word2);
            if(!(curentState.getPlayer().getCurrentItem()==null) 
                    && curentState.getPlayer().getCurrentItem().equals(item))
                curentState.getPlayer().setCurrentItem(null);
            curentState.getPlayer().removeItem(item);            
            curentState.getLocation().addItem(item);
            result=("\nDropped.\n");
           // curentState.showCurentState();
        }
        else {
            result=("I can't drop this!!!");
        }
        return result;
    }  
    
    @Override
    public String action1 (State curentState){
        result=("Not implement!!!");
        return result;
    }
    
    @Override
    public String action2 (State curentState,String item1, String prepos, String item2){
        String result=("Not implement!!!");
        return result;
    }
    
}
