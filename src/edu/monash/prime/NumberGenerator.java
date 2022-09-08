package edu.monash.prime;


public class NumberGenerator
{
    //没有attributes,也需要default constructor
//    private String mode;

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
                // 若是偶数则会为0，并且个位数不为5,那么就不满足条件
                if (randomNumber % 2 != 0 && randomNumber % 10 != 5)
                {
                    break;
                }
            }
        }
        return randomNumber;
    }

}
