package ipl2019analyser;

import com.bridgelabz.CSVBuilderException;

import java.util.Map;

public class IPLWickets extends IPLAdapter
{
    @Override
    public Map<String, IPLPlayerDAO> loadIPLData(String iplFilePath) throws CSVBuilderException
    {
        Map<String, IPLPlayerDAO> map = super.loadIPLData(IPLMostWicketsData.class,iplFilePath);
        return map;
    }
}
