package edu.monash.prime;

/**
 * 数字生成器
 *
 * @author Lenovo
 * @date 2022/09/09
 */
public class NumberGenerator
{
    /**
     * NumberGenerator
     * This is a default constructor
     */
    public NumberGenerator()
    {

    }

    /**
     * generateRandomNumber
     * This is a method to generate random number between one to maximum number
     * and by easy mode or hard mode.
     *
     * @param maxNumber
     * @param mode
     * @return int
     */
    public int generateRandomNumber(int maxNumber,String mode)
    {
        int randomNumber;
        if ("easy".equals(mode))
        {
            randomNumber = (int) (Math.random() * maxNumber + 1);
        } else
        {
            while (true)
            {
                randomNumber = (int) (Math.random() * maxNumber + 1);
                //
                if (randomNumber % 2 != 0 && randomNumber % 10 != 5)
                {
                    break;
                }
            }
        }
        return randomNumber;
    }
}
