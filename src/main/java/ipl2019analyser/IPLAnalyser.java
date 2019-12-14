package ipl2019analyser;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;
import com.bridgelabz.CSVBuilderException;
import com.bridgelabz.CSVBuilderFactory;
import com.bridgelabz.ICVBuilder;

public class IPLAnalyser
{
    public boolean CheckIPLDataFile(String iplFilePath)
    {
        File file=new File(iplFilePath);
            if (file.exists())
                return true;
            return false;
    }

    public int loadIPLAnalserData(String iplFilePath) throws CSVBuilderException
    {
        try (Reader reader = Files.newBufferedReader(Paths.get(iplFilePath));)
        {
            ICVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IPLMostRunsData> iterator = icsvBuilder.getCSVFileIterator(reader, IPLMostRunsData.class);
            Iterable<IPLMostRunsData> csvIterable=()->iterator;
            int namOfEateries = (int) StreamSupport.stream(csvIterable.spliterator(),false).count();
            return namOfEateries;
        }
        catch (IOException e)
        {
            throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM);
        }
        catch (CSVBuilderException e)
        {
            throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.UNABLE_TO_PARSE);
        }
    }
}
