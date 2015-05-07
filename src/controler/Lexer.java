/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author fil
 */
public class Lexer {
 
 //   public static TokenType2 tokenType=new TokenType2();
    
    public  ArrayList<Token> lex(String input, HashMap map) {
    // The tokens to return
        ArrayList<Token> tokens = new ArrayList<Token>();
       // input.replaceAll(" ","  ");
        input=" "+input+" ";
    // Lexer2 logic begins here
        StringBuilder tokenPatternsBuffer = new StringBuilder();

//------------------
  //  TokenType2 tokenType=new TokenType2();
        //map = tokenType.getTokenTypes();
        Iterator<TokType> keySetIterator = map.keySet().iterator();
        while(keySetIterator.hasNext()){
            TokType key = keySetIterator.next();
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", key, map.get(key)));
        }
//------------------
      //  Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));
        Pattern tokenPatterns = Pattern.compile(tokenPatternsBuffer.substring(1));
        // Begin matching tokens
        Matcher matcher = tokenPatterns.matcher(input.toUpperCase());

//------------------
        
    while (matcher.find()) {
        
        keySetIterator= map.keySet().iterator();
        while(keySetIterator.hasNext()){
            TokType key = keySetIterator.next(); 
            if (matcher.group(key.name()) != null) {
                tokens.add(new Token(key, matcher.group(key.name()).trim()));
                break;
            }
        }
}
//-----------------
 return tokens;
    }
    
}
