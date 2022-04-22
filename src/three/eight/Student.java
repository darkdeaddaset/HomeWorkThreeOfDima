package three.eight;

public class Student {
    private String name;
    private int score;
    private int tests;

    public Student(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void addQuiz(int score){
        tests += 1;
        this.score += score;
    }

    public int getTotalScore(){
        return score;
    }

    public int getAverageScore(){
        return score/tests;
    }
}
