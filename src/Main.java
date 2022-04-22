import eight.one.ComboLock;
import nine.one.*;
import nine.one.figures.*;
import nine.two.Clock;
import nine.two.WorldClock;
import three.eight.Student;
import three.eight.StudentTester;
import three.four.Sheet;
import three.nine.Battery;
import three.one.CashRegister;
import three.six.Person;

public class Main {
    public static void main(String[] args){
        testChess();
        testClock();
        testCombo();
        testBattery();
        testStudent();
        testPerson();
        testSheet();
        testRegister();
    }

    private static void testChess(){
        ChessPiece chessPiece = new ChessPiece();
        chessPiece.setPosition("a0");
        System.out.println(chessPiece.canMoveTo());
        int[][] a = chessPiece.getA();
        for (int[] b : a){
            for (int s : b){
                System.out.print(s + "\t");
            }
            System.out.println();
        }

        Pawn pawn = new Pawn();
        pawn.setPosition("b6");
        System.out.println(pawn.canMoveTo());
        int[][] ac = pawn.getA();
        for (int[] b : ac) {
            for (int s : b) {
                System.out.print(s + "\t");
            }
            System.out.println();
        }

        Knight knight = new Knight();
        knight.setPosition("a2");
        System.out.println(knight.canMoveTo());
        int[][] av = knight.getA();
        for (int[] b : av){
            for (int s : b){
                System.out.print(s + "\t");
            }
            System.out.println();
        }

        Bishop bishop = new Bishop();
        bishop.setPosition("a3");
        System.out.println(bishop.canMoveTo());
        int[][] ab = bishop.getA();
        for (int[] b : ab){
            for (int s : b){
                System.out.print(s + "\t");
            }
            System.out.println();
        }
        bishop.setPosition("c3");
        a = bishop.getA();
        System.out.println(bishop.canMoveTo());
        for (int[] b : a){
            for (int s : b){
                System.out.print(s + "\t");
            }
            System.out.println();
        }

        Rook rook = new Rook();
        rook.setPosition("a1");
        int[][] an = rook.getA();
        System.out.println(rook.canMoveTo());
        for (int[] b : an){
            for (int s : b){
                System.out.print(s + "\t");
            }
            System.out.println();
        }

        King king = new King();
        king.setPosition("a5");
        int[][] am = king.getA();
        System.out.println(king.canMoveTo());
        for (int[] b : am){
            for (int s : b){
                System.out.print(s + "\t");
            }
            System.out.println();
        }
    }
    private static void testClock(){
        Clock clock = new Clock();
        System.out.println(clock.getHours());
        System.out.println(clock.getMinutes());
        System.out.println(clock.getTime());

        clock.setAlarmHours(15, 40);

        System.out.println(clock.getAlarm());

        WorldClock worldClock = new WorldClock(-3);
        System.out.println(worldClock.getHours());
        worldClock.setAlarmHours(16,0);
        System.out.println(worldClock.getAlarm());
    }
    private static void testCombo(){
        ComboLock CurrentLock = new ComboLock(20, 10, 20);
        CurrentLock.reset();
        CurrentLock.turnRight(23);
        CurrentLock.turnLeft(18);
        CurrentLock.turnRight(9);
        System.out.println(CurrentLock.open());
        CurrentLock.reset();
        CurrentLock.turnRight(20);
        CurrentLock.turnLeft(10);
        CurrentLock.turnRight(10);
        System.out.println(CurrentLock.open());
    }
    private static void testBattery(){
        Battery battery = new Battery(2500);
        battery.drain(2500);
        battery.charge();
        System.out.println(battery.getRemainingCapacity());
    }
    private static void testStudent(){
        StudentTester studentTester = new StudentTester("Dima");
        System.out.println(studentTester.getName());
        studentTester.addQuiz(100);
        studentTester.addQuiz(50);
        studentTester.addQuiz(80);
        studentTester.addQuiz(50);
        studentTester.addQuiz(100);

        System.out.println(studentTester.getTotalScore());
        System.out.println(studentTester.getAverageScore());
    }
    private static void testPerson(){
        Person person = new Person("Dima");
        Person person1 = new Person("Sally");
        Person person2 = new Person("Catty");
        person.befriend(person1);
        person.befriend(person2);
        System.out.println(person.getFriendCount());
        System.out.println(person.getFriendNames());
        person.unfriend(person1);
        System.out.println(person.getFriendCount());
        System.out.println(person.getFriendNames());
    }
    private static void testSheet(){
        Sheet sheet = new Sheet();
        System.out.println(sheet.getName());
        sheet.cutInHalf(sheet);
        System.out.println(sheet.getName());
        System.out.println(sheet.getWidth());
        System.out.println(sheet.getHeight());
        sheet = sheet.cutInHalf(sheet);
        System.out.println(sheet.getWidth());
        System.out.println(sheet.getHeight());
        System.out.println(sheet.getName());
    }
    private static void testRegister(){
        CashRegister register = new CashRegister(13);
        System.out.println(register.getTotalTax());
        register.recordPurchase(29.50);
        register.recordPurchase(9.25);
        register.recordTaxablePurchase(15);
        register.recordTaxablePurchase(15);
        register.recordTaxablePurchase(15);
        System.out.println(register.getItem());
        System.out.println(register.getTotalTax());
        register.receivePayment(500);

        double change = register.giveChange();

        System.out.println(change);
        System.out.println("Expected: 11.25");
    }
}
