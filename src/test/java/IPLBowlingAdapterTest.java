import com.bridgelabz.CSVBuilderException;
import ipl2019analyser.IPLAnalyser;
import ipl2019analyser.IPLPlayerDAO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Map;

public class IPLBowlingAdapterTest
{
    private static final String IPL_MOST_WKTS_FILE_PATH="/home/user/IPL2019Analyser/src/test/resources/IPL2019FactsheetMostWkts.csv";
    private static final String IPL_MOST_WKTS_EMPTY_FILE_PATH="/home/user/IPL2019Analyser/src/test/resources/IPL2019MostWickets.csv";
    IPLAnalyser iplAnalyser=new IPLAnalyser();

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
    public void givenIPLMostWicketsData_WhenFileIsEmpty_ShouldThrowException()
    {
        try
        {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CSVBuilderException.class);
            iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.WICKETS,IPL_MOST_WKTS_EMPTY_FILE_PATH);
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.UNABLE_TO_PARSE, e.type);
        }
    }

    @Test
    public void givenIPLMostWicketsData_CheckRecords_ShouldReturnExactCount()
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
}
