package nine.two;

public class WorldClock extends Clock{
    private int addHours;

    public WorldClock(int addHours){
        super();
        this.addHours = addHours;
    }

    @Override
    public String getHours(){
        return String.valueOf(Integer.parseInt((super.getHours())) + addHours);
    }

    @Override
    public String getAlarm(){
        if (addHours < 0){
            addHours = Math.abs(addHours);
        }

        int hour = super.localTime.getHour() - addHours;
        int minute = super.localTime.getMinute();

        if (hour >= super.hours && minute >= minutes){
            return  hour + ":" + minute + " Alarm!";
        }else if (hour >= hours && minute < minutes){
            return  hour + ":" + minute + " Alarm!";
        }
        else {
            return "Not Alarm!";
        }
    }
}
