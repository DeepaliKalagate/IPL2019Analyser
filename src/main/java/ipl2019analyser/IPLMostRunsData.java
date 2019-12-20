package ipl2019analyser;
import com.opencsv.bean.CsvBindByName;

public class IPLMostRunsData
{
    @CsvBindByName(column = "POS")
    public int position;
    @CsvBindByName(column = "PLAYER")
    public String  player;
    @CsvBindByName(column = "Mat")
    public int matches;
    @CsvBindByName(column = "Inns")
    public int innings;
    @CsvBindByName(column = "NO")
    public int notOut;
    @CsvBindByName(column = "Runs")
    public int  runs;
    @CsvBindByName(column = "HS")
    public String highestScore;
    @CsvBindByName(column = "Avg")
    public double average;
    @CsvBindByName(column = "BF")
    public int ballsFaced;
    @CsvBindByName(column = "SR")
    public double strikeRate;
    @CsvBindByName(column = "100")
    public int hundred;
    @CsvBindByName(column = "50")
    public int  fifty;
    @CsvBindByName(column = "4s")
    public int numberOfFours;
    @CsvBindByName(column = "6s")
    public int  numberOfSixes;

    public IPLMostRunsData()
    {
    }

    public IPLMostRunsData(int position, String player, int matches, int innings, int notOut, int runs, String highestScore, double average, int ballsFaced, double strikeRate, int hundred, int fifty, int numberOfFours, int numberOfSixes)
    {
        this.position = position;
        this.player = player;
        this.matches = matches;
        this.innings = innings;
        this.notOut = notOut;
        this.runs = runs;
        this.highestScore = highestScore;
        this.average = average;
        this.ballsFaced = ballsFaced;
        this.strikeRate = strikeRate;
        this.hundred = hundred;
        this.fifty = fifty;
        this.numberOfFours = numberOfFours;
        this.numberOfSixes = numberOfSixes;
    }
}
