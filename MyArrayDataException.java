public class MyArrayDataException extends NumberFormatException{
        private int columNum;
        private int lineNum;
    MyArrayDataException(int i, int j){
        super();
        columNum = i;
        lineNum = j;

    }

    public int getColumNum() {
        return columNum;
    }

    public int getLineNum() {
        return lineNum;
    }
}
