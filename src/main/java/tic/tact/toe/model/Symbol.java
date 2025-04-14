package tic.tact.toe.model;

public class Symbol {

    private char symbolChar;

    private String avatar;

    public Symbol(String avatar, char symbolChar) {
        this.avatar = avatar;
        this.symbolChar = symbolChar;
    }

    public char getSymbolChar() {
        return symbolChar;
    }

    public void setSymbolChar(char symbolChar) {
        this.symbolChar = symbolChar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
