package org.example;

class CalculatorEngine {
    private final Operation operation;
    private int total;

    public CalculatorEngine(Operation operation) {
        this.operation = operation;
    }

    public String processNumber(int number) {
        String output;
        if (total == 0) {
            output = String.valueOf(number);
            total = number;
        } else {
            output = String.format(" %s%d (= %d)", operation.getSymbol(), number, total);
            switch (operation) {
                case ADDITION:
                    total += number;
                    break;
                case SUBTRACTION:
                    total -= number;
                    break;
                case MULTIPLICATION:
                    total *= number;
                    break;
            }
        }
        return output;
    }

    public int getTotal() {
        return total;
    }
}
