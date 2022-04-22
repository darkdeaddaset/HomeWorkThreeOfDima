package nine.one;

import java.util.ArrayList;

public class ChessPiece{
    private boolean status;
    private int rows;
    private int column;
    private int[][] a;

    public ChessPiece(){
        a = new int[8][8];
    }

    public void setPosition(String position){
        this.column = Integer.parseInt(String.valueOf(position.charAt(1)));
        this.rows = getNumber(position);
    }

    public ArrayList<String> canMoveTo(){
        ArrayList<String> arrayList = new ArrayList<>();
        String result;
        int jResult;

        if (!(rows < 0 && !(column < 0)) && (!(rows > 8) && !(column > 8))){
            for (int i = 0; i < a.length; i++){
                for (int j = 0; j < a[i].length; j++){
                    if (i == rows && j == column){
                        a[i][j] = 1;
                    } else {
                        a[i][j] = 0;
                        jResult = j + 1;
                        result = setLetter(i) + " " + jResult;
                        arrayList.add(result);
                    }
                }
            }
        }
        return arrayList;
    }

    protected int getNumber(String position){
        String str = "abcdefgh";
        int a = 0;

        for (int i = 0; i < str.length(); i++){
            if (position.charAt(0) == str.charAt(i)){
                a = i;
            }
        }
        return a;
    }

    protected String setLetter(int number){
        String str = "abcdefgh";
        String result = new String();

        for (int i = 0; i < str.length(); i++){
            if (i == number){
                result += str.charAt(i);
            }
        }
        return result;
    }

    public int getColumn(){
        return column;
    }
    public int getRows(){return rows;}
    public int[][] getA(){return a;}
    public boolean getStatus(){return status;}
    public void setStatus(boolean status){
        this.status = status;
    }
}
