package eight.one;

public class ComboLock {
    private final int MAX = 39;
    private final int MIN = 0;
    private final int secret1;
    private final int secret2;
    private final int secret3;
    private int tik;
    private int step;
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
        step = 0;
    }

    public void turnLeft(int ticks){
        tik -= ticks;

        if (tik < MIN) {
            tik += MAX;
        }

        if (status && tik == secret2){
            status = false;
            step++;
        }else {
            status = true;
        }
    }

    public void turnRight(int ticks){
        tik += ticks;

        if (tik > MAX){
            tik -= MAX;
        }

        if (step == 0){
            status = checkTurnRight(secret1);
            step++;
        } else {
            status = checkTurnRight(secret3);
        }
    }
    
    private boolean checkTurnRight(int secret){
        return !status && tik == secret;
    }
    public boolean open(){
        return status && tik == secret3;
    }
}