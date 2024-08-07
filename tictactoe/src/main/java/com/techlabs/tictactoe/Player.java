package com.techlabs.tictactoe;

public class Player {
    private String name;
    private MarkType mark;

    public Player(String name) {
        this.name = name;
        this.mark = MarkType.EMPTY;
    }

    public String getName() {
        return name;
    }

    public MarkType getMark() {
        return mark;
    }

    public void setMark(MarkType mark) {
        this.mark = mark;
    }
}
