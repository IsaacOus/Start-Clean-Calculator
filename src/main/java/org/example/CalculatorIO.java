package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class CalculatorIO {
    private BufferedReader reader;
    private List<String> log;

    public CalculatorIO(String filename) throws IOException {
        this.reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(filename))));
        this.log = new ArrayList<>();
    }

    public List<Integer> readNumbers() throws IOException {
        List<Integer> numbers = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            numbers.add(Integer.parseInt(line));
        }
        return numbers;
    }

    public void writeNumber(int number) {
        System.out.println(number);
    }

    public void writeOutput(String output) {
        System.out.println(output);
    }

    public void writeTotal(int total, String operation) {
        String totalLine = String.format("-------\ntotal = %d (%s)", total, operation);
        System.out.println(totalLine);
    }

    public void writeLog(String message) {
        String logLine = String.format("[%06d:%06d][log] %s",
                System.currentTimeMillis() % 1000000,
                System.nanoTime() % 1000000,
                message);
        System.out.println(logLine);
        log.add(logLine);
    }

    public void close() throws IOException {
        reader.close();
    }

    public List<String> getLog() {
        return log;
    }
}
