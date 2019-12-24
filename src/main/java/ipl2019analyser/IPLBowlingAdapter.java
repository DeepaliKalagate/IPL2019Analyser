package ipl2019analyser;
import com.bridgelabz.CSVBuilderException;
import com.bridgelabz.CSVBuilderFactory;
import com.bridgelabz.ICVBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class IPLBowlingAdapter extends IPLAdapter
{
    @Override
    public Map<String, IPLPlayerDAO> loadIPLData(String... iplFilePath) throws CSVBuilderException
    {
        Map<String, IPLPlayerDAO> map = super.loadIPLData(IPLMostWicketsData.class,iplFilePath[0]);
        if (iplFilePath.length >1)
        {
            this.loadIPLData(map,iplFilePath[1]);
        }
        return map;
    }

    private Map<String, IPLPlayerDAO> loadIPLData(Map<String, IPLPlayerDAO> censusIPLMap, String iplFilePath) throws CSVBuilderException
    {
        Reader reader = null;
        try
        {
            reader = Files.newBufferedReader(Paths.get(iplFilePath));
            ICVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IPLMostRunsData> iplCsvIterator = icsvBuilder.getCSVFileIterator(reader, IPLMostRunsData.class);
            Iterable<IPLMostRunsData> csvIterable = () -> iplCsvIterator;
            StreamSupport.stream(csvIterable.spliterator(),false)
                    .filter(runsData->censusIPLMap.get(runsData.player)!=null)
                    .forEach(runsData->censusIPLMap.get(runsData.player).average=runsData.average);
            return censusIPLMap;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (CSVBuilderException e)
        {
            throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM);
        }
        return censusIPLMap;
    }
}
