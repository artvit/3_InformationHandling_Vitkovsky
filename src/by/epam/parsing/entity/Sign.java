package by.epam.parsing.entity;

import by.epam.parsing.composite.LexemeLeaf;

public class Sign extends LexemeLeaf {
    private Character sign;

    public Sign(String sign) {
        this.sign = sign.charAt(0);
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return String.valueOf(sign);
    }
}
