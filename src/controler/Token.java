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
public class Token {
    //    public TokenType type;
     public String type;
        public String data;

//        public Token(TokenType type, String data) {
         public Token(TokType type, String data) {
            this.type = type.name();
            this.data = data;
        }

    public String getType() {
        return type;
    }

        @Override
        public String toString() {
            return String.format("(%s %s)",type, data); //type.name(), data);
        }
}
