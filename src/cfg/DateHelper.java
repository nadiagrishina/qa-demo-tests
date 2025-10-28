import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
    public static String getCurrentDate() {
        Date d = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        SimpleDateFormat dtf = new SimpleDateFormat("dd.MM.yyyy");
        String currentDate = dtf.format(cal.getTime());
        return currentDate;
    }

    public static String getCurrentTime() {
        Date d = new Date();
        String currentTime = d.getHours() + "-" + d.getMinutes() + "-" + d.getSeconds();
        return currentTime;
    }
}
