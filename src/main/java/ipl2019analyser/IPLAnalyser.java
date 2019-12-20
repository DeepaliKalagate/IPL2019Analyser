package ipl2019analyser;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

import com.bridgelabz.CSVBuilderException;
import com.google.gson.Gson;

public class IPLAnalyser
{
    Map<SortByBasedOnField,Comparator<IPLPlayerDAO>> comparatorMap =null;

    public enum PlayerEnumTypes
    {
        RUNS,WICKETS
    }
    PlayerEnumTypes player;

    public IPLAnalyser()
    {
        comparatorMap =new HashMap<>();
        this.comparatorMap.put(SortByBasedOnField.Average,Comparator.comparing(field->field.average,Comparator.reverseOrder()));
        this.comparatorMap.put(SortByBasedOnField.Strike_Rate,Comparator.comparing(field->field.strikeRate,Comparator.reverseOrder()));
        this.comparatorMap.put(SortByBasedOnField.Result_Of_Fours_Sixes,new calculateRuns().reversed());
        this.comparatorMap.put(SortByBasedOnField.Strike_Rate_With_SixesWithFours,new calculateRuns().reversed()
                                    .thenComparing(field->field.strikeRate));
        Comparator<IPLPlayerDAO> average=Comparator.comparing(field->field.average);
        Comparator<IPLPlayerDAO> strikeRate=Comparator.comparing(field->field.strikeRate);
        Comparator<IPLPlayerDAO> result=average.thenComparing(strikeRate);
        this.comparatorMap.put(SortByBasedOnField.Great_Average_With_Strike_Rate,result.reversed());
        this.comparatorMap.put(SortByBasedOnField.Maximum_Runs,Comparator.comparing(field->field.runs,Comparator.reverseOrder()));
        Comparator<IPLPlayerDAO> maximumRuns=Comparator.comparing(field->field.runs);
        Comparator<IPLPlayerDAO> runsWithAverage=maximumRuns.thenComparing(average);
        this.comparatorMap.put(SortByBasedOnField.Maximum_Runs_With_Average,runsWithAverage.reversed());
        this.comparatorMap.put(SortByBasedOnField.Economy_Rate,Comparator.comparing(field->field.economyRate,Comparator.reverseOrder()));
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

    public String getSortByField(SortByBasedOnField fieldName, Map<String, IPLPlayerDAO> daoMap)
                                    throws CSVBuilderException
    {
        if (daoMap == null || daoMap.size() == 0)
        {
            throw new CSVBuilderException("No Data", CSVBuilderException
                    .ExceptionType.IPL_FILE_PROBLEM);
        }
        ArrayList list = daoMap.values()
                .stream()
                .sorted(this.comparatorMap.get(fieldName))
                .collect(Collectors.toCollection(ArrayList::new));
        String sortedData = new Gson().toJson(list);
        return sortedData;
    }
}