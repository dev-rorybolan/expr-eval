package app.belgarion.tech.expr_eval;

import java.util.ArrayList;

import java.util.Scanner;

public class Evaluator {
    public static void run() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression");
        String str = scanner.next();
        ArrayList<Token> tokens = Tokenizer.Tokenize(str);
        if (tokens.getFirst().TokenType != Tokens.INTEGER) throw new InvalidTokenException(tokens.getFirst());
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).TokenType == Tokens.INTEGER) {
                ArrayList<Token> number = nw();
                for (int j = i; j >= 0; j--) {
                    if (tokens.get(j).TokenType == Tokens.INTEGER) {
                        number.addFirst(tokens.get(j));
                    } else break;
                }

                for (int j = i; j < tokens.size(); j++ ) {
                    if (tokens.get(j).TokenType == Tokens.INTEGER) {
                        number.add(tokens.get(j));
                    } else break;
                }

            }
        }
    }
    public ArrayList<Token> MultiDigitInteger(ArrayList<Token> tokens) throws InvalidTokenException {
        ArrayList<Token> newTokenList = nw();
        ArrayList<Token> number = nw();
        Token individual;
        for (Token token : tokens) {
            if (token.TokenType == Tokens.INTEGER) {
                number.add(token);
            } else {
                newTokenList.add(TokenArrayToMultiDigitInt(number));
                newTokenList.add(token);
                number = nw();
            }
        }
    }
    public Token TokenArrayToMultiDigitInt(ArrayList<Token> num) throws InvalidTokenException {
        int val = 0;

        for (Token digit : num) {
            if (digit.TokenType != Tokens.INTEGER)
                throw new InvalidTokenException(digit);


            val = val * 10 + digit.value;
        }

        return new Token(Tokens.INTEGER, val);
    }

    public static <T> ArrayList<T> nw() {
        return new ArrayList<>();
    }

}
