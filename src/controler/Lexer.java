/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author fil
 */
public class Lexer {
 
    public static TokenType2 tokenType=new TokenType2();
    
    public  ArrayList<Token> lex(String input) {
    // The tokens to return
        ArrayList<Token> tokens = new ArrayList<Token>();

    // Lexer2 logic begins here
        StringBuffer tokenPatternsBuffer = new StringBuffer();

//------------------
  //  TokenType2 tokenType=new TokenType2();
    HashMap map = tokenType.getTokenTypes();
    Iterator<TokType> keySetIterator = map.keySet().iterator();
    while(keySetIterator.hasNext()){
    TokType key = keySetIterator.next();
      //  System.out.println("key: " + key + " value: " + map.get(key));
        tokenPatternsBuffer.append(String.format("|(?<%s>%s)", key, map.get(key)));}
//------------------
        Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));
        // Begin matching tokens
        Matcher matcher = tokenPatterns.matcher(input.toUpperCase());

//while (matcher.find()) {
//for(TokenType tokenType : TokenType.values()) {
//if (matcher.group(tokenType.name()) != null) {
//tokens.add(new Token(tokenType, matcher.group(tokenType.name())));
//break;
//------------------
        
while (matcher.find()) {
    keySetIterator= map.keySet().iterator();
        while(keySetIterator.hasNext()){
        TokType key = keySetIterator.next(); 
        if (matcher.group(key.name()) != null) {
            tokens.add(new Token(key, matcher.group(key.name()).trim()));
        break;
//-----------------
}
}
}
 return tokens;
    }
    
}
