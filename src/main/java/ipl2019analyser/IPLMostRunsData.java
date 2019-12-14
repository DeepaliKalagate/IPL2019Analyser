package ipl2019analyser;

import com.opencsv.bean.CsvBindByName;

public class IPLMostRunsData
{
    @CsvBindByName(column = "POS")
    public int pos;
    @CsvBindByName(column = "PLAYER")
    public String  player;
    @CsvBindByName(column = "Mat")
    public int mat;
    @CsvBindByName(column = "Inns")
    public int  inns;
    @CsvBindByName(column = "NO")
    public int no;
    @CsvBindByName(column = "Runs")
    public int  runs;
    @CsvBindByName(column = "HS")
    public String hs;
    @CsvBindByName(column = "Avg")
    public String  avg;
    @CsvBindByName(column = "BF")
    public int bf;
    @CsvBindByName(column = "SR")
    public double  sr;
    @CsvBindByName(column = "100")
    public int hundred;
    @CsvBindByName(column = "50")
    public int  fifty;
    @CsvBindByName(column = "4s")
    public int fours;
    @CsvBindByName(column = "6s")
    public int  sixes;

    public IPLMostRunsData()
    {
    }
}
