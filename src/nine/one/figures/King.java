package nine.one.figures;

import nine.one.ChessPiece;

import java.util.ArrayList;

public final class King extends ChessPiece {
    @Override
    public void setPosition(String position){
        if (!getStatus()) {
            if (position.charAt(0) == 'a' && position.charAt(1) == '5'){
                super.setPosition(position);
                setStatus(true);
            } else {
                System.out.println("Нельзя изначально ставить короля в данную позицию");
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
                        a[rows][column - 1] = 6;
                    }
                }
            }
            arrayList = countStep();
        }
        return arrayList;
    }

    private ArrayList<String> countStep(){
        ArrayList<String> arrayList = new ArrayList<>();
        int rows = getRows();
        int column = getColumn();

        int tempPlus = column + 1;
        int tempMinus = column - 1;
        if (rows != 0){
            arrayList.add(setLetter(rows) + tempPlus);
            arrayList.add(setLetter(rows) + tempMinus);
            arrayList.add(setLetter(rows+1) + column);
            arrayList.add(setLetter(rows+1) + tempPlus);
            arrayList.add(setLetter(rows+1) + tempMinus);
            arrayList.add(setLetter(rows-1) + column);
            arrayList.add(setLetter(rows-1) + tempPlus);
            arrayList.add(setLetter(rows-1) + tempMinus);
        } else if (rows == 0){
            arrayList.add(setLetter(rows) + tempPlus);
            arrayList.add(setLetter(rows) + tempMinus);
            arrayList.add(setLetter(rows+1) + column);
            arrayList.add(setLetter(rows+1) + tempPlus);
            arrayList.add(setLetter(rows+1) + tempMinus);
        } else if (rows == 7){
            arrayList.add(setLetter(rows) + tempPlus);
            arrayList.add(setLetter(rows) + tempMinus);
            arrayList.add(setLetter(rows-1) + column);
            arrayList.add(setLetter(rows-1) + tempPlus);
            arrayList.add(setLetter(rows-1) + tempMinus);
        }
        return arrayList;
    }
}
