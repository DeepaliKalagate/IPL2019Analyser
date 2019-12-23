package ipl2019analyser;

import com.opencsv.bean.CsvBindByName;

public class IPLMostWicketsData
{
    @CsvBindByName(column = "PLAYER")
    public String  player;
    @CsvBindByName(column = "Wkts")
    public int wickets;
    @CsvBindByName(column = "Avg")
    public double bowlingAverage;
    @CsvBindByName(column = "Econ")
    public double economyRate;
    @CsvBindByName(column = "SR")
    public double strikeRate;
    @CsvBindByName(column = "4w")
    public int numberOfFourWkts;
    @CsvBindByName(column = "5w")
    public int  numberOfFiveWkts;

    public IPLMostWicketsData()
    {
    }

    public IPLMostWicketsData(String player,int wickets,double bowlingAverage, double economyRate, double strikeRate, int numberOfFourWkts, int numberOfFiveWkts)
    {
        this.player = player;
        this.wickets = wickets;
        this.bowlingAverage = bowlingAverage;
        this.economyRate = economyRate;
        this.strikeRate = strikeRate;
        this.numberOfFourWkts = numberOfFourWkts;
        this.numberOfFiveWkts = numberOfFiveWkts;
    }

    public IPLMostWicketsData(IPLAnalyser.PlayerEnumTypes player, int wickets, double bowlingAverage, double economyRate, double strikeRate, int numberOfFourWkts, int numberOfFiveWkts) {
    }

    @Override
    public String toString() {
        return "IPLMostWicketsData{" +
                "player='" + player + '\'' +
                ", wickets=" + wickets +
                ", bowlingAverage=" + bowlingAverage +
                ", economyRate=" + economyRate +
                ", strikeRate=" + strikeRate +
                ", numberOfFourWkts=" + numberOfFourWkts +
                ", numberOfFiveWkts=" + numberOfFiveWkts +
                '}';
    }
}
