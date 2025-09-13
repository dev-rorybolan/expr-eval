package app.belgarion.tech.expr_eval;

import org.jetbrains.annotations.Nullable;

public class Token {
    public Tokens TokenType;
    @Nullable public Integer value;

    public Token(Tokens type, @Nullable Integer value) {
        this.TokenType = type;
        this.value = value;
    }
}
