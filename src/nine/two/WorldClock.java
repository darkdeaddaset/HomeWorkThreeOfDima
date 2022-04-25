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
        int hour = getLocalTime().getHour() + addHours;
        int minute = getLocalTime().getMinute();

        int hours = getSetHours();
        int minutes = getSetMinutes();

        System.out.println(hours);
        System.out.println(minutes);

        if (hour >= hours && minute >= minutes || hour > hours){
            return  hour + ":" + minute + " Alarm!";
        } else {
            return "Not Alarm!";
        }
    }
}
