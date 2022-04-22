package nine.one.figures;

import nine.one.ChessPiece;

import java.util.ArrayList;

public final class Rook extends ChessPiece {
    @Override
    public void setPosition(String position){
        if (!getStatus()) {
            if (position.charAt(0) == 'a' && position.charAt(1) == '1' || position.charAt(0) == 'a' && position.charAt(1) == '8') {
                super.setPosition(position);
                setStatus(true);
            } else {
                System.out.println("Нельзя изначально ставить слона в данную позицию");
            }
        } else {
            super.setPosition(position);
        }
    }

    @Override
    public ArrayList<String> canMoveTo() {
        ArrayList<String> arrayList = new ArrayList<>();
        int jResult;
        int rows = getRows();
        int column = getColumn();
        int[][] a = getA();


        if (!(rows < 0 && !(column < 0)) && (!(rows > 8) && !(column > 8))) {
            for (int i = 0; i <= a.length - 1; i++) {
                for (int j = 0; j <= a[i].length - 1; j++) {
                    if (i == rows && j == column) {
                        a[rows][column - 1] = 5;
                    }
                }
                arrayList = countSteps();
            }
        }
        return arrayList;
    }

    private ArrayList<String> countSteps(){
        ArrayList<String> arrayList = new ArrayList<>();
        int jResult;
        int rows = getRows();
        int column = getColumn();
        int[][] a = getA();

        for (int i = 0; i < 8 - rows; i++){
            arrayList.add(setLetter(i) + column);
        }
        for (int i = column; i <= 8 - column; i++){
            jResult = i + 1;
            arrayList.add(setLetter(rows) + jResult);
        }
        return arrayList;
    }
}