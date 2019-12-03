public class StringTesting {

    public static void main(String[] args) {
        /*
        String s1 = new String("Vijay");
        String s2 = new String("Vijay");
        System.out.println("Str: s1==s2: " + s1 == s2);
        System.out.println("Str: s1.equals(s2): " + s1.equals(s2));

        StringBuffer s1buf = new StringBuffer("Vijay");
        StringBuffer s2buf = new StringBuffer("Vijay");
        System.out.println("SB: s1buf==s2buf: " + (s1buf == s2buf));
        System.out.println("SB: s1buf.equals(s2buf): " + s1buf.equals(s2buf));

        System.out.println("Str: Equals String: " + s3.equals(s4));
        */
        /*
        String s0 = new String("Vijay");
        String s0updt = s0.concat("Karani");
        String s01 = s0.concat("Ramesh");
        String s01updt = s01.concat("Uttoomal");
        System.out.println("s0="+s0 + ",s0updt=" + s0updt);
        System.out.println("s01="+s01 + ",s01updt="+s01updt);

        String s3 = "Karani";
        String s4 = "Karani";
        System.out.println("Str: s3==s4: " + (s3 == s4));
        */

        int iValue = 10;
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb = new StringBuffer("abcdefghijklmop");
        StringBuffer sb2 = new StringBuffer("a");
        System.out.println("sb1 capacity: " + sb1.capacity() + ", " + sb2.capacity() + ", " + sb.capacity());
        sb1.append("abcdefghijklmopqrst");
        sb.append("abcdefghijklmopqr");
        System.out.println("sb2 capacity: " + sb.capacity() + ", " + sb1.capacity());
        sb.append("abcdefghijklmopq");
        System.out.println("sb3 capacity: " + sb.capacity());
        sb.append("abcdefghijklmopq");
        System.out.println("sb4 capacity: " + sb.capacity());
    }
}
