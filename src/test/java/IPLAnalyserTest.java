import com.bridgelabz.CSVBuilderException;
import com.google.gson.Gson;
import ipl2019analyser.IPLAnalyser;
import ipl2019analyser.IPLMostRunsData;
import ipl2019analyser.SortByBasedOnField;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IPLAnalyserTest
{
    private static final String IPL_MOST_RUNS_FILE_PATH ="/home/admin1/Desktop/IPL2019Analyser/src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_MOST_WKTS_FILE_PATH="/home/admin1/Desktop/IPL2019Analyser/src/test/resources/IPL2019FactsheetMostWkts.csv";
    private static final String IPL_EMPTY_FILE_PATH="/home/admin1/Desktop/IPL2019Analyser/src/test/resources/IPL2019MostRuns.csv";
    private static final String IPL_WRONG_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String WRONG_IPL_FILE_TYPE="/home/admin1/Desktop/CensusAnalyser/src/test/resources/IPL2019MostRunsFile11.csv";
    private static final String IPL_MOST_WKTS_EMPTY_FILE_PATH="/home/admin1/Desktop/IPL2019Analyser/src/test/resources/IPL2019MostWickets.csv";
    IPLAnalyser iplAnalyser=new IPLAnalyser();

    @Test
    public void givenIPLMostRunsData_CheckFileIsPresentOrNot_ShouldReturnTrueOrFalse()
    {
            boolean result = iplAnalyser.checkIPLDataFile(IPL_MOST_RUNS_FILE_PATH);
            Assert.assertEquals(true,result);
    }

    @Test
    public void givenIPLMostRunsData_CheckFileIsEmptyOrNot_IfValidShouldReturnTrueOrFalse()
    {
        boolean result=iplAnalyser.checkIPLDataFileIsEmptyOrNot(IPL_MOST_RUNS_FILE_PATH);
        Assert.assertEquals(false,result);
    }

    @Test
    public void gievnIPLMostRunsDataFile_CheckFileCanRead_IfValidShouldReturnTrueOrFalse()
    {
        boolean result=iplAnalyser.checkIPLMostRunsDataFileCanRead(IPL_MOST_RUNS_FILE_PATH);
        Assert.assertEquals(true,result);
    }

    @Test
    public void gievnIPLMostRunsDataFile_CheckFileIsHiddenOrNot_IfValidShouldReturnTrueOrFalse()
    {
        boolean result=iplAnalyser.checkIPLMostRunsDataFileIsHidden(IPL_MOST_RUNS_FILE_PATH);
        Assert.assertEquals(false,result);
    }

    @Test
    public void givenIPLMostRunsData_WhenFileIsEmpty_ShouldThrowException()
    {
        try
        {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CSVBuilderException.class);
            iplAnalyser.loadIPLMostRunsAnalserData(IPL_EMPTY_FILE_PATH);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.UNABLE_TO_PARSE, e.type);
        }
    }

    @Test
    public void givenIPLMostRunsData_CheckRecords_ShouldReturnExactCount()
    {
        try
        {
            int result=iplAnalyser.loadIPLMostRunsAnalserData(IPL_MOST_RUNS_FILE_PATH);
            Assert.assertEquals(100,result);
        }
        catch (CSVBuilderException e)
        {
        }
    }

    @Test
    public void givenIPLMostRunsData_CheckFilePath_IfValid_ShouldThrowException()
    {
        try
        {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CSVBuilderException.class);
            iplAnalyser.loadIPLMostRunsAnalserData(IPL_WRONG_FILE_PATH);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLMostRunsData_IfNoFilePath_ShouldThrowException()
    {
        try
        {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CSVBuilderException.class);
            iplAnalyser.loadIPLMostRunsAnalserData(" ");
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLMostRunsData_IfFileTypeIncorrect_ShouldThrowException()
    {
        try
        {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CSVBuilderException.class);
            iplAnalyser.loadIPLMostRunsAnalserData(WRONG_IPL_FILE_TYPE);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenIPLMostRunsData_IncorrectDelimiter_ShouldReturnException()
    {
        try
        {
            ExpectedException exceptionRule=ExpectedException.none();
            exceptionRule.expect(CSVBuilderException.class);
            iplAnalyser.loadIPLMostRunsAnalserData(WRONG_IPL_FILE_TYPE);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenIPLMostRunsData_MissingHeader_ShouldReturnException()
    {
        try
        {
            ExpectedException exceptionRule=ExpectedException.none();
            exceptionRule.expect(CSVBuilderException.class);
            iplAnalyser.loadIPLMostRunsAnalserData(WRONG_IPL_FILE_TYPE);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenIPLMostRunsData_WhenIncorrectFileName_ShouldReturnException()
    {
        try
        {
            ExpectedException exceptionRule=ExpectedException.none();
            exceptionRule.expect(CSVBuilderException.class);
            iplAnalyser.loadIPLMostRunsAnalserData(WRONG_IPL_FILE_TYPE);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenUSCensusData_WhenSortedOnAverage_ShouldReturnSortedResult()
    {
        try
        {
            iplAnalyser.loadIPLMostRunsAnalserData(IPL_MOST_RUNS_FILE_PATH);
            String sortedData = iplAnalyser.getSortByField(SortByBasedOnField.Average);
            IPLMostRunsData[] censusCSV = new Gson().fromJson(sortedData, IPLMostRunsData[].class);
            Assert.assertEquals("MS Dhoni", censusCSV[0].player);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenUSCensusData_WhenSortedOnStrikeRate_ShouldReturnSortedResult()
    {
        try
        {
            iplAnalyser.loadIPLMostRunsAnalserData(IPL_MOST_RUNS_FILE_PATH);
            String sortedData = iplAnalyser.getSortByField(SortByBasedOnField.Strike_Rate);
            IPLMostRunsData[] censusCSV = new Gson().fromJson(sortedData, IPLMostRunsData[].class);
            Assert.assertEquals("Ishant Sharma", censusCSV[0].player);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenUSCensusData_WhenSortedOnFoursAndSixes_ShouldReturnSortedResult()
    {
        try
        {
            iplAnalyser.loadIPLMostRunsAnalserData(IPL_MOST_RUNS_FILE_PATH);
            String sortedData = iplAnalyser.getSortByField(SortByBasedOnField.Result_Of_Fours_Sixes);
            IPLMostRunsData[] censusCSV = new Gson().fromJson(sortedData, IPLMostRunsData[].class);
            Assert.assertEquals("Andre Russell", censusCSV[0].player);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenUSCensusData_WhenSortedOnStrikeRateWithFoursAndSixes_ShouldReturnSortedResult()
    {
        try
        {
            iplAnalyser.loadIPLMostRunsAnalserData(IPL_MOST_RUNS_FILE_PATH);
            String sortedData = iplAnalyser.getSortByField(SortByBasedOnField.Strike_Rate_With_SixesWithFours);
            IPLMostRunsData[] censusCSV = new Gson().fromJson(sortedData, IPLMostRunsData[].class);
            Assert.assertEquals("Andre Russell", censusCSV[0].player);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenUSCensusData_WhenSortedOnGreatAverageWithStrikeRate_ShouldReturnSortedResult()
    {
        try
        {
            iplAnalyser.loadIPLMostRunsAnalserData(IPL_MOST_RUNS_FILE_PATH);
            String sortedData = iplAnalyser.getSortByField(SortByBasedOnField.Great_Average_With_Strike_Rate);
            IPLMostRunsData[] censusCSV = new Gson().fromJson(sortedData, IPLMostRunsData[].class);
            Assert.assertEquals("MS Dhoni", censusCSV[0].player);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenUSCensusData_WhenSortedOnMaximumRuns_ShouldReturnSortedResult()
    {
        try
        {
            iplAnalyser.loadIPLMostRunsAnalserData(IPL_MOST_RUNS_FILE_PATH);
            String sortedData = iplAnalyser.getSortByField(SortByBasedOnField.Maximum_Runs_With_Average);
            IPLMostRunsData[] censusCSV = new Gson().fromJson(sortedData, IPLMostRunsData[].class);
            Assert.assertEquals("David Warner ", censusCSV[0].player);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLMostWicketsData_CheckFileIsPresentOrNot_ShouldReturnTrueOrFalse()
    {
        boolean result = iplAnalyser.checkIPLDataFile(IPL_MOST_WKTS_FILE_PATH);
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenIPLMostWicketsData_CheckFileIsEmptyOrNot_ShouldReturnTrueOrFalse()
    {
        boolean result = iplAnalyser.checkIPLDataFileIsEmptyOrNot(IPL_MOST_WKTS_FILE_PATH);
        Assert.assertEquals(false,result);
    }

    @Test
    public void givenIPLMostWicketsData_CheckFileCanReadOrNot_ShouldReturnTrueOrFalse()
    {
        boolean result = iplAnalyser.checkIPLMostRunsDataFileCanRead(IPL_MOST_WKTS_FILE_PATH);
        Assert.assertEquals(true,result);
    }

    @Test
    public void givenIPLMostWicketsData_CheckFileIsHiddenOrNot_ShouldReturnTrueOrFalse()
    {
        boolean result = iplAnalyser.checkIPLMostRunsDataFileIsHidden(IPL_MOST_WKTS_FILE_PATH);
        Assert.assertEquals(false,result);
    }

    @Test
    public void givenIPLMostWicketsData_WhenFileIsEmpty_ShouldThrowException()
    {
        try
        {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CSVBuilderException.class);
            iplAnalyser.loadIPLMostWktsAnalserData(IPL_MOST_WKTS_EMPTY_FILE_PATH);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.UNABLE_TO_PARSE, e.type);
        }
    }

}
