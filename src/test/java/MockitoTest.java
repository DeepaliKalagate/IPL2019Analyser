import com.bridgelabz.CSVBuilderException;
import ipl2019analyser.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MockitoTest
{
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    IPLAnalyser iplAnalyser = new IPLAnalyser();

    Map<String, IPLPlayerDAO> dataList = null;
    private String IPL_MOST_RUNS_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";

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
    public void givenIPLMatchesRunsData_WhenCorrect_ShouldReturnList()
    {
        try
        {
            IPLAdapter iplAdapter = mock(IPLAdapter.class);
            setUp();
            when(iplAdapter.loadIPLData(IPL_MOST_RUNS_FILE_PATH)).thenReturn(dataList);
            Map<String, IPLPlayerDAO> daoMap = iplAdapter.loadIPLData(IPL_MOST_RUNS_FILE_PATH);
            Assert.assertEquals(5, daoMap.size());
        }
        catch (CSVBuilderException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLRunsData_WhenCorrect_ShouldReturnList()
    {
        IPLAdapter iplMostRunsAdapter = mock(IPLBuilderFactory.getIPLPlayer(IPLAnalyser.PlayerEnumTypes.RUNS).getClass());
        try
        {
            when(iplMostRunsAdapter.loadIPLData(IPL_MOST_RUNS_FILE_PATH)).thenReturn(dataList);
            Map<String, IPLPlayerDAO> matchesDAOList = iplMostRunsAdapter.loadIPLData(IPL_MOST_RUNS_FILE_PATH);
            assertEquals(5, matchesDAOList.size());
        }
        catch (CSVBuilderException e)
        {
            e.printStackTrace();
        }
    }



}





