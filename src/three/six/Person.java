package three.six;

public class Person {
    private String name;
    private String friends;
    private int count;

    public Person(String name){
        this.name = name;
        this.friends = "";
    }

    public void befriend(Person p){
        count += 1;
        friends += p.name + " ";
    }

    public void unfriend(Person p){
        count -= 1;
        friends = friends.replace(p.name, "");
    }

    public String getFriendNames(){
        return friends.trim();
    }

    public int getFriendCount(){
        return count;
    }
}
