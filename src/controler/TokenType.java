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
import model.IPlayer;

/**
 *
 * @author fil
 */
public  class TokenType {

    private HashMap<String, String> tokenTypes = new HashMap<String, String>();
    private List<String> verbs = new ArrayList<String>();
    private List<String> nouns = new ArrayList<String>();
    private List<String> preposition = new ArrayList<String>();

    public TokenType() {
       String verb ="(GO|OPEN|CLOSE|DROP|EXIT|SHOOT|LOCK|LOOK|TAKE|UNLOCK|USE)";
       String direction="WEST|EAST|NORTH|SOUTH|NORTHWEST|NORTHEAST|SOUTHWEST|SOUTHEAST|UP|DOWN";
       String prepos ="(WITH|FOR|INTO|IN|BY)";
       String noun="(KEY|MONSTER|PISTOL)";
       
       tokenTypes.put("VERB", verb);
       tokenTypes.put("DIRECTION", direction);
       tokenTypes.put("PREPOSITION", prepos);
       tokenTypes.put("NOUN", noun);        
    }
    
    public void addHashmap (){
       String verb="";
       String noun="";
        Iterator<String> iterator = verbs.iterator();
	while (iterator.hasNext()) {
            verb=verb+"|"+(iterator.next());
	}
        verb="("+verb+")";
        iterator = nouns.iterator();
	while (iterator.hasNext()) {
            noun=noun+"|"+(iterator.next());
	}
        noun="("+noun+")";
        tokenTypes.put("VERB", verb);
        tokenTypes.put("NOUN", noun);
    }
    
    public void addList(Object obj){
        if (obj instanceof ICommand)
            verbs.add(((ICommand)obj).getName());
        if (obj instanceof IPlayer)
            nouns.add(((ICommand)obj).getName());
        if (obj instanceof IItem)
            nouns.add(((IItem)obj).getName());
        System.out.println(tokenTypes);
    }
    
    public HashMap<String, String> getTokenTypes() {
        return tokenTypes;
    }

    

    
}
