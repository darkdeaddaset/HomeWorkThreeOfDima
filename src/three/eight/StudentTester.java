package three.eight;

public class StudentTester{
    private Student student;

    //Достигаем жесткой привязки между Student и StudentScore
    public StudentTester(String name){
        student = new Student(name);
    }

    public String getName(){
        return student.getName();
    }

    public void addQuiz(int score){
        student.addQuiz(score);
    }

    public int getTotalScore(){
        return student.getTotalScore();
    }

    public int getAverageScore(){
        return student.getAverageScore();
    }
}
