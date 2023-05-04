package org.example;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

import static org.example.getValue.getCurrValue;

public class terminalConversion {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        while (true) {
            System.out.println("Options: Convert");
            String option =  scan.nextLine();
            option = option.toLowerCase();
            switch (option) {
                case "convert" -> {
                    System.out.println("From currency: ");
                    String fromCurr = scan.nextLine();
                    System.out.println("To currency:");
                    String toCurr = scan.nextLine();
                    System.out.println("Value:");
                    String calc = scan.nextLine();
                    double calcValue = Double.parseDouble(calc);
                    double value = getCurrValue(fromCurr, toCurr) * calcValue;
                    value = Double.parseDouble(df.format(value));
                    System.out.println(calc + " " + fromCurr + " = " + value + " " + toCurr);
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}
