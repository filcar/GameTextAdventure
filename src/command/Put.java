/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import controler.TokenType2;
import java.util.HashMap;
import model.IItem;
import model.State;
import typeOfItem.ICanBePut;
import typeOfItem.IConteiner;

/**
 *
 * @author fil
 */
public class Put implements ICommand {
    private String name;


    public Put(HashMap<String,Integer> syntaxs,TokenType2 tokenType) {
        this.name="PUT";
        tokenType.addList(this);
        syntaxs.put("<"+name+">"+"<ITEM><PREPOSITION><ITEM>", 4);
    }


    @Override
    public String toString() {
        return "Put{" + "name=" + name + '}';
    }

    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String action (State curentState,String word2){
         String result="";
    //    curentState.showCurentState();
//        if(curentState.getLocation().getMapItem().containsKey(word2)){
//            IItem item =curentState.getLocation().getMapItem().get(word2);
//            if(item instanceof ICanBePut){
//                if (curentState.getPlayer().getCurrentItem() instanceof IConteiner){
//                    IConteiner obj=(IConteiner)curentState.getPlayer().getCurrentItem();
//                    result=obj.put((ICanBePut) item);
//                }
//                else    result=("You must have and use something to put " +item.getName());
//            }
//            else result=("\nYou can't put "+ word2 +".\n");
//          //  curentState.showCurentState();
//        }
//        else if (word2.equals("NONE")) {
//            result=("What do you want to put?");        
//        }
//        else {
//            result=("There is'nt such item!");
//        }
        return result;
    }  
    
    @Override
    public String action1 (State curentState){
        String result=("Not implement!!!");
        return result;
    }
    
    @Override
    public String action2 (State curentState,String noun1, String prepos, String noun2){
        String result="";
           if(!curentState.getPlayer().getMapItem().containsKey(noun1))
               result="I don't have "+noun1;
           else if (!curentState.getPlayer().getMapItem().containsKey(noun2))
               result="I don't have "+noun2;
           else if (!prepos.matches("(IN)|(INTO)"))
               result="syntax error";
           else {
               IItem item1 =curentState.getPlayer().getMapItem().get(noun1);
               IItem item2 =curentState.getPlayer().getMapItem().get(noun2);
               if(item2 instanceof IConteiner){
                  if (item1 instanceof ICanBePut){
                    IConteiner obj=(IConteiner)item2;
                    result=obj.put((ICanBePut)item1);
                  }
                else    result=("I can't put " +item1.getName());
            }
               else result="oops!!!";
           }

        return result;
    }
}
