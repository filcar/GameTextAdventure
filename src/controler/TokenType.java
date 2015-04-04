/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author fil
 */
public enum TokenType {
            // Token types cannot have underscores
        VERB("(GO|SHOOT)"),PREPOSITION("(WITH|FOR|INTO|IN|BY)"),
        NOUN("(WEST|MONSTER|PISTOL)");//,WHITESPACE("[ \t\f\r\n]+");

        public final String pattern;

        private TokenType(String pattern) {
            this.pattern = pattern;
        }
    
}
