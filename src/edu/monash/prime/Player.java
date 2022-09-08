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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getRoundCorrect()
    {
        return roundCorrect;
    }

    public void setRoundCorrect(int roundCorrect)
    {
        this.roundCorrect = roundCorrect;
    }

    public int getTotalCorrect()
    {
        return totalCorrect;
    }

    public void setTotalCorrect(int totalCorrect)
    {
        this.totalCorrect = totalCorrect;
    }

    public int getRoundScore()
    {
        return roundScore;
    }

    public void setRoundScore(int roundScore)
    {
        this.roundScore = roundScore;
    }

    public int getTotalScore()
    {
        return totalScore;
    }

    public void setTotalScore(int totalScore)
    {
        this.totalScore = totalScore;
    }

    @Override
    public String toString()
    {
        return "Player{" +
                "name='" + name + '\'' +
                ", totalCorrect=" + totalCorrect +
                ", totalScore=" + totalScore +
                '}';
    }
}
