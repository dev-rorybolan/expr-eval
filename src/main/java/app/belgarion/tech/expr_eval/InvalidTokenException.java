package app.belgarion.tech.expr_eval;

public class InvalidTokenException extends Exception {
    public InvalidTokenException(Token token) {
        String message = "";
        if (token.TokenType == Tokens.INTEGER) {
            message = String.format("Incorrect use of token %d", token.value);
        } else {
            switch (token.TokenType) {
                case MULTIPLY -> message = "Incorrect use of token *";
                case DIVIDE -> message = "Incorrect use of token /";
                case MODULO -> message = "Incorrect use of token %";
                case MINUS -> message = "Incorrect use of token -";
                case PLUS -> message = "Incorrect use of token +";
            }
        }
        super(message);
    }
}
