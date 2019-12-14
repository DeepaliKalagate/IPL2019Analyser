import com.bridgelabz.CSVBuilderException;
import ipl2019analyser.IPLAnalyser;
import org.junit.Assert;
import org.junit.Test;

public class IPLAnalyserTest
{
    private static final String IPL_FILE_PATH="/home/admin1/Desktop/IPL2019Analyser/src/test/resources/IPL2019FactsheetMostRuns.csv";
    IPLAnalyser iplAnalyser=new IPLAnalyser();

    @Test
    public void givenIPLMostRunsData_CheckRecords_ShouldReturnExactCount()
    {
            boolean result = iplAnalyser.loadIPLAnalserData(IPL_FILE_PATH);
            Assert.assertEquals(true,result);
    }
}
