package edu.monash.prime;


import java.util.Scanner;

public class PrimeChallenge
{
    //service class :test.NumberGenerator test.Validation test.Input test.Player
    //client class
    private Player player;
    private Validation validation;

    private int levelMaxNumber;

    private String mode;

    /**
     *
     */
    public PrimeChallenge()
    {
        player = new Player();//objects初始化
        validation = new Validation();
        levelMaxNumber = 0;
        mode = "easy";
    }

    /**
     * @param player
     * @param validation
     * @param levelMaxNumber
     * @param mode
     */
    public PrimeChallenge(Player player, Validation validation, int levelMaxNumber, String mode)
    {
        this.player = player;
        this.validation = validation;
        this.levelMaxNumber = levelMaxNumber;
        this.mode = mode;
    }

    public static void main(String[] args)
    {
        PrimeChallenge primeChallenge = new PrimeChallenge();
        primeChallenge.init();
    }

    public void init()
    {
        // display welcome  message
        displayWelcomeMessage();
        //ask user input his/her name -----独立的功能单独形成一个方法。
        askUserInputName();
        //ask user input level (1-100 / 1-400)
        // 1. 1-100
        // 2. 1-400
        start();
    }

    public void start()
    {
        while (true)
        {
            askUserInputLevel();
            // play game
            playGame(levelMaxNumber);
            System.out.println("是否下一轮？  Y/N");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            if ("N".equalsIgnoreCase(input))
            {
                break;
            }
            player.setTotalCorrect(0);
            player.setTotalScore(0);
        }
    }

    private void playGame(int maxNumber)
    {
        mode = "easy";
        for (int round = 1; round <= 3; round++)
        {
            System.out.println("Round " + round + " Start!");
            playRound(maxNumber);
            // show round score;
            calculateScore();
        }
        System.out.println(player);
        // 算平均分
        System.out.println("avg round score: " + (float) player.getTotalScore() / 3f);
    }

    private void calculateScore()
    {
        // 1.算出本轮正确数
        int roundScore = player.getRoundCorrect() == 10 ? 12 : player.getRoundCorrect();

        if (mode.equals("hard"))
        {
            roundScore = roundScore * 2;
        }

        if (player.getRoundCorrect() == 10)
        {
            mode = "hard";
        }

        // 2.把本轮分数赋值到本轮上
        player.setRoundScore(roundScore);
        // 3.把当轮正确数加到总正确数上，分数也如此
        player.setTotalScore(player.getTotalScore() + player.getRoundScore());
        player.setTotalCorrect(player.getTotalCorrect() + player.getRoundCorrect());
        // 4.打印输出该轮信息（当轮正确数、当轮获取的分数）

        System.out.println("Round end, your roundCorrect is : " + player.getRoundCorrect() + "   and roundScore is :" + player.getRoundScore());
        // 5.给当轮信息清零
        player.setRoundScore(0);
        player.setRoundCorrect(0);
    }

    private void playRound(int levelMaxNumber)
    {
        Input input = new Input();
        int randomNumber = 0;
        boolean switchBoolean = true;
        NumberGenerator numberGenerator = new NumberGenerator();
        for (int times = 1; times <= 10; times++)
        {
            if (switchBoolean)
            {
                randomNumber = numberGenerator.generateRandomNumber(levelMaxNumber, mode);
            }
            boolean isPrime = validation.checkNumberIsPrimeNumber(randomNumber);
            System.out.println("Number: " + randomNumber);
            char c = input.acceptCharInput("Your chose: (Y/N/Q)");

            String userGuess = c+"";
            //QYN 为 true
            boolean isYNQ = isInputYNQ(userGuess);
            // 不是YNQ
            if (!isYNQ){
                times--;
                switchBoolean = false;
                // 当前循环停止，开始下一轮循环
                continue;
            }
            // 是YNQ
            if (isYNQ)
            {
                // Q
                if ("Q".equalsIgnoreCase(userGuess)){
                    break;
                }else {
                    // YN
                    boolean isRightAnswer = validation.checkAnswer(isPrime, userGuess);
                    // YN 选择正确
                    if (isRightAnswer)
                    {
                        System.out.println("判断正确! 请继续");
                        player.setRoundCorrect(player.getRoundCorrect() + 1);
                        switchBoolean = true;
                    }else {
                        System.out.println("判断错误! 该轮结束");
                        switchBoolean = true;
                    }
                }
            }
        }
    }

    // 随机数。
    // 输入QYN。
    // 判断是否为QYN。
    // 如果是，判断是否符合答案。
    // 如果不是，重新输入。

    private boolean isInputYNQ(String userGuess)
    {
        if ("Q".equalsIgnoreCase(userGuess) || "N".equalsIgnoreCase(userGuess) || "Y".equalsIgnoreCase(userGuess))
        {
            return true;
        } else
        {
            return false;
        }
    }


    public void askUserInputLevel()
    {
        //validation
        Input input = new Input();
        String option = input.stringInput("Pleas, choose an option:  " +
                "(A. 1 - 100    " +
                "B. 1 - 400)");
        if (option.equalsIgnoreCase("A"))
        {
            levelMaxNumber = 100;
        } else if (option.equalsIgnoreCase("B"))
        {
            levelMaxNumber = 400;
        } else
        {
//             levelMaxNumber = 0;
            System.out.println("请输入A或B");
            // 递归调用
            askUserInputLevel();
        }
    }

    public void askUserInputName()
    {
//        boolean isValidName = false;
        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please, input your name: ");
            String name = scanner.nextLine();
            if (validation.checkName(name, 10))
            {
//                isValidName = true;
                player = new Player(name);
                System.out.println("Hi, " + player.getName());
                break;
            } else
            {
                System.out.println("Illegal");
            }
        }
    }

    public void displayWelcomeMessage()
    {
        System.out.println("Hi！welcome to the Game");
    }


}
