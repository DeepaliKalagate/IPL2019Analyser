package ipl2019analyser;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.StreamSupport;
import com.bridgelabz.CSVBuilderException;
import com.bridgelabz.CSVBuilderFactory;
import com.bridgelabz.ICVBuilder;


public class IPLAnalyser
{
    List<IPLMostRunsData> list=null;
    public boolean CheckIPLDataFile(String iplFilePath)
    {
        File file = new File(iplFilePath);
        if (file.exists())
            return true;
        return false;
    }

    public int loadIPLAnalserData(String iplFilePath) throws CSVBuilderException
    {
        try (Reader reader = Files.newBufferedReader(Paths.get(iplFilePath));)
        {
            ICVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
            list=new ArrayList<>();
            list=icsvBuilder.getCSVFileList(reader,IPLMostRunsData.class);
            return list.size();
        }
        catch (IOException | RuntimeException e)
        {
            throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM);
        }
        catch (CSVBuilderException e)
        {
            throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.UNABLE_TO_PARSE);
        }
    }

    public List<IPLMostRunsData> sortByAvg(String iplFilePath) throws CSVBuilderException
    {
        loadIPLAnalserData(iplFilePath);
        Comparator<IPLMostRunsData> comparator=(s1,s2)-> (int) (s2.getAvg()-s1.getAvg());
        list.sort(comparator);
        return list;
    }

    public List<IPLMostRunsData> sortByStrikeRate(String iplFilePath) throws CSVBuilderException
    {
        loadIPLAnalserData(iplFilePath);
        Comparator<IPLMostRunsData> comparator=(s1,s2)-> (int) (s2.getSr()-s1.getSr());
        list.sort(comparator);
        return list;
    }
}