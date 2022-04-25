package nine.two;

import java.time.LocalTime;

public class Clock {
    private int hours;
    private int minutes;
    private LocalTime localTime;

    public Clock(){
        localTime = LocalTime.now();
    }

    public String getHours(){
        return localTime.toString().substring(0,2);
    }

    public String getMinutes(){
        return localTime.toString().substring(3,5);
    }

    public String getTime(){
        return getHours() + ":" + getMinutes();
    }

    public void setAlarmHours(int hours, int minutes){
        if (!(hours < 0 && hours > 24)){
            this.hours = hours;
        }
        if (!(minutes < 0 && minutes > 59)){
            this.minutes = minutes;
        }else if (minutes == 60 ){
            this.hours += 1;
        }
    }

    public String getAlarm(){
        int hour = localTime.getHour();
        int minute = localTime.getMinute();

        if (hour >= hours && minute >= minutes || hour > hours){
            return  hour + ":" + minute + " Alarm!";
        } else {
            return "Not Alarm!";
        }
    }

    public int getSetHours(){
        return hours;
    }

    public int getSetMinutes(){
        return minutes;
    }

    public LocalTime getLocalTime(){ return localTime;}
}