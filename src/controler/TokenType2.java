/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import command.ICommand;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import model.IItem;

/**
 *
 * @author fil
 */
public class TokenType2 {
    private HashMap<TokType, String> tokenTypes = new HashMap<TokType, String>();
    private List<String> verbs = new ArrayList<String>();
    private List<String> items = new ArrayList<String>();
    private List<String> gate = new ArrayList<String>();
    private List<String> directions= new ArrayList<String>();
    private List<String> preposition = new ArrayList<String>();
    String direction;
    String prepos;

    public TokenType2() {
     //  String verb =" (GO|OPEN|CLOSE|DROP|EXIT|SHOOT|LOCK|LOOK|TAKE|UNLOCK|USE) ";
       String verb ="\\b(GO|OPEN|EXIT)\\b";
       String item="\\b(MONSTER|PISTOL|KEY)\\b";  
       direction="\\b(WEST|EAST|NORTH|SOUTH|NORTHWEST|NORTHEAST|SOUTHWEST|SOUTHEAST|UP|DOWN)\\b";
       prepos ="\\b(WITH|FOR|INTO|IN|BY)\\b";
       tokenTypes.put(TokType.VERB, verb);
       tokenTypes.put(TokType.ITEM, item);    

    }
    
    public void addHashmap (){
       String verb="";
       String item="";
        
       Iterator<String> iterator = verbs.iterator();
       verb=(iterator.next());
	while (iterator.hasNext()) {
            verb=verb+"|"+(iterator.next());
	}
        verb="\\b("+verb+")\\b";
       
        Iterator<String> iterator1 = items.iterator();
	item=(iterator1.next());
        while (iterator1.hasNext()) {
            item=item+"|"+(iterator1.next());
	}
        item="\\b("+item+")\\b";
        tokenTypes.put(TokType.VERB, verb);
        tokenTypes.put(TokType.ITEM, item);
        tokenTypes.put(TokType.DIRECTION, direction);  
        tokenTypes.put(TokType.PREPOSITION, prepos);
    }
    
    public void addList(Object obj){
        if (obj instanceof ICommand)
            verbs.add(((ICommand)obj).getName());
//        if (obj instanceof IPlayer)
//            items.add(((IPlayer)obj).getName());
        if (obj instanceof IItem)
            items.add(((IItem)obj).getName());

    }
    
    public HashMap<TokType, String> getTokenTypes() {
      //  System.out.println(tokenTypes);
        return tokenTypes;
    }

//    public void setItems(List<String> items) {
//        this.items = items;
//    }

    
}
