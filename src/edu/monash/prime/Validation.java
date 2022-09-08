package edu.monash.prime;

public class Validation
{

    public Validation()
    {

    }

    /**
     * 检查名字
     *
     * @param input     输入
     * @param maxLength 最大长度
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
     * 检查数是质数
     *
     * @param number 数量
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

    public boolean checkAnswer(boolean isPrime, String userGuess)
    {
        return ((isPrime && userGuess.equalsIgnoreCase("Y")) ||
                (!isPrime && userGuess.equalsIgnoreCase("N")));
    }

}
