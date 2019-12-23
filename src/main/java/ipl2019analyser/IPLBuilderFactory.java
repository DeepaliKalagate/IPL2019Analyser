package ipl2019analyser;

public class IPLBuilderFactory
{
    public static IPLAdapter getIPLPlayer(IPLAnalyser.PlayerEnumTypes player)
    {
        if(player.equals(IPLAnalyser.PlayerEnumTypes.RUNS))
            return new IPLBattingAdapter();
        else if(player.equals(IPLAnalyser.PlayerEnumTypes.WICKETS))
            return new IPLBowlingAdapter();
        return null;
    }
}
