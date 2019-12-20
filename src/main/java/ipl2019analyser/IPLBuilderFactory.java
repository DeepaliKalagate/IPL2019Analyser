package ipl2019analyser;

public class IPLBuilderFactory
{
    public static IPLAdapter getIPLPlayer(IPLAnalyser.PlayerEnumTypes player)
    {
        if(player.equals(IPLAnalyser.PlayerEnumTypes.RUNS))
            return new IPLRuns();
        else if(player.equals(IPLAnalyser.PlayerEnumTypes.WICKETS))
            return new IPLWickets();
        return null;
    }
}
