package nine.one.figures;

import nine.one.ChessPiece;

import java.util.ArrayList;

public final class Pawn extends ChessPiece {
    @Override
    public void setPosition(String position){
        if (!getStatus()){
            if (position.charAt(0) == 'a'){
                System.out.println("Нельзя создать у черной стороны пешку в строке А");
            } else {
                super.setPosition(position);
                setStatus(true);
            }
        } else {
            super.setPosition(position);
        }

    }

    @Override
    public ArrayList<String> canMoveTo(){
        ArrayList<String> arrayList = new ArrayList<>();
        String result;
        int rows = getRows();
        int column = getColumn();
        int[][] a = getA();


        if (!getStatus()){
            if (!(rows < 0 && !(column < 0)) && (!(rows > 8) && !(column > 8))){
                for (int i = 1; i <= 3; i++){
                    if (i == rows){
                        a[i][column-1] = 2;
                    } else if (i > rows){
                        a[i][column-1] = 0;
                        result = setLetter(i) + column;
                        arrayList.add(result);
                        setStatus(true);
                    }
                }
            }
        }
        else {
            if (!(rows < 0 && !(column < 0)) && (!(rows > 8) && !(column > 8))){
                for (int i = 1; i <= rows+1; i++){
                    if (i == rows){
                        a[i][column-1] = 2;
                    } else if (i > rows){
                        a[i][column-1] = 0;
                        result = setLetter(i) + column;
                        arrayList.add(result);
                    }
                }
            }
        }
        return arrayList;
    }
}
