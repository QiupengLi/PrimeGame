package edu.monash.prime;

public class Validation
{

    /**
     * default constructor
     * This method is to initialise the validation class.
     */
    public Validation()
    {

    }

    /**
     * Check validity of name
     * This mathod is to check the validity of name.
     *
     * @param input
     * @param maxLength
     * @return boolean
     */
    public boolean checkName(String input, int maxLength)
    {
        for (int i = 0; i < input.length(); i++)
        {
            if (!Character.isAlphabetic(input.charAt(i)))
            {
                return false;
            }
        }
        return input.length() <= maxLength;
    }


    /**
     * Check if number is prime number
     * This method is to check if number is a prime number.
     *
     * @param number random number generate from NumberGenerator
     * @return boolean
     */
    public boolean checkNumberIsPrimeNumber(int number)
    {
        //12
        if (number == 1)
        {
            return false;
        }
        for (int i = 2; i <= number / 2; i++)
        {
            if (number % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * check player guess if is right.
     * This method is to check if player guess and prime match.
     *
     * @param isPrime   taken from checkNumberIsPrimeNumber method
     * @param playerGuess player's answer
     * @return boolean
     */
    public boolean checkAnswer(boolean isPrime, String playerGuess)
    {
        return ((isPrime && playerGuess.equalsIgnoreCase("Y")) ||
                (!isPrime && playerGuess.equalsIgnoreCase("N")));
    }

}


