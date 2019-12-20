package ipl2019analyser;

import java.util.Comparator;

public class CalculateWickets implements Comparator<IPLPlayerDAO>
{
    @Override
    public int compare(IPLPlayerDAO iplPlayerDAO1, IPLPlayerDAO iplPlayerDAO2)
    {
        return ((iplPlayerDAO1.numberOfFiveWkts*5)+(iplPlayerDAO1.numberOfFourWkts*4))-((iplPlayerDAO2.numberOfFiveWkts*5)+(iplPlayerDAO2.numberOfFourWkts*4));
    }
}

