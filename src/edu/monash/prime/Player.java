package edu.monash.prime;

/**
 * test.Player class
 * <p>
 * Author: Qiupeng Li
 * Version: 1.0
 */

public class Player
{
    private String name;
    /**
     * 挡轮正确题目数
     */
    private int roundCorrect;
    /**
     * 总正确题目数
     */
    private int totalCorrect;
    /**
     * 当轮分数。
     */
    private int roundScore;

    /**
     * 总分
     */
    private int totalScore;

    public Player()
    {
        name = "No name";
    }

    //block comment

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
     * Mutator
     * This method is to set the each of round correct number of question.
     *
     * @param roundCorrect 圆正确
     */
    public void setRoundCorrect(int roundCorrect)
    {
        this.roundCorrect = roundCorrect;
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
     * Mutator
     * This method is to set the total correct number of question.
     *
     * @param totalCorrect 完全正确
     */
    public void setTotalCorrect(int totalCorrect)
    {
        this.totalCorrect = totalCorrect;
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
     * Mutator
     * This method is to set the each of rounds Score.
     *
     * @param roundScore 轮得分
     */
    public void setRoundScore(int roundScore)
    {
        this.roundScore = roundScore;
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
     * This method is to set the total Score of three round game.
     *
     * @param totalScore 总分
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
