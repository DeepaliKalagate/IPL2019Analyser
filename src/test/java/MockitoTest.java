import com.bridgelabz.CSVBuilderException;
import ipl2019analyser.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.*;
import java.util.stream.Stream;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class MockitoTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    Map<String, IPLPlayerDAO> dataList = null;
    private String IPL_MATCH_RUNS_DATA = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private String WRONG_IPL_MATCH_DATA = "./src/test/resources/WrongIPL2019FactsheetMostRuns.csv";
    private String EmptyIPL_MATCH_DATA = "./src/test/resources/EmptyFileIPL2019FactsheetMostRuns.csv";

    @Before
    public void setUp() {
        dataList = new HashMap<>();
        dataList.put("ipl", new IPLPlayerDAO(1, "Lokesh", 500, 72.23, 53.6));
        dataList.put("ipl1", new IPLPlayerDAO(2, "Deepali", 200, 52.23, 23.3));
        dataList.put("ipl2", new IPLPlayerDAO(3, "Prajkta", 300, 32.23, 33.3));
        dataList.put("ipl3", new IPLPlayerDAO(4, "Guru", 400, 42.23, 43.7));
        dataList.put("ipl4", new IPLPlayerDAO(5, "Anvika", 100, 62.23, 23.9));
    }

    @Test
    public void givenIPLMatchesRunsData_WhenCorrect_ShouldReturnList() {
        try {
            IPLAdapter iplAdapter = mock(IPLAdapter.class);
            setUp();
            when(iplAdapter.loadIPLData(IPL_MATCH_RUNS_DATA)).thenReturn((Map<String, IPLPlayerDAO>) dataList);
            Map<String, IPLPlayerDAO> daoMap = iplAdapter.loadIPLData(IPL_MATCH_RUNS_DATA);
            Assert.assertEquals(5, daoMap.size());
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLRunsData_WhenCorrect_ShouldReturnList() {
        IPLAdapter iplMostRunsAdapter = mock(IPLBuilderFactory.getIPLPlayer(IPLAnalyser.PlayerEnumTypes.RUNS).getClass());
        try {
            when(iplMostRunsAdapter.loadIPLData(IPL_MATCH_RUNS_DATA)).thenReturn(dataList);
            Map<String, IPLPlayerDAO> matchesDAOList = iplMostRunsAdapter.loadIPLData(IPL_MATCH_RUNS_DATA);
            assertEquals(5, matchesDAOList.size());
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }
}





