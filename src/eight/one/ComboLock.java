package eight.one;

public class ComboLock {
    private final int MAX = 39;
    private final int MIN = 0;
    private final int secret1;
    private final int secret2;
    private final int secret3;
    private int tik;
    private boolean status = false;

    public ComboLock(int secret1,
                     int secret2,
                     int secret3){
        this.secret1 = secret1;
        this.secret2 = secret2;
        this.secret3 = secret3;
    }

    public void reset(){
        tik = 0;
    }

    public void turnLeft(int ticks){
        tik -= ticks;

        if (tik < MIN) {
            tik += MAX;
        }
        if (status == true && tik == secret2){
            status = false;
        }else {
            status = true;
        }
    }

    public void turnRight(int ticks){
        tik += ticks;

        if (tik > MAX){
            tik -= MAX;
        }

        if (status == false && tik == secret1){
            status = true;
        } else if (status = false && tik == secret3)
            status = true;
        else {
            status = false;
        }
    }

    public boolean open(){
        if (status == true && tik == secret3){
            return true;
        }
        else {
            return false;
        }
    }
}
