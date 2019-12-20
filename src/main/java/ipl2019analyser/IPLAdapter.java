package ipl2019analyser;

import com.bridgelabz.CSVBuilderException;
import com.bridgelabz.CSVBuilderFactory;
import com.bridgelabz.ICVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public abstract class IPLAdapter
{
    Map<String, IPLPlayerDAO> playerDAOMap;
    public IPLAdapter()
    {
        this.playerDAOMap = new HashMap<>();
    }

    public abstract Map<String, IPLPlayerDAO> loadIPLData(String iplFilePath) throws CSVBuilderException;

    public <E> Map<String, IPLPlayerDAO> loadIPLData(Class<E> eClass, String iplFilePath) throws CSVBuilderException
    {
        try (Reader reader = Files.newBufferedReader(Paths.get(iplFilePath)))
        {
            ICVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<E> csvFileIterator = csvBuilder.getCSVFileIterator(reader, eClass);
            Iterable<E> csvIterable = () -> csvFileIterator;

            if (eClass.getName().equals("ipl2019analyser.IPLMostRunsData"))
            {
                StreamSupport.stream
                        (csvIterable.spliterator(), false)
                        .map(IPLMostRunsData.class::cast)
                        .forEach(iplPlayer -> playerDAOMap.put(iplPlayer.player, new IPLPlayerDAO(iplPlayer)));
            }
            else if (eClass.getName().equals("ipl2019analyser.IPLMostWicketsData"))
            {
                StreamSupport.stream
                        (csvIterable.spliterator(), false)
                        .map(IPLMostWicketsData.class::cast)
                        .forEach(iplPlayer -> playerDAOMap.put(iplPlayer.player, new IPLPlayerDAO(iplPlayer)));
            }
        }
        catch (IOException | RuntimeException e)
        {
            throw new CSVBuilderException("Error in File Reading", CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM);
        }
        catch (CSVBuilderException e)
        {
            throw new CSVBuilderException("Unable to Build Bean", CSVBuilderException.ExceptionType.UNABLE_TO_PARSE);
        }
        return playerDAOMap;
    }
}
