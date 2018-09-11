package idev.com.tesdycodebywildan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String dateFormatter(String tanggal) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = inputFormat.parse(tanggal);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return outputFormat.format(date);
    }
}
