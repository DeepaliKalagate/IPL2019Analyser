import com.bridgelabz.CSVBuilderException;
import com.google.gson.Gson;
import ipl2019analyser.IPLAnalyser;
import ipl2019analyser.IPLMostRunsData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

public class IPLAnalyserTest
{
    private static final String IPL_FILE_PATH="/home/admin1/Desktop/IPL2019Analyser/src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_EMPTY_FILE_PATH="/home/admin1/Desktop/IPL2019Analyser/src/test/resources/IPL2019MostRuns.csv";
    private static final String IPL_WRONG_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String WRONG_IPL_FILE_TYPE="/home/admin1/Desktop/CensusAnalyser/src/test/resources/IPL2019MostRunsFile11.csv";
    IPLAnalyser iplAnalyser=new IPLAnalyser();

    @Test
    public void givenIPLMostRunsData_CheckFileIsPresentOrNot_ShouldReturnTrueOrFalse()
    {
            boolean result = iplAnalyser.CheckIPLDataFile(IPL_FILE_PATH);
            Assert.assertEquals(true,result);
    }

    @Test
    public void givenIPLMostRunsData_WhenFileIsEmpty_ShouldThrowException()
    {
        try
        {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CSVBuilderException.class);
            iplAnalyser.loadIPLAnalserData(IPL_EMPTY_FILE_PATH);
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
            int result=iplAnalyser.loadIPLAnalserData(IPL_FILE_PATH);
            Assert.assertEquals(101,result);
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
            iplAnalyser.loadIPLAnalserData(IPL_WRONG_FILE_PATH);
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
            iplAnalyser.loadIPLAnalserData(" ");
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
            iplAnalyser.loadIPLAnalserData(WRONG_IPL_FILE_TYPE);
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
            iplAnalyser.loadIPLAnalserData(WRONG_IPL_FILE_TYPE);
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
            iplAnalyser.loadIPLAnalserData(WRONG_IPL_FILE_TYPE);
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
            iplAnalyser.loadIPLAnalserData(WRONG_IPL_FILE_TYPE);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenUSCensusData_WhenSortedOnDensity_ShouldReturnSortedResult()
    {
        try
        {
            List<IPLMostRunsData> sortedCensusData = iplAnalyser.sortByAvg(IPL_FILE_PATH);
            Assert.assertEquals("MS Dhoni",sortedCensusData.get(0).player);
        }
        catch (CSVBuilderException e)
        {
        }
    }

}
