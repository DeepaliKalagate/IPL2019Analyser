package ipl2019analyser;

public class IPLWicketsDAO
{
    public int position;
    public String  player;
    public int matches;
    public int  innings;
    public double over;
    public int  runs;
    public String wickets;
    public int bbi;
    public double average;
    public double economyRate;
    public double strikeRate;
    public int numberOfFourWkts;
    public int  numberOfFiveWkts;

    public IPLWicketsDAO(IPLMostWicketsData iplMostWicketsData)
    {
        position=iplMostWicketsData.position;
        player=iplMostWicketsData.player;
        matches=iplMostWicketsData.matches;
        innings=iplMostWicketsData.innings;
        over=iplMostWicketsData.over;
        runs=iplMostWicketsData.runs;
        wickets=iplMostWicketsData.wickets;
        bbi=iplMostWicketsData.bbi;
        average =iplMostWicketsData.average;
        economyRate =iplMostWicketsData.economyRate;
        strikeRate=iplMostWicketsData.strikeRate;
        numberOfFourWkts=iplMostWicketsData.numberOfFourWkts;
        numberOfFiveWkts=iplMostWicketsData.numberOfFiveWkts;
    }
}
