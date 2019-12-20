package ipl2019analyser;
import java.util.Comparator;

public class CalculateRuns implements Comparator<IPLPlayerDAO>
{
    @Override
    public int compare(IPLPlayerDAO iplPlayerDAO1, IPLPlayerDAO iplPlayerDAO2)
    {
        return ((iplPlayerDAO1.numberOfSixes*6)+(iplPlayerDAO1.numberOfFours*4))-((iplPlayerDAO2.numberOfSixes*6)+(iplPlayerDAO2.numberOfFours*4));
    }
}
