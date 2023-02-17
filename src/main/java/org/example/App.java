package org.example;

import java.io.IOException;
import java.util.List;


public class App {
    public static void main(String[] args) throws IOException {
        if (args.length < 2 || args.length > 3) {
            System.err.println("Usage: calc <filename> <+|-|*> [-log]");
            System.exit(1);
        }

        String filename = args[0];
        Operation operation = getOperation(args[1]);
        boolean logging = args.length == 3 && args[2].equals("-log");

        CalculatorIO io = new CalculatorIO(filename);
        List<Integer> numbers = io.readNumbers();

        CalculatorEngine engine = new CalculatorEngine(operation);

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            String output = engine.processNumber(number);
            io.writeOutput(output);
            if (logging) {
                io.writeLog("parsed value = " + number);
                io.writeLog("accumulation : " + engine.getTotal() + " on line " + i);
            }
        }

        int total = engine.getTotal();
        io.writeTotal(total, operation.getSymbol());
        if (logging) {
            io.writeLog("applying operation " + operation.name().toLowerCase());
            io.writeLog("end of program");
        }
        io.close();
    }

    private static Operation getOperation(String opString) {
        for (Operation op : Operation.values()) {
            if (op.getSymbol().equals(opString)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Invalid operation: " + opString);
    }
}
