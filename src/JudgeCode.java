/**
 * Created by admin on 2017/12/23.
 */

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

public class JudgeCode {

    //设置APPID/AK/SK
    public static final String APP_ID = "你的百度云ORC信息";
    public static final String API_KEY = "你的百度云ORC信息";
    public static final String SECRET_KEY = "你的百度云ORC信息";

    public String run() {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 调用接口
        String path = "本地文件路径";     //本地文件路径
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());

        JSONObject word=(JSONObject)(res.getJSONArray("words_result").get(0)) ;
        String ocrresult=word.get("words").toString();
        //System.out.println(ocrresult);
        //System.out.println(res);
        return ocrresult;

    }
}
