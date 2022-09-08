package edu.monash.prime;


public class NumberGenerator
{
    //没有attributes,也需要default constructor
    private String mode;

    public NumberGenerator()
    {
        mode = "easy";
    }

    public NumberGenerator(String mode)
    {
        this.mode = mode;
    }

    public int generateRandomNumber(int maxNumber)
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
                // 若是偶数则会为0，那么就不满足条件，并且个位数不为5
                if (randomNumber % 2 != 0 && randomNumber % 10 != 5)
                {
                    break;
                }
            }
        }
        return randomNumber;
    }

}
