package edu.monash.prime;

import java.util.Scanner;

/**
 * 输入
 *
 * @author Lenovo
 * @date 2022/09/09
 */
public class Input
{
    /**
     * Default constructor
     */
    public Input()
    {

    }

    /**
     * Accept String input
     * This method is to accept string type input and only take the first letter.
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
}
