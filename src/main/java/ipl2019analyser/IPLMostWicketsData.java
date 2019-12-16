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
    public double  avg;
    @CsvBindByName(column = "Econ")
    public double econ;
    @CsvBindByName(column = "SR")
    public double strikeRate;
    @CsvBindByName(column = "4w")
    public int numberOfFourWkts;
    @CsvBindByName(column = "5w")
    public int  numberOfFiveWkts;

    public IPLMostWicketsData()
    {
    }

    public IPLMostWicketsData(int position, String player, int matches, int innings, double over, int runs, String wickets, int bbi, double avg, double econ, double strikeRate, int numberOfFourWkts, int numberOfFiveWkts)
    {
        this.position = position;
        this.player = player;
        this.matches = matches;
        this.innings = innings;
        this.over = over;
        this.runs = runs;
        this.wickets = wickets;
        this.bbi = bbi;
        this.avg = avg;
        this.econ = econ;
        this.strikeRate = strikeRate;
        this.numberOfFourWkts = numberOfFourWkts;
        this.numberOfFiveWkts = numberOfFiveWkts;
    }
}
