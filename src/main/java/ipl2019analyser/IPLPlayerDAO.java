package ipl2019analyser;

public class IPLPlayerDAO
{
    public String player;
    public double average;
    public double strikeRate;
    public int numberOfFours;
    public int numberOfSixes;
    public double economyRate;
    public int numberOfFourWkts;
    public int  numberOfFiveWkts;


    public IPLPlayerDAO(IPLMostRunsData iplMostRunsData)
    {
        player=iplMostRunsData.player;
        average=iplMostRunsData.average;
        strikeRate=iplMostRunsData.strikeRate;
        numberOfFours=iplMostRunsData.numberOfFours;
        numberOfSixes=iplMostRunsData.numberOfSixes;
    }

    public IPLPlayerDAO(IPLMostWicketsData iplMostWicketsData)
    {
        player=iplMostWicketsData.player;
        average=iplMostWicketsData.average;
        strikeRate=iplMostWicketsData.strikeRate;
        economyRate=iplMostWicketsData.economyRate;
        numberOfFourWkts=iplMostWicketsData.numberOfFourWkts;
        numberOfFiveWkts=iplMostWicketsData.numberOfFiveWkts;
    }
}
