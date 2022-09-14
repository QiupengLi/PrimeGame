package edu.monash.prime;

/**
 * Player class
 *
 * Author: Qiupeng Li
 * Version: 5.0
 */

public class Player{

    private String name;
    private int roundCorrect;
    private int totalCorrect;
    private int roundScore;
    private int totalScore;

    /**
     * This is a default constructor.
     *
     */
    public Player()
    {

    }
    /**
     * The non-default constructor for test.Player class
     * This constructor will initialise player name
     *
     * @param name
     */
    public Player(String name)
    {
        this.name = name;
    }

    /**
     * Accessor
     * This method is to get the name of player
     *
     * @return {@link String}
     */
    public String getName()
    {
        return name;
    }

    /**
     * Accessor
     * This method is to get the each of round correct number of questions.
     *
     * @return int
     */
    public int getRoundCorrect()
    {
        return roundCorrect;
    }

    /**
     * Accessor
     * This method is to get the total correct number of questions.
     *
     * @return int
     */
    public int getTotalCorrect()
    {
        return totalCorrect;
    }

    /**
     * Accessor
     * This method is to get the each of round Score.
     *
     * @return int
     */
    public int getRoundScore()
    {
        return roundScore;
    }

    /**
     * Accessor
     * This method is to get the total Score of three round game.
     * @return int
     */
    public int getTotalScore()
    {
        return totalScore;
    }

    /**
     * Mutator
     * This method is to set the name of player.
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Mutator
     * This method is to set the round's correct number of question.
     *
     * @param totalCorrect
     */
    public void setRoundCorrect(int roundCorrect)
    {
        this.roundCorrect = roundCorrect;
    }

    /**
     * Mutator
     * This method is to set the total correct number of question.
     *
     * @param totalCorrect
     */
    public void setTotalCorrect(int totalCorrect)
    {
        this.totalCorrect = totalCorrect;
    }

    /**
     * Mutator
     * This method is to set the each of rounds Score.
     *
     * @param roundScore
     */
    public void setRoundScore(int roundScore)
    {
        this.roundScore = roundScore;
    }

    /**
     * Mutator
     * This method is to set total Score of three round game.
     *
     * @param totalScore
     */
    public void setTotalScore(int totalScore)
    {
        this.totalScore = totalScore;
    }

    /**
     * ToString
     * This math is to show the state of player.
     *
     * @return {@link String}
     */
    @Override
    public String toString()
    {
        return "Player{" + "name = '" + name + '\'' +
                ", totalCorrect = " + totalCorrect +
                ", totalScore = " + totalScore + '}';
    }
}
