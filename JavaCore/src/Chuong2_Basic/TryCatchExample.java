package Chuong2_Basic;

public class TryCatchExample {
    public static void main(String[] args) {
        int number = toNumber("34");
        System.out.println("number = " + number);

        number = toNumber("as");
        System.out.println("number: " + number);
    }

    private static int toNumber(String value) {
        try {
            Integer integer = Integer.parseInt(value);
            return integer.intValue();
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
