package org.example;

enum Operation {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*");

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
