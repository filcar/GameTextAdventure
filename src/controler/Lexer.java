/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.ArrayList;
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
        for (TokenType tokenType : TokenType.values())
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
        Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));
        // Begin matching tokens
        Matcher matcher = tokenPatterns.matcher(input);
//        while (matcher.find()) {
//            if (matcher.group(TokenType.VERB.name()) != null) {
//                tokens.add(new Token(TokenType.VERB, matcher.group(TokenType.VERB.name())));
//                continue;
//            }   else if (matcher.group(TokenType.NOUN.name()) != null) {
//                tokens.add(new Token(TokenType.NOUN, matcher.group(TokenType.NOUN.name())));
//                continue;
//            } else if (matcher.group(TokenType.PREPOSITION.name()) != null) {
//                tokens.add(new Token(TokenType.PREPOSITION, matcher.group(TokenType.PREPOSITION.name())));
//                continue;
//            } else if (matcher.group(TokenType.NOUN2.name()) != null) {
//                tokens.add(new Token(TokenType.NOUN2, matcher.group(TokenType.NOUN2.name())));
//                continue;
//            } else if (matcher.group(TokenType.WHITESPACE.name()) != null)
//                continue;
//        }
while (matcher.find()) {
for(TokenType tokenType : TokenType.values()) {
if (matcher.group(tokenType.name()) != null) {
tokens.add(new Token(tokenType, matcher.group(tokenType.name())));
break;
}
}
}
 return tokens;
    }
    
}
