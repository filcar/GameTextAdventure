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
    
    public  ArrayList<Token> lex(String input) {
    // The tokens to return
        ArrayList<Token> tokens = new ArrayList<Token>();

    // Lexer2 logic begins here
        StringBuffer tokenPatternsBuffer = new StringBuffer();
//        for (TokenType tokenType : TokenType.values())
//            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
//------------------
    TokenType tokenType=new TokenType();
    HashMap map = tokenType.getTokenTypes();
    Iterator<String> keySetIterator = map.keySet().iterator();

    while(keySetIterator.hasNext()){
    String key = keySetIterator.next();
      //  System.out.println("key: " + key + " value: " + map.get(key));

        tokenPatternsBuffer.append(String.format("|(?<%s>%s)", key, map.get(key)));}
//------------------
        Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));
        // Begin matching tokens
        Matcher matcher = tokenPatterns.matcher(input);

//while (matcher.find()) {
//for(TokenType tokenType : TokenType.values()) {
//if (matcher.group(tokenType.name()) != null) {
//tokens.add(new Token(tokenType, matcher.group(tokenType.name())));
//break;
//------------------
        Iterator<String> keySetIterator1 = map.keySet().iterator();
while (matcher.find()) {
    while(keySetIterator1.hasNext()){
    String key = keySetIterator1.next(); 
if (matcher.group(key) != null) {
tokens.add(new Token(key, matcher.group(key)));
break;
//-----------------
}
}
}
 return tokens;
    }
    
}
