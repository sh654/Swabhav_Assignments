package com.techlabs.tictactoe;

public enum MarkType {
	 X(" X "), O(" O "), EMPTY(" - ");
	
	 private final String symbol;

	    MarkType(String symbol) {
	        this.symbol = symbol;
	    }

	    @Override
	    public String toString() {
	        return this.symbol;
	    }
}