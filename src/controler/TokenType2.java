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
import java.util.Map;
import model.IItem;
import model.IPlayer;

/**
 *
 * @author fil
 */
public class TokenType2 {

    private HashMap<TokType, String> tokenTypes = new HashMap<>();
    private List<String> verbs = new ArrayList<String>();
    private List<String> items = new ArrayList<String>();
    private List<String> gate = new ArrayList<String>();
    private List<String> directions= new ArrayList<String>();
    private List<String> preposition = new ArrayList<String>();

    public TokenType2() {
     //  String verb =" (GO|OPEN|CLOSE|DROP|EXIT|SHOOT|LOCK|LOOK|TAKE|UNLOCK|USE) ";
        String verb =" (OPEN) ";
       String item="(MONSTER|PISTOL|KEY) ";  
       String direction="(WEST|EAST|NORTH|SOUTH|NORTHWEST|NORTHEAST|SOUTHWEST|SOUTHEAST|UP|DOWN) ";
       String prepos ="(WITH|FOR|INTO|IN|BY) ";
       tokenTypes.put(TokType.VERB, verb);
       tokenTypes.put(TokType.ITEM, item);    
       tokenTypes.put(TokType.DIRECTION, direction);  
       tokenTypes.put(TokType.PREPOSITION, prepos);
    }
    
    public void addHashmap (){
       String verb="";
       String item="";
        Iterator<String> iterator = verbs.iterator();
	while (iterator.hasNext()) {
            verb=verb+"|"+(iterator.next());
	}
        verb=" ("+verb+") ";
        iterator = items.iterator();
	while (iterator.hasNext()) {
            item=item+"|"+(iterator.next());
	}
        item="("+item+") ";
        tokenTypes.put(TokType.VERB, verb);
        tokenTypes.put(TokType.ITEM, item);
    }
    
    public void addList(Object obj){
        if (obj instanceof ICommand)
            verbs.add(((ICommand)obj).getName());
//        if (obj instanceof IPlayer)
//            items.add(((IPlayer)obj).getName());
        if (obj instanceof IItem)
            items.add(((IItem)obj).getName());
        addHashmap();
        System.out.println(tokenTypes);
    }
    
    public HashMap<TokType, String> getTokenTypes() {
        return tokenTypes;
    }

    
}
