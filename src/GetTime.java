import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * Created by admin on 2017/12/24.
 */
public class GetTime {
    public GetTime() throws Exception {
        URL url=new URL("http://www.taobao.com");//取得资源对象
        URLConnection uc=url.openConnection();//生成连接对象
        uc.connect(); //发出连接
        long ld=uc.getDate(); //取得网站日期时间
        Date date=new Date(ld); //转换为标准时间对象
        Time time = new Time();
        time.setDay(date.getDate());
        time.setHour(date.getHours());
        time.setMinute(date.getMinutes());
        time.setSecond(date.getSeconds());
//        System.out.println(time.getSecond());
//        System.out.println(time.getMinute());
//        System.out.println(time.getHour());
//        System.out.println(time.getDay());
    }
}
