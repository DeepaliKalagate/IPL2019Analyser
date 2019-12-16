package ipl2019analyser;

import java.util.Comparator;

public class SortByFoursWithSixes implements Comparator<IPLRunsDAO>
{
    @Override
    public int compare(IPLRunsDAO iplRunsDAO1, IPLRunsDAO iplRunsDAO2)
    {
        return ((iplRunsDAO1.numberOfSixes*6)+(iplRunsDAO1.numberOfFours*4))-((iplRunsDAO2.numberOfSixes*6)+(iplRunsDAO2.numberOfFours*4));

    }
}
