package nine.one.figures;

import nine.one.ChessPiece;

import java.util.ArrayList;

public final class Bishop extends ChessPiece {
    @Override
    public void setPosition(String position){
        if (!getStatus()) {
            if (position.charAt(0) == 'a' && position.charAt(1) == '3' || position.charAt(0) == 'a' && position.charAt(1) == '6') {
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
    public ArrayList<String> canMoveTo(){
        ArrayList<String> arrayList = new ArrayList<>();
        String result = null;
        int jResult;
        int rows = getRows();
        int column = getColumn();
        int[][] a = getA();

        if (!(rows < 0 && !(column < 0)) && (!(rows > 8) && !(column > 8))){
            for (int i = 0; i <= a.length-1; i++){
                for (int j = 0; j <= a[i].length-1; j++){
                    if (i == rows && j == column){
                        a[rows][column-1] = 4;
                    } if (i == j){
                        if (i != rows){
                            jResult = j + 1;
                            result = setLetter(i) + "" +jResult;
                            arrayList.add(result);
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
