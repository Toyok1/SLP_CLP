package simpLanPlusLib;

public class SimpLanPluslib {
    private static int cLabel =0;
    private static int cFunctionLabel =0;
    private static String functionCode ="";

    public static String newLabel() {
        return "label"+(cLabel++);
    }

    public static String newFunctionLabel() {
        return "function"+(cFunctionLabel++);
    }

    public static void addCode(String c) {
        functionCode +="\n"+c;
    }

    public static String getCode() {
        return functionCode;
    }
}