import com.bridgelabz.CSVBuilderException;
import ipl2019analyser.IPLAnalyser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IPLAnalyserTest
{
    private static final String IPL_FILE_PATH="/home/admin1/Desktop/IPL2019Analyser/src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_EMPTY_FILE_PATH="/home/admin1/Desktop/IPL2019Analyser/src/test/resources/IPL2019MostRuns.csv";
    IPLAnalyser iplAnalyser=new IPLAnalyser();

    @Test
    public void givenIPLMostRunsData_CheckFileIsPresentOrNot_ShouldReturnTrueOrFalse()
    {
            boolean result = iplAnalyser.CheckIPLDataFile(IPL_FILE_PATH);
            Assert.assertEquals(true,result);
    }

    @Test
    public void givenIPLDMostRunsData_WhenFileIsEmpty_ShouldThrowException()
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
}
