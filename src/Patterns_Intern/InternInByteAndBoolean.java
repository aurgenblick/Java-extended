package Patterns_Intern;

public class InternInByteAndBoolean {
    /**
     * Here we show that since constructors in Byte.class and Boolean.class are public, new objects are created
     **/
    public static void main(String[] args) {
        Byte b1 = new Byte((byte) 12);
        Byte b2 = new Byte((byte) 12);
        System.out.println("Bytes got from new Byte(12) \nb1 = " + b1 + "\nb2 = " + b2 + "\nb1 == b2 : " + (b1 == b2));
        Byte b3 = new Byte((byte) 128);
        Byte b4 = new Byte((byte) 128);
        System.out.println("Bytes got from new Byte(128) \nb3 = " + b3 + "\nb4 = " + b4 + "\nb3 == b4 : " + (b3 == b4));

        Boolean boo1 = Boolean.valueOf(true);
        Boolean boo2 = new Boolean(true);
        System.out.println("Booleans got from valueOf(true) and new Boolean(true) \nboo1 = " + boo1 + "\nboo2 = " + boo2 + "\nboo1 == boo2 : " + (boo1 == boo2));
        Boolean boo3 = Boolean.valueOf(false);
        Boolean boo4 = new Boolean(false);
        System.out.println("Booleans got from valueOf(false) and new Boolean(false) \nboo3 = " + boo3 + "\nboo4 = " + boo4 + "\nboo3 == boo4 : " + (boo3 == boo4));
    }

}
