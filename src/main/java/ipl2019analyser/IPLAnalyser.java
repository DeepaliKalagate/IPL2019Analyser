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
import com.google.gson.Gson;
import static java.util.stream.Collectors.toCollection;

public class IPLAnalyser
{
    Map<String,IPLRunsDAO> daoMap=new HashMap<>();
    Map<SortByBasedOnField,Comparator<IPLRunsDAO>> fieldComparatorMap=null;

    public IPLAnalyser()
    {
        fieldComparatorMap=new HashMap<>();
        this.fieldComparatorMap.put(SortByBasedOnField.Average,Comparator.comparing(field->field.avg,Comparator.reverseOrder()));
        this.fieldComparatorMap.put(SortByBasedOnField.Strike_Rate,Comparator.comparing(field->field.strikeRate,Comparator.reverseOrder()));
        this.fieldComparatorMap.put(SortByBasedOnField.Result_Of_Fours_Sixes,new SortByFoursWithSixes().reversed());
        this.fieldComparatorMap.put(SortByBasedOnField.Strike_Rate_With_SixesWithFours,new SortByFoursWithSixes().reversed()
                                    .thenComparing(field->field.strikeRate));
        Comparator<IPLRunsDAO> average=Comparator.comparing(field->field.avg);
        Comparator<IPLRunsDAO> strikeRate=Comparator.comparing(field->field.strikeRate);
        Comparator<IPLRunsDAO> result=average.thenComparing(strikeRate);
        this.fieldComparatorMap.put(SortByBasedOnField.Great_Average_With_Strike_Rate,result.reversed());
        this.fieldComparatorMap.put(SortByBasedOnField.Maximum_Runs,Comparator.comparing(field->field.runs,Comparator.reverseOrder()));
        Comparator<IPLRunsDAO> maximumRuns=Comparator.comparing(field->field.runs);
        Comparator<IPLRunsDAO> runsWithAverage=maximumRuns.thenComparing(average);
        this.fieldComparatorMap.put(SortByBasedOnField.Maximum_Runs_With_Average,runsWithAverage.reversed());
    }
    public boolean checkIPLDataFile(String iplFilePath)
    {
        File file = new File(iplFilePath);
        if (file.exists())
            return true;
        return false;
    }

    public boolean checkIPLDataFileIsEmptyOrNot(String iplFilePath)
    {
        File file=new File(iplFilePath);
        if(file.length()==0)
            return true;
        return false;
    }

    public boolean checkIPLMostRunsDataFileCanRead(String iplFilePath)
    {
        File file=new File(iplFilePath);
        if (file.canRead())
            return true;
        return false;
    }

    public boolean checkIPLMostRunsDataFileIsHidden(String iplFilePath)
    {
        File file=new File(iplFilePath);
        if (file.isHidden())
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
            StreamSupport.stream(csvIterable.spliterator(), false)
                    .map(IPLMostRunsData.class::cast)
                    .forEach(field -> daoMap.put(field.player, new IPLRunsDAO(field)));
            return daoMap.size();
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

    public String getSortByField(SortByBasedOnField fieldName) throws CSVBuilderException
    {
        if (daoMap == null || daoMap.size() == 0)
        {
            throw new CSVBuilderException("No Data", CSVBuilderException
                    .ExceptionType.CENSUS_FILE_PROBLEM);
        }
        ArrayList arrayList = daoMap.values().stream()
                .sorted(this.fieldComparatorMap.get(fieldName))
                .collect(toCollection(ArrayList::new));
        String sortedStateCensus = new Gson().toJson(arrayList);
        return sortedStateCensus;
    }
}