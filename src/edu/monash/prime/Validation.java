package edu.monash.prime;

public class Validation {

    public Validation()
    {

    }

    public boolean checkName(String input, int maxLength)
    {
        for (int i = 0; i < input.length(); i++)
        {
            if ((Character.isAlphabetic(input.charAt(i))))
            {

            }else {
                return false;
            }
        }
        return input.length() <= maxLength;
    }

}
