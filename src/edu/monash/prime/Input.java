package edu.monash.prime;

import java.util.Scanner;

public class Input {

    /**
     * Accept String input
     * This method is to give a hint and accept string type input.
     *
     * @param message
     * @return {@link String}
     */
    public String stringInput(String message)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    /**
     * Accept String input
     * This method is to give a hint and accept string type input and only take the first letter.
     *
     * @param message
     * @return char
     */
    public char acceptCharInput(String message)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine().charAt(0);
    }

}
