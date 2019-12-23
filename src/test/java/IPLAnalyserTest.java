import com.bridgelabz.CSVBuilderException;
import com.google.gson.Gson;
import ipl2019analyser.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Map;

public class IPLAnalyserTest
{
    private static final String IPL_MOST_RUNS_FILE_PATH ="/home/user/IPL2019Analyser/src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_MOST_WKTS_FILE_PATH="/home/user/IPL2019Analyser/src/test/resources/IPL2019FactsheetMostWkts.csv";
    private static final String IPL_EMPTY_FILE_PATH="/home/user/IPL2019Analyser/src/test/resources/IPL2019MostRuns.csv";
    private static final String IPL__WKTS_WRONG_FILE_PATH =" ";
    IPLAnalyser iplAnalyser=new IPLAnalyser();

    @Test
    public void givenIPLData_CheckFilesArePresentOrNot_ShouldReturnTrueOrFalse()
    {
            boolean result = iplAnalyser.checkIPLDataFile(IPL_MOST_RUNS_FILE_PATH,IPL_MOST_WKTS_FILE_PATH);
            Assert.assertEquals(true,result);
    }

    @Test
    public void givenIPLData_CheckFilesNotPresent_ShouldReturnTrueOrFalse()
    {
        boolean result = iplAnalyser.checkIPLDataFile(IPL__WKTS_WRONG_FILE_PATH);
        Assert.assertEquals(false,result);
    }


    @Test
    public void givenIPLData_CheckFilesAreEmptyOrNot_IfValidShouldReturnTrueOrFalse()
    {
        boolean result=iplAnalyser.checkIPLDataFileIsEmptyOrNot(IPL_MOST_RUNS_FILE_PATH,IPL_MOST_WKTS_FILE_PATH);
        Assert.assertEquals(false,result);
    }

    @Test
    public void givenIPLData_CheckFilesAreEmpty_IfValidShouldReturnTrueOrFalse()
    {
        boolean result=iplAnalyser.checkIPLDataFileIsEmptyOrNot(IPL_EMPTY_FILE_PATH);
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenIPLData_WhenFileIsEmpty_ShouldThrowException()
    {
        try
        {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CSVBuilderException.class);
            iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.RUNS,IPL_EMPTY_FILE_PATH);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.UNABLE_TO_PARSE, e.type);
        }
    }

    @Test
    public void givenIPLData_IfNoFilePath_ShouldThrowException()
    {
        try
        {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CSVBuilderException.class);
            iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.RUNS," "," ");
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLData_CheckRecordsOfBattingData_ShouldReturnExactCount()
    {
        try
        {
            Map<String, IPLPlayerDAO> result=iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.RUNS,IPL_MOST_RUNS_FILE_PATH,IPL_MOST_WKTS_FILE_PATH);
            Assert.assertEquals(100,result.size());
        }
        catch (CSVBuilderException e)
        {
        }
    }
    @Test
    public void givenIPLData_WhenSortedOnAverage_ShouldReturnSortedResult()
    {
        try
        {
            Map<String, IPLPlayerDAO> daoMap =iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.RUNS,IPL_MOST_RUNS_FILE_PATH,IPL_MOST_WKTS_FILE_PATH);
            String sortedData = iplAnalyser.getSortByField(SortByBasedOnField.Average,daoMap);
            IPLMostRunsData[] runsData = new Gson().fromJson(sortedData, IPLMostRunsData[].class);
            Assert.assertEquals("MS Dhoni", runsData[0].player);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLData_WhenSortedOnStrikeRate_ShouldReturnSortedResult()
    {
        try
        {
            Map<String, IPLPlayerDAO> daoMap =iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.RUNS,IPL_MOST_RUNS_FILE_PATH,IPL_MOST_WKTS_FILE_PATH);
            String sortedData = iplAnalyser.getSortByField(SortByBasedOnField.Strike_Rate,daoMap);
            IPLMostRunsData[] runsData = new Gson().fromJson(sortedData, IPLMostRunsData[].class);
            Assert.assertEquals("Ishant Sharma", runsData[0].player);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLData_WhenSortedOnFoursAndSixes_ShouldReturnSortedResult()
    {
        try
        {
            Map<String, IPLPlayerDAO> daoMap =iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.RUNS,IPL_MOST_RUNS_FILE_PATH,IPL_MOST_WKTS_FILE_PATH);
            String sortedData = iplAnalyser.getSortByField(SortByBasedOnField.Result_Of_Fours_Sixes,daoMap);
            IPLMostRunsData[] runsData = new Gson().fromJson(sortedData, IPLMostRunsData[].class);
            Assert.assertEquals("Andre Russell", runsData[0].player);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLData_WhenSortedOnStrikeRateWithFoursAndSixes_ShouldReturnSortedResult()
    {
        try
        {
            Map<String, IPLPlayerDAO> daoMap =iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.RUNS,IPL_MOST_RUNS_FILE_PATH,IPL_MOST_WKTS_FILE_PATH);
            String sortedData = iplAnalyser.getSortByField(SortByBasedOnField.Strike_Rate_With_SixesWithFours,daoMap);
            IPLMostRunsData[] runsData = new Gson().fromJson(sortedData, IPLMostRunsData[].class);
            Assert.assertEquals("Andre Russell", runsData[0].player);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLData_WhenSortedOnGreatAverageWithStrikeRate_ShouldReturnSortedResult()
    {
        try
        {
            Map<String, IPLPlayerDAO> daoMap =iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.RUNS,IPL_MOST_RUNS_FILE_PATH,IPL_MOST_WKTS_FILE_PATH);
            String sortedData = iplAnalyser.getSortByField(SortByBasedOnField.Great_Average_With_Strike_Rate,daoMap);
            IPLMostRunsData[] runsData = new Gson().fromJson(sortedData, IPLMostRunsData[].class);
            Assert.assertEquals("MS Dhoni", runsData[0].player);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLData_WhenSortedOnMaximumRuns_ShouldReturnSortedResult()
    {
        try
        {
            Map<String, IPLPlayerDAO> daoMap =iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.RUNS,IPL_MOST_RUNS_FILE_PATH,IPL_MOST_WKTS_FILE_PATH);
            String sortedData = iplAnalyser.getSortByField(SortByBasedOnField.Maximum_Runs_With_Average,daoMap);
            IPLMostRunsData[] runsData = new Gson().fromJson(sortedData, IPLMostRunsData[].class);
            Assert.assertEquals("David Warner ", runsData[0].player);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLData_WhenSortedWithEmptyFile_ShouldReturnSortedResult()
    {
        try
        {
            Map<String, IPLPlayerDAO> daoMap =iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.RUNS,IPL_EMPTY_FILE_PATH);
            String sortedData = iplAnalyser.getSortByField(SortByBasedOnField.Maximum_Runs_With_Average,daoMap);
            IPLMostRunsData[] runsData = new Gson().fromJson(sortedData, IPLMostRunsData[].class);
            Assert.assertEquals(" ", runsData[0].player);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLData_CheckRecordsOfBowlingData_ShouldReturnExactCount()
    {
        try
        {
            Map<String, IPLPlayerDAO> result=iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.WICKETS,IPL_MOST_WKTS_FILE_PATH);
            Assert.assertEquals(99,result.size());
        }
        catch (CSVBuilderException e)
        {
        }
    }

    @Test
    public void givenIPLData_CheckRecords_SortDataBasedOnBowlingAverage()
    {
        try
        {
            Map<String, IPLPlayerDAO> dataMap = iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.WICKETS,IPL_MOST_WKTS_FILE_PATH,IPL_MOST_RUNS_FILE_PATH);
            String dataString = iplAnalyser.getSortByField(SortByBasedOnField.Average, dataMap);
            IPLMostWicketsData[] wicketsData = new Gson().fromJson(dataString, IPLMostWicketsData[].class);
            Assert.assertEquals("Andre Russell", wicketsData[0].player);
        }
        catch (CSVBuilderException e)
        {
        }
    }

    @Test
    public void givenIPLData_CheckRecords_SortDataBasedOnBowlingStrikeRate()
    {
        try
        {
            Map<String,IPLPlayerDAO> daoMap=iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.WICKETS,IPL_MOST_WKTS_FILE_PATH,IPL_MOST_RUNS_FILE_PATH);
            String sortedData=iplAnalyser.getSortByField(SortByBasedOnField.Strike_Rate,daoMap);
            IPLMostWicketsData[] wicketsData=new Gson().fromJson(sortedData,IPLMostWicketsData[].class);
            Assert.assertEquals("Krishnappa Gowtham",wicketsData[0].player);
        }
        catch (CSVBuilderException e)
        {
        }
    }

    @Test
    public void givenIPLData_CheckRecords_SortDataBasedOnBowlingEconomyRate()
    {
        try
        {
            Map<String,IPLPlayerDAO> daoMap=iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.WICKETS,IPL_MOST_WKTS_FILE_PATH,IPL_MOST_RUNS_FILE_PATH);
            String sortedData=iplAnalyser.getSortByField(SortByBasedOnField.Economy_Rate,daoMap);
            IPLMostWicketsData[] wicketsData=new Gson().fromJson(sortedData,IPLMostWicketsData[].class);
            Assert.assertEquals("Shivam Dube",wicketsData[0].player);
        }
        catch (CSVBuilderException e)
        {
        }
    }

    @Test
    public void givenIPLData_CheckRecords_SortDataBasedOnBowling5Wicketsand4Wickets()
    {
        try
        {
            Map<String,IPLPlayerDAO> daoMap=iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.WICKETS,IPL_MOST_WKTS_FILE_PATH,IPL_MOST_RUNS_FILE_PATH);
            String sortedData=iplAnalyser.getSortByField(SortByBasedOnField.Result_Of_Five_Four_Wickets,daoMap);
            IPLMostWicketsData[] wicketsData=new Gson().fromJson(sortedData,IPLMostWicketsData[].class);
            Assert.assertEquals("Lasith Malinga",wicketsData[0].player);
        }
        catch (CSVBuilderException e)
        {
        }
    }

    @Test
    public void givenIPLData_CheckRecords_SortDataBasedOnBowlingStrikeRateWith5Wicketsand4Wickets()
    {
        try
        {
            Map<String,IPLPlayerDAO> daoMap=iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.WICKETS,IPL_MOST_WKTS_FILE_PATH,IPL_MOST_RUNS_FILE_PATH);
            String sortedData=iplAnalyser.getSortByField(SortByBasedOnField.Strike_Rate_Wth_Four_Five_Wickets,daoMap);
            IPLMostWicketsData[] wicketsData=new Gson().fromJson(sortedData,IPLMostWicketsData[].class);
            Assert.assertEquals("Kagiso Rabada",wicketsData[0].player);
        }
        catch (CSVBuilderException e)
        {
        }
    }

    @Test
    public void givenIPLData_CheckRecords_SortDataBasedOnBowlingAverageWithStrikeRate()
    {
        try
        {
            Map<String,IPLPlayerDAO> daoMap=iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.WICKETS,IPL_MOST_WKTS_FILE_PATH,IPL_MOST_RUNS_FILE_PATH);
            String sortedData=iplAnalyser.getSortByField(SortByBasedOnField.Great_Average_With_Strike_Rate,daoMap);
            IPLMostWicketsData[] wicketsData=new Gson().fromJson(sortedData,IPLMostWicketsData[].class);
            Assert.assertEquals("Andre Russell",wicketsData[0].player);
        }
        catch (CSVBuilderException e)
        {
        }
    }

    @Test
    public void givenIPLData_CheckRecords_SortDataBasedOnBowlingMaximumWicketsWithAverage()
    {
        try
        {
            Map<String,IPLPlayerDAO> daoMap=iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.WICKETS,IPL_MOST_WKTS_FILE_PATH,IPL_MOST_RUNS_FILE_PATH);
            String sortedData=iplAnalyser.getSortByField(SortByBasedOnField.Maximum_Wickets_With_Average,daoMap);
            IPLMostWicketsData[] playerDAO=new Gson().fromJson(sortedData,IPLMostWicketsData[].class);
            Assert.assertEquals("Imran Tahir",playerDAO[0].player);
        }
        catch (CSVBuilderException e)
        {
        }
    }

    @Test
    public void givenIPLData_CheckRecords_SortDataBasedOnBowlingAndBattingAverage()
    {
        try
        {
            Map<String,IPLPlayerDAO> daoMap=iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.WICKETS,IPL_MOST_WKTS_FILE_PATH,IPL_MOST_RUNS_FILE_PATH);
            String sortedData=iplAnalyser.getSortByField(SortByBasedOnField.Maximum_Batting_With_Bowling_Average,daoMap);
            IPLPlayerDAO[] playerDAO=new Gson().fromJson(sortedData,IPLPlayerDAO[].class);
            Assert.assertEquals("Andre Russell",playerDAO[0].player);
        }
        catch (CSVBuilderException e)
        {
        }
    }

    @Test
    public void givenIPLData_CheckRecords_SortDataBasedOnWickets()
    {
        try
        {
            Map<String,IPLPlayerDAO> daoMap=iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.WICKETS,IPL_MOST_WKTS_FILE_PATH,IPL_MOST_RUNS_FILE_PATH);
            String sortedData=iplAnalyser.getSortByField(SortByBasedOnField.Maximum_Wickets,daoMap);
            IPLPlayerDAO[] playerDAO=new Gson().fromJson(sortedData,IPLPlayerDAO[].class);
            Assert.assertEquals("Imran Tahir",playerDAO[0].player);
        }
        catch (CSVBuilderException e)
        {
        }
    }

    @Test
    public void givenIPLData_CheckRecords_SortDataBasedOnRuns()
    {
        try
        {
            Map<String,IPLPlayerDAO> daoMap=iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.RUNS,IPL_MOST_RUNS_FILE_PATH,IPL_MOST_WKTS_FILE_PATH);
            String sortedData=iplAnalyser.getSortByField(SortByBasedOnField.Maximum_Runs,daoMap);
            IPLPlayerDAO[] playerDAO=new Gson().fromJson(sortedData,IPLPlayerDAO[].class);
            Assert.assertEquals("David Warner ",playerDAO[0].player);
        }
        catch (CSVBuilderException e)
        {
        }
    }

    @Test
    public void givenIPLData_CheckRecords_SortDataBasedOnAllRounder()
    {
        try
        {
            Map<String,IPLPlayerDAO> daoMap=iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.WICKETS,IPL_MOST_WKTS_FILE_PATH,IPL_MOST_RUNS_FILE_PATH);
            String sortedData=iplAnalyser.getSortByField(SortByBasedOnField.All_Rounder,daoMap);
            IPLPlayerDAO[] playerDAO=new Gson().fromJson(sortedData,IPLPlayerDAO[].class);
            Assert.assertEquals("Andre Russell",playerDAO[0].player);
        }
        catch (CSVBuilderException e)
        {
        }
    }
}
