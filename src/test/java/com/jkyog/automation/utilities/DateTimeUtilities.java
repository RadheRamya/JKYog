/*
package com.jkyog.automation.utilities;

import org.threeten.bp.LocalDate;

public interface DateTimeUtilities {

    */
/*
     * get Current Date Month Year
     *//*


    */
/**//*
public static String getCurrentDateMonthYear(){

        LocalDate localDate = LocalDate.now();
       String loccalDate1 = localDate.toString();
       System.out.println(loccalDate1);
        return loccalDate1;
    }
    */
/*
     *get Current Time
     *//*


    public static String currentTime(){
        LocalTime localTime = LocalTime.now();
        String localTime1 = localTime.toString();
        System.out.println(localTime1);
        return localTime1;
    }
    */
/*
     * get Current Time Date Month Year
     *//*


    public static String getCurrentTimeDateMonthYear() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String localDateTime1 = localDateTime.toString();
        System.out.println(localDateTime1);
        return localDateTime1;
    }
    */
/*
     * Reusable function
     *//*


    private static int getCDY(int index)
    {
        String ymd = getCurrentDateMonthYear();//2023-09-28
        String[] ymd1 = ymd.split("-");//2023 09 28
        String date = ymd1[2];//28
        int todaysDate = Integer.parseInt(date);
        return todaysDate;
    }
    */
/*
     * get Current Date
     *//*


    public static int getCurrentDate()
    {
          int todaysDate = getCDY(2);
           System.out.println("Today date is: "+todaysDate);
           return todaysDate;
        }
    */
/* get Current Month
     *
     *//*


        public static int getCurrentMonth()
        {
            int currentMonth = getCDY(1);
            System.out.println("Today date is: "+currentMonth);
            return currentMonth;
        }
    */
/*
     * get Current Year
     *//*


        public static int getCurrentYear()
        {
            int currentYear = getCDY(0);
            System.out.println("Today date is: "+currentYear);
            return currentYear;
        }

        public static int getTomorrowDate()
        {
        LocalDate tomorrowDate = LocalDate.now().plusDays(1);
        System.out.println("Tomorrow date format is: "+tomorrowDate);
        String tmrd = String.valueOf(tomorrowDate);//2023-09-30
        String[] tmrd1 = tmrd.split("-");//2023 09 30
        String date = tmrd1[2];//30
        int tomorrowsDate = Integer.parseInt(date);
        System.out.println("Tomorrow date is: "+tomorrowsDate);
        return tomorrowsDate;
        }

    public static int getThreeMonthsAgoDate()
    {
        LocalDate threemnthagoDate = LocalDate.now().minusMonths(3);
        System.out.println("3 months ago date format is: "+threemnthagoDate);
        String tmrd = String.valueOf(threemnthagoDate);//2023-07-03
        String[] tmrd1 = tmrd.split("-");//2023 09 30
        String date = tmrd1[2];//30
        int threemnthagoDate1 = Integer.parseInt(date);
        System.out.println("3 months ago: "+threemnthagoDate1);
        return threemnthagoDate1;
    }

}
*/
