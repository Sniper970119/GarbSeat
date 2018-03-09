import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

/**
 * Created by admin on 2017/12/24.
 */
public class JudgeState {
    private static boolean success = false;
    private static boolean start = true;

    public void HandleSuccess(){
        this.success = true;
    }
    public boolean JudgeSuccess(){
        return success;
    }
    public boolean getStart(){
        return start;
    }
    public void setStart1(){
        this.start = true;
    }
    public void setStart2(){
        this.start = false;
    }

}
