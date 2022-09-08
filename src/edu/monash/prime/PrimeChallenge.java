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
     * default constructor
     * this method is for initialising
     */
    public PrimeChallenge()
    {
        player = new Player();
        validation = new Validation();
        levelMaxNumber = 0;
        mode = "easy";
    }

    /**
     * non-default constructor
     * this method is a non-default constructor
     *
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

    /**
     * main
     * This is an accessor of code
     *
     * @param args
     */
    public static void main(String[] args)
    {
        PrimeChallenge primeChallenge = new PrimeChallenge();
        primeChallenge.start();
    }

    /**
     * Process start
     */


    /**
     * This method is to start game again and again.
     */
    public void start()
    {
        while (true)
        {
            // display welcome  message
            displayWelcomeMessage();
            //ask user input his/her name
            askPlayerInputName();
            askPlayerInputLevel();
            // play game
            playGame(levelMaxNumber);
            System.out.println("Do you want to play again?  Y/N");
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

    /**
     * Play game
     * This method is to start a game.
     *
     * @param maxNumber 最大数量
     */
    private void playGame(int maxNumber)
    {
        mode = "easy";
        for (int round = 1; round <= 3; round++)
        {
            System.out.println("-----Round " + round + " Start!-----");
            playRound(maxNumber);
            // show round score;
            calculateScore();
        }
        System.out.println(player);
        // calculate average score.
        System.out.println("Your average round score: " + (float) player.getTotalScore() / 3f);
    }

    /**
     * This method is to calculate the score of player
     */
    private void calculateScore()
    {
        // 1.Use this to increase the bonus and get round's correct number.
        int roundScore = player.getRoundCorrect() == 10 ? 12 : player.getRoundCorrect();
        // Use this for hard mode to calculater the weight score.
        if (mode.equals("hard"))
        {
            roundScore = roundScore * 2;
        }
        // Use this to change mode.
        if (player.getRoundCorrect() == 10)
        {
            mode = "hard";
        }
        // 2.Assign this round's score to the player object
        player.setRoundScore(roundScore);
        // 3.Add the number of correct rounds to the total number of correct rounds and the fractions as well.
        player.setTotalScore(player.getTotalScore() + player.getRoundScore());
        player.setTotalCorrect(player.getTotalCorrect() + player.getRoundCorrect());
        // 4.Print out information about the round (number of corrects in the current round, scores obtained in the current round)
        System.out.println("Round End\n" +
                "Your round correct is : " + player.getRoundCorrect() + "\n"+
                "Your round score is : " + player.getRoundScore());
        // 5.Zeroing the correct number and score for the current round
        player.setRoundScore(0);
        player.setRoundCorrect(0);
    }

    /**
     * play round
     * This method is to play round.
     *
     * @param levelMaxNumber
     */
    private void playRound(int levelMaxNumber)
    {
        Input input = new Input();
        int randomNumber = 0;
        // Use this to make sure access "if" statement first.
        boolean switchBoolean = true;
        NumberGenerator numberGenerator = new NumberGenerator();
        for (int times = 1; times <= 10; times++)
        {
            if (switchBoolean)
            {
                randomNumber = numberGenerator.generateRandomNumber(levelMaxNumber, mode);
            }
            boolean isPrime = validation.checkNumberIsPrimeNumber(randomNumber);
            // Make sure player can input yes or no.
            System.out.println("Number: " + randomNumber);
            char c = input.acceptCharInput("Your chose: (Y/N/Q)");
            String userGuess = c+"";
            boolean isYNQ = isInputYNQ(userGuess);
            // if player's input is not Y,N,Q.
            if (!isYNQ){
                times--;
                switchBoolean = false;
                // The current cycle stops and the next cycle begins.
                continue;
            }
            // if player's input is Y,N,Q.
            if (isYNQ)
            {
                // Q
                if ("Q".equalsIgnoreCase(userGuess)){
                    break;
                }else {
                    // YN
                    boolean isRightAnswer = validation.checkAnswer(isPrime, userGuess);
                    // YN and answer is right.
                    if (isRightAnswer)
                    {
                        System.out.println("Correct!");
                        player.setRoundCorrect(player.getRoundCorrect() + 1);
                        switchBoolean = true;
                    }
                    else
                    {
                        System.out.println("Incorrect!");
                        switchBoolean = true;
                        break;
                    }
                }
            }
        }
    }

    /**
     * this method is to check player's input if y,n,q
     *
     * @param playerGuess
     * @return boolean
     */
    private boolean isInputYNQ(String playerGuess)
    {
        if ("Q".equalsIgnoreCase(playerGuess) || "N".equalsIgnoreCase(playerGuess) || "Y".equalsIgnoreCase(playerGuess))
        {
            return true;
        } else
        {
            return false;
        }
    }

    /**
     * This method is to ask player to input leve
     */
    public void askPlayerInputLevel()
    {
        //validation
        Input input = new Input();
        String option = input.stringInput("Pleas, choose an option:\n" +
                "A. 1 - 100(Random number between 1 to 100)\n" +
                "B. 1 - 400(Random number between 1 to 400)");
        if (option.equalsIgnoreCase("A"))
        {
            levelMaxNumber = 100;
        } else if (option.equalsIgnoreCase("B"))
        {
            levelMaxNumber = 400;
        } else
        {
            System.out.println("Please, enter A or B");
            // 递归调用
            askPlayerInputLevel();
        }
    }

    /**
     * this mathod is to ask player input his or her name.
     */
    public void askPlayerInputName()
    {
        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please, input your name: ");
            String name = scanner.nextLine();
            if (validation.checkName(name, 10))
            {
                player = new Player(name);
                System.out.println("Hi, " + player.getName());
                break;
            } else
            {
                System.out.println("Illegal");
            }
        }
    }

    /**
     * show the welcome message
     */
    public void displayWelcomeMessage()
    {
        System.out.println("Hi！welcome to the Game");
        System.out.println("This game is A Prime Challenge Game.");
        System.out.println("You need to answer whether the given random is a prime number.\n" +
                "Y for Yes, N for No, and Q for exiting the current round");
    }


}
