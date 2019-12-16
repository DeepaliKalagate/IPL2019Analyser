package ipl2019analyser;

public class IPLRunsDAO
{
    public int pos;
    public String  player;
    public int mat;
    public int  inns;
    public int no;
    public int runs;
    public String hs;
    public double avg;
    public int bf;
    public double  sr;
    public int hundred;
    public int  fifty;
    public int numberOfFours;
    public int numberOfSixes;

    public IPLRunsDAO(IPLMostRunsData iplMostRunsData)
    {
        pos=iplMostRunsData.pos;
        player=iplMostRunsData.player;
        mat=iplMostRunsData.mat;
        inns=iplMostRunsData.inns;
        no=iplMostRunsData.no;
        runs=iplMostRunsData.runs;
        hs=iplMostRunsData.hs;
        avg=iplMostRunsData.avg;
        bf=iplMostRunsData.bf;
        sr=iplMostRunsData.sr;
        hundred=iplMostRunsData.hundred;
        fifty=iplMostRunsData.fifty;
        numberOfFours=iplMostRunsData.numberOfFours;
        numberOfSixes=iplMostRunsData.numberOfSixes;
    }
}
