package ipl2019analyser;

import com.bridgelabz.CSVBuilderException;

import java.util.Map;

public class IPLRuns extends IPLAdapter
{
    @Override
    public Map<String, IPLPlayerDAO> loadIPLData(String iplFilePath) throws CSVBuilderException
    {
        Map<String, IPLPlayerDAO> map = super.loadIPLData(IPLMostRunsData.class,iplFilePath);
        return map;
    }
}
