package date;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.GregorianCalendar;

public class TestDateAPI
{

    
    public static void main(String [] args) throws ParseException
    {
        // 2018-01-01 13:00
        // 2017-01-02 01-00-00 AM
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd hh:mm");
        String dateInString = "2017-11-01 9:00"; //2018-01-01 13:00
        Date date1 = sdf.parse(dateInString);
        System.out.println(date1); //Tue Aug 31 10:20:56 SGT 1982
       
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-M-dd hh-mm-ss a");        
        String dateInString2 = "2018-12-01 01-00-00 PM"; //2018-01-01 13:00
        Date date2 = sdf2.parse(dateInString2);
        System.out.println(date2); //Tue Aug 31 10:20:56 SGT 1982
        
        int diff = date1.compareTo(date2);
        
        if(diff==1) {
            System.out.println("date 1 : "+date1+ " is greater ");
            System.out.println(calculateDifference(date1,date2));
            
        }else if(diff == -1) {
            System.out.println("date 1 : "+date1+ " is smaller ");
            System.out.println(calculateDifference(date1,date2));
        }else {
            System.out.println("Both dates are equal");
        }
            
        
        
//        
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");    
//        
//        Calendar calendar = new GregorianCalendar(2013,0,28,13,24,56);  
//        System.out.println("#1. " + sdf.format(calendar.getTime()));
//
//        //update a date
//        calendar.set(Calendar.YEAR, 2014);
//        calendar.set(Calendar.MONTH, 11);
//        calendar.set(Calendar.MINUTE, 33);
//            
//        System.out.println("#2. " + sdf.format(calendar.getTime()));

    }
    
    public static String calculateDifference(Date d1,Date d2){
        
      //in milliseconds
        long diff = d2.getTime() - d1.getTime();

        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);
       
        return diffDays + " days, "+diffHours + " hours, "+diffMinutes + " minutes, "+diffSeconds + " seconds.";

     }
}

