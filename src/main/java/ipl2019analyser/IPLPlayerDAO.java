package ipl2019analyser;

public class IPLPlayerDAO
{
    public int position;
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
        position=iplMostRunsData.position;
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
        position=iplMostWicketsData.position;
        bowlingAverage =iplMostWicketsData.bowlingAverage;
        economyRate =iplMostWicketsData.economyRate;
        strikeRate=iplMostWicketsData.strikeRate;
        numberOfFourWkts=iplMostWicketsData.numberOfFourWkts;
        numberOfFiveWkts=iplMostWicketsData.numberOfFiveWkts;
    }

    public IPLPlayerDAO( int position,String player, int runs,double average,double strikeRate)
    {

    }

    @Override
    public String toString() {
        return "IPLPlayerDAO{" +
                "position=" + position +
                ", player='" + player + '\'' +
                ", runs=" + runs +
                ", average=" + average +
                ", bowlingAverage=" + bowlingAverage +
                ", strikeRate=" + strikeRate +
                ", numberOfFours=" + numberOfFours +
                ", numberOfSixes=" + numberOfSixes +
                ", numberOfFourWkts=" + numberOfFourWkts +
                ", numberOfFiveWkts=" + numberOfFiveWkts +
                ", economyRate=" + economyRate +
                ", wickets=" + wickets +
                '}';
    }
}
