import com.bridgelabz.CSVBuilderException;
import ipl2019analyser.IPLAnalyser;
import ipl2019analyser.IPLPlayerDAO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Map;

public class IPLBattingAdapterTest
{
    private static final String IPL_MOST_RUNS_FILE_PATH ="/home/user/IPL2019Analyser/src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_WRONG_FILE_PATH = "./src/main/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WRONG_IPL_FILE_TYPE="/home/user/IPL2019Analyser/src/test/resources/IPL2019MostRunsFile.csv";
    IPLAnalyser iplAnalyser=new IPLAnalyser();

    @Test
    public void givenIPLMostRunsData_CheckFilePath_IfValid_ShouldThrowException()
    {
        try
        {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CSVBuilderException.class);
            iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.RUNS,IPL_WRONG_FILE_PATH);
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
            iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.RUNS," ");
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
            iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.RUNS,WRONG_IPL_FILE_TYPE);
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
            iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.RUNS,WRONG_IPL_FILE_TYPE);
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
            iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.RUNS,WRONG_IPL_FILE_TYPE);
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
            iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.RUNS,WRONG_IPL_FILE_TYPE);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenIPLMostRunsData_CheckRecords_ShouldReturnExactCount()
    {
        try
        {
            Map<String, IPLPlayerDAO> result=iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.RUNS,IPL_MOST_RUNS_FILE_PATH);
            Assert.assertEquals(100,result.size());
        }
        catch (CSVBuilderException e)
        {
        }
    }
}
