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
    public double  avg;
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

    public IPLMostRunsData(int pos, String player, int mat, int inns, int no, int runs, String hs, double avg, int bf, double sr, int hundred, int fifty, int fours, int sixes)
    {
        this.pos = pos;
        this.player = player;
        this.mat = mat;
        this.inns = inns;
        this.no = no;
        this.runs = runs;
        this.hs = hs;
        this.avg = avg;
        this.bf = bf;
        this.sr = sr;
        this.hundred = hundred;
        this.fifty = fifty;
        this.fours = fours;
        this.sixes = sixes;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public int getInns() {
        return inns;
    }

    public void setInns(int inns) {
        this.inns = inns;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public String getHs() {
        return hs;
    }

    public void setHs(String hs) {
        this.hs = hs;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public int getBf() {
        return bf;
    }

    public void setBf(int bf) {
        this.bf = bf;
    }

    public double getSr() {
        return sr;
    }

    public void setSr(double sr) {
        this.sr = sr;
    }

    public int getHundred() {
        return hundred;
    }

    public void setHundred(int hundred) {
        this.hundred = hundred;
    }

    public int getFifty() {
        return fifty;
    }

    public void setFifty(int fifty) {
        this.fifty = fifty;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }
}
