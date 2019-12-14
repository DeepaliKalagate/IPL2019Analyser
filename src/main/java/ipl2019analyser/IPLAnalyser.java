package ipl2019analyser;
import java.io.File;
public class IPLAnalyser
{
    public boolean loadIPLAnalserData(String iplFilePath)
    {
        File file=new File(iplFilePath);
            if (file.exists())
            {
                return true;
            }
            else
            {
                return false;
            }
    }
}
