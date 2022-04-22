package nine.one.figures;

import nine.one.ChessPiece;

import java.util.ArrayList;

public final class Knight extends ChessPiece {
    private final String ERROR_STATUS = "Нельзя сделать данный ход";

    @Override
    public void setPosition(String position){
        if (!getStatus()){
            if (position.charAt(0) == 'a' && position.charAt(1) == '2' || position.charAt(0) == 'a' && position.charAt(1) == '7'){
                super.setPosition(position);
                setStatus(true);
            } else {
                System.out.println("Нельзя изначально ставить коня в данную позицию");
            }
        } else {
            super.setPosition(position);
        }
    }

    @Override
    public ArrayList<String> canMoveTo(){
        ArrayList<String> arrayList = new ArrayList<>();
        int rows = getRows();
        int column = getColumn();
        int[][] a = getA();

        if (!(rows < 0 && !(column < 0)) && (!(rows > 8) && !(column > 8))){
            for (int i = 0; i <= a.length-1; i++){
                for (int j = 0; j <= a[i].length-1; j++){
                    if (i == rows && j == column){
                        a[rows][column-1] = 3;
                    }
                }
            }
            arrayList.add(bigStep().trim());
            arrayList.add(littleStep().trim());
        }
        return arrayList;
    }

    private String bigStep(){
        int rows = getRows();
        int column = getColumn();
        int[][] a = getA();

        int tempRows;
        int tempColumn;
        String result = null;

        if (rows <= 6 && column >= 1 && column <= 7){
            tempRows = rows + 2;
            tempColumn = column - 1;

            if (!(tempColumn > 8 || tempColumn < 0)){
                result = setLetter(tempRows) + "" + tempColumn + "\t";
                tempColumn = column + 2;

                if (!(tempColumn > 8)){
                    result = result + setLetter(tempRows) + "" + tempColumn + "\t";
                }
            }
        }
        else if (rows <= 6 && column >= 1){
            tempRows = rows + 2;
            tempColumn = column - 1;
            result = setLetter(tempRows) + "" + tempColumn;
        }
        else if (rows <= 6 && column <= 7){
            tempRows = rows + 2;
            tempColumn = column + 1;

            if (!(tempColumn > 8)){
                result = setLetter(tempRows) + "" + tempColumn + "\t";
            }
        } else {
            result = "Нет больших ходов";
        }
        return result;
    }

    public String littleStep(){
        int rows = getRows();
        int column = getColumn();
        int[][] a = getA();

        int tempRows = rows;
        int tempColumn = column;
        String result = null;

        if ((rows >= 1 && column >= 2) && (rows <= 7 && column <= 6)){
            tempRows = rows + 1;
            tempColumn = column + 2;

            if (!(tempColumn > 8)){
                result = setLetter(tempRows) + "" + tempColumn + "\t";
            }

            tempColumn = column + 4;

            if (!(tempColumn > 8)){
                result = result + setLetter(tempRows) + "" + tempColumn + "\t";
            }
        } else if (rows >= 1 && column >= 2){
            tempRows = rows + 1;
            tempColumn = column - 2;
            result = setLetter(tempRows) + "" + tempColumn + "\t";
        } else if (rows <= 7 && column <= 6){
            tempRows = rows + 1;
            tempColumn = column + 2;
            result = setLetter(tempRows) + "" + tempColumn + "\t";
        } else {
            result = "Нет маленьких ходов";
        }
        return result;
    }
}
