package ipl2019analyser;

import com.opencsv.bean.CsvBindByName;

public class IPLMostWicketsData
{
    @CsvBindByName(column = "POS")
    public int position;
    @CsvBindByName(column = "PLAYER")
    public String  player;
    @CsvBindByName(column = "Mat")
    public int matches;
    @CsvBindByName(column = "Inns")
    public int  innings;
    @CsvBindByName(column = "Ov")
    public double over;
    @CsvBindByName(column = "Runs")
    public int  runs;
    @CsvBindByName(column = "Wkts")
    public String wickets;
    @CsvBindByName(column = "BBI")
    public int bbi;
    @CsvBindByName(column = "Avg")
    public double average;
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

    public IPLMostWicketsData(int position, String player, int matches, int innings, double over, int runs, String wickets, int bbi, double average, double economyRate, double strikeRate, int numberOfFourWkts, int numberOfFiveWkts)
    {
        this.position = position;
        this.player = player;
        this.matches = matches;
        this.innings = innings;
        this.over = over;
        this.runs = runs;
        this.wickets = wickets;
        this.bbi = bbi;
        this.average = average;
        this.economyRate = economyRate;
        this.strikeRate = strikeRate;
        this.numberOfFourWkts = numberOfFourWkts;
        this.numberOfFiveWkts = numberOfFiveWkts;
    }
}
