package ipl2019analyser;
import java.io.File;
import java.util.*;

import com.bridgelabz.CSVBuilderException;
import com.google.gson.Gson;
import static java.util.stream.Collectors.toCollection;

public class IPLAnalyser
{
    Map<String,IPLRunsDAO> daoMap=new HashMap<>();
    Map<String, IPLWicketsDAO> daoMap1=new HashMap<>();
    Map<SortByBasedOnField,Comparator<IPLRunsDAO>> fieldComparatorMap=null;

    public enum PlayerEnumTypes
    {
        RUNS,WICKETS
    }
    PlayerEnumTypes player;

    public IPLAnalyser()
    {
        fieldComparatorMap=new HashMap<>();
        this.fieldComparatorMap.put(SortByBasedOnField.Average,Comparator.comparing(field->field.average,Comparator.reverseOrder()));
        this.fieldComparatorMap.put(SortByBasedOnField.Strike_Rate,Comparator.comparing(field->field.strikeRate,Comparator.reverseOrder()));
        this.fieldComparatorMap.put(SortByBasedOnField.Result_Of_Fours_Sixes,new calculateRunsOfFoursWithSixes().reversed());
        this.fieldComparatorMap.put(SortByBasedOnField.Strike_Rate_With_SixesWithFours,new calculateRunsOfFoursWithSixes().reversed()
                                    .thenComparing(field->field.strikeRate));
        Comparator<IPLRunsDAO> average=Comparator.comparing(field->field.average);
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

    public boolean checkIPLData(String iplFilePath)
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

    public Map<String, IPLPlayerDAO> getIPLPlayerData(PlayerEnumTypes player, String iplFilePath) throws CSVBuilderException
    {
        this.player = player;
        IPLAdapter iplAdapter = IPLBuilderFactory.getIPLPlayer(player);
        Map<String, IPLPlayerDAO> map = iplAdapter.loadIPLData(iplFilePath);
        return map;
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