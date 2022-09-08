package edu.monash.prime;

import java.util.Scanner;

public class Input {

    public String stringInput(String message)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public char acceptCharInput(String message)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine().charAt(0);
    }

}
