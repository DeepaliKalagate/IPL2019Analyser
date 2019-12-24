import com.bridgelabz.CSVBuilderException;
import ipl2019analyser.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPLAdapterTest
{
    private static final String IPL_CSV_FILE = ".src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_WICKETS_CSV_FILE_PATH = ".src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private Map<String, IPLPlayerDAO> dataList;

    @Before
    public void setUp()
    {
        dataList = new HashMap<>();
        dataList.put("ipl",  new IPLPlayerDAO(1, "Lokesh", 500, 72.23, 53.6));
        dataList.put("ipl1", new IPLPlayerDAO(2, "Deepak", 200, 52.23, 23.3));
        dataList.put("ipl2", new IPLPlayerDAO(3, "Rahul", 300, 32.23, 33.3));
        dataList.put("ipl3", new IPLPlayerDAO(4, "Yogesh", 400, 42.23, 43.7));
        dataList.put("ipl4", new IPLPlayerDAO(5, "Rishabh", 100, 62.23, 23.9));
    }

    @Test
    public void GivenIPLRunsData_WhenCorrect_ShouldReturnExactSize()
    {
        IPLBattingAdapter iplAdapter = mock(IPLBattingAdapter.class);
        try
        {
            when(iplAdapter.loadIPLData(IPL_CSV_FILE)).thenReturn(dataList);
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.setIPLAdapter(iplAdapter);
            Map<String,IPLPlayerDAO> size = iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.RUNS, IPL_CSV_FILE);
            Assert.assertEquals(5,size.size());
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void GivenIPLWicketsData_WhenCorrect_ShouldReturnExactSize()
    {
        IPLAdapter iplAdapter = mock(IPLBowlingAdapter.class);
        try
        {
            when(iplAdapter.loadIPLData(IPL_WICKETS_CSV_FILE_PATH)).thenReturn(dataList);
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.setIPLAdapter(iplAdapter);
            Map<String,IPLPlayerDAO> size = iplAnalyser.getIPLPlayerData(IPLAnalyser.PlayerEnumTypes.WICKETS, IPL_WICKETS_CSV_FILE_PATH);
            Assert.assertEquals(5,size.size());
        }
        catch (CSVBuilderException e)
        {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }
}
