package ipl2019analyser;

public class IPLPlayerDAO
{

    public String  player;
    public int runs;
    public double average;
    public double bowlingAverage;
    public double strikeRate;
    public int numberOfFours;
    public int numberOfSixes;
    public int numberOfFourWkts;
    public int  numberOfFiveWkts;
    public double economyRate;
    public int wickets;


    public IPLPlayerDAO(IPLMostRunsData iplMostRunsData)
    {
        player=iplMostRunsData.player;
        runs=iplMostRunsData.runs;
        average =iplMostRunsData.average;
        strikeRate =iplMostRunsData.strikeRate;
        numberOfFours=iplMostRunsData.numberOfFours;
        numberOfSixes=iplMostRunsData.numberOfSixes;
    }

    public IPLPlayerDAO(IPLMostWicketsData iplMostWicketsData)
    {
        player=iplMostWicketsData.player;
        wickets=iplMostWicketsData.wickets;
        bowlingAverage =iplMostWicketsData.bowlingAverage;
        economyRate =iplMostWicketsData.economyRate;
        strikeRate=iplMostWicketsData.strikeRate;
        numberOfFourWkts=iplMostWicketsData.numberOfFourWkts;
        numberOfFiveWkts=iplMostWicketsData.numberOfFiveWkts;
    }
}
