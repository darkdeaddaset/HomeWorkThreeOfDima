package nine.two.second;

import java.time.LocalTime;

public class Clock {
    private static int hours;
    private static int minutes;
    private static LocalTime localTime;

    public Clock(){
        localTime = LocalTime.now();
    }

    public String getHours(){
        return localTime.toString().substring(0,2);
    }

    public void setAddHours(int hours){
        WorldClock.addHour = hours;
    }

    public String getNewHours(){
        return WorldClock.getNewHours();
    }

    public String getMinutes(){
        return localTime.toString().substring(3,5);
    }

    public String getTime(){
        return getHours() + ":" + getMinutes();
    }

    public static void setAlarmHours(int setHours, int setMinutes){
        if (!(hours < 0 && hours > 24)){
            hours = setHours;
        }
        if (!(minutes < 0 && minutes > 59)){
            minutes = setMinutes;
        }else if (minutes == 60 ){
            hours += 1;
        }
    }

    public static String getAlarm(){
        int hour = localTime.getHour();
        int minute = localTime.getMinute();

        if (hour >= hours && minute >= minutes){
            return  hour + ":" + minute + " Alarm!";
        }else if (hour >= hours && minute < minutes){
            return  hour + ":" + minute + " Alarm!";
        }
        else {
            return "Not Alarm!";
        }
    }

    public String getAlarmWorld(){
        return WorldClock.getAlarm();
    }

    public static class WorldClock{
        private static int addHour;

        public static String getNewHours(){
            return String.valueOf(Integer.parseInt(localTime.toString().substring(0,2)) + addHour);
        }

        public static String getAlarm(){
            int hour = localTime.getHour() + addHour;
            int minute = localTime.getMinute();

            if (hour >= hours && minute >= minutes){
                return  hour + ":" + minute + " Alarm!";
            }else if (hour >= hours && minute < minutes){
                return  hour + ":" + minute + " Alarm!";
            }
            else {
                return "Not Alarm!";
            }
        }
    }
}