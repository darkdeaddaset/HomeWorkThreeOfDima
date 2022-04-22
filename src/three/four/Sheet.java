package three.four;

public class Sheet {
    private int width;
    private int height;
    private int count;
    private String name;

    public Sheet(){
        width = 841;
        height = 1189;
        name = "A";
    }

    public Sheet cutInHalf(Sheet sheet){
        count += 1;
        int temp = (width * height) / 2;

        sheet.setWidth(temp / width);
        sheet.setHeight(temp / width);

        return sheet;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public String getName(){
        return name + count;
    }
}
