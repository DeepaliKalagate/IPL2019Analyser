package ipl2019analyser;
import com.opencsv.bean.CsvBindByName;

public class IPLMostRunsData
{
    @CsvBindByName(column = "PLAYER")
    public String  player;
    @CsvBindByName(column = "Runs")
    public int  runs;
    @CsvBindByName(column = "Avg")
    public double average;
    @CsvBindByName(column = "SR")
    public double strikeRate;
    @CsvBindByName(column = "4s")
    public int numberOfFours;
    @CsvBindByName(column = "6s")
    public int  numberOfSixes;

    public IPLMostRunsData()
    {
    }

    public IPLMostRunsData(String player, int runs, double average,double strikeRate,int numberOfFours, int numberOfSixes)
    {
        this.player = player;
        this.runs = runs;
        this.average = average;
        this.strikeRate = strikeRate;
        this.numberOfFours = numberOfFours;
        this.numberOfSixes = numberOfSixes;
    }

    public IPLMostRunsData(IPLAnalyser.PlayerEnumTypes player, int runs, double average, double strikeRate, int numberOfFours, int numberOfSixes) {
    }

    @Override
    public String toString() {
        return "IPLMostRunsData{" +
                "player='" + player + '\'' +
                ", runs=" + runs +
                ", average=" + average +
                ", strikeRate=" + strikeRate +
                ", numberOfFours=" + numberOfFours +
                ", numberOfSixes=" + numberOfSixes +
                '}';
    }
}
