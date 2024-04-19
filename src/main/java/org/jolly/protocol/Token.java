package org.jolly.protocol;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author jolly
 */
public interface Token {
    Token NULL_STRING = bulkString(null);
    Token RESPONSE_OK = string("OK");
    TokenType getType();
    static Token nullString() {
        return NULL_STRING;
    }
    static Token responseOk() {
        return RESPONSE_OK;
    }
    static Token string(String str) {
        return new StringToken(str);
    }
    static Token bulkString(String str) {
        return new BulkStringToken(str);
    }
    static Token integer(int i) {
        return new IntegerToken(i);
    }
    static Token bool(boolean b) {
        return new IntegerToken(b ? 1 : 0);
    }
    static Token err(String str) {
        return new ErrorToken(str);
    }
    static Token array(Token... tokens) {
        return new ArrayToken(Arrays.asList(tokens));
    }
    static Token array(Collection<Token> tokens) {
        return new ArrayToken(tokens);
    }
}
