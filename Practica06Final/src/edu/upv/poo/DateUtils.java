package edu.upv.poo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author luisroberto
 */
public class DateUtils {
    
    public static final SimpleDateFormat ISO_DATE_FORMAT = 
            new SimpleDateFormat("yyyy-MM-dd") ;
    
    public static final SimpleDateFormat DATE_FORMAT =
            new SimpleDateFormat("dd/MM/yyyy");
    
    public static final SimpleDateFormat ISO_DATE_TIME_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public static final SimpleDateFormat DATE_TIME_FORMAT =
            new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    public static Date parseDate(String dateStr) {
        
        if (dateStr == null || dateStr.isEmpty()) return null;
        dateStr = dateStr.trim();
        
        try {
            return ISO_DATE_FORMAT.parse(dateStr);
        } catch (ParseException ex) { }
        
        try {
            return DATE_FORMAT.parse(dateStr);
        } catch (ParseException ex) { }
        
        return null;
    }
    
}
