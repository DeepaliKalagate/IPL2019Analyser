package ipl2019analyser;

public class IPLPlayerDAO
{
    public int position;
    public String  player;
    public int matches;
    public int innings;
    public int notOut;
    public int runs;
    public String highestScore;
    public double average;
    public int ballsFaced;
    public double strikeRate;
    public int hundred;
    public int  fifty;
    public int numberOfFours;
    public int numberOfSixes;
    public int numberOfFourWkts;
    public int  numberOfFiveWkts;
    public double economyRate;
    public String wickets;
    public int bbi;
    public double over;

    public IPLPlayerDAO(IPLMostRunsData iplMostRunsData)
    {
        position =iplMostRunsData.position;
        player=iplMostRunsData.player;
        matches =iplMostRunsData.matches;
        innings =iplMostRunsData.innings;
        notOut =iplMostRunsData.notOut;
        runs=iplMostRunsData.runs;
        highestScore =iplMostRunsData.highestScore;
        average =iplMostRunsData.average;
        ballsFaced =iplMostRunsData.ballsFaced;
        strikeRate =iplMostRunsData.strikeRate;
        hundred=iplMostRunsData.hundred;
        fifty=iplMostRunsData.fifty;
        numberOfFours=iplMostRunsData.numberOfFours;
        numberOfSixes=iplMostRunsData.numberOfSixes;
    }

    public IPLPlayerDAO(IPLMostWicketsData iplMostWicketsData)
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
