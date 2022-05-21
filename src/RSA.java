import java.math.*;
import java.util.*;
public class RSA {
    private int p;
    private int q;
    private int e;
    private int n;
    private int f_n;
    private int d;

    public RSA(int p, int q, int e) {
        this.p = p;
        this.q = q;
        this.e = e;
        this.n = p*q;
        this.f_n = (p-1)*(q-1);
        this.d = D();
    }

    public void pr(int p, int q, int e){
        RSA rsa = new RSA(p, q, e);
        System.out.println(this.n + " " + this.f_n);
    }

    public int D(){
        int res = 0;
        for (int i = 0; i <= 9; i++) {
            int x = 1 + (i * f_n);

            if (x % e == 0) {
                res = x / e;
                break;
            }
        }
        return res;
    }

    // res = c_power_d mod(n)
    public int moduloEq(int c){
        int c_power_d = c^d;
        int res = 0;
        for (int i = 0; i <= 9; i++) {
            int x = 1 + (i * n);

            if (x % 1/c_power_d == 0) {
                res = x * c_power_d;
                break;
            }
        }
        return res;
    }
    private int mod(int x, int n)
    {
        int res = ((x % n) + n) % n;
        return res;
    }

    public int encryptForInt(int message){
        double c = (Math.pow(message, e)) % n;
        return (int)c;
    }
    public BigInteger decryptForInt(int c){
        BigInteger message;
        BigInteger N = BigInteger.valueOf(n);

        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        message = (C.pow(d)).mod(N);



        return message;
    }

    public int[] strToInt(String message){
        int[] intMessageArray = new int[message.length()];
        for (int i = 0; i < message.length(); i++) {
            int elOfIntArr = (int) message.charAt(i);
            intMessageArray[i] = elOfIntArr;
        }

        return intMessageArray;
    }

    public int[] encryptForStringMessage(String message){
        int[] intMessageArr = strToInt(message);
        int[] encryptedIntMessageArr = new int[intMessageArr.length];
        for (int i = 0; i < intMessageArr.length; i++) {
            double EncryptElemOfIntMessage = (Math.pow(intMessageArr[i], e)) % n;
            int elOfEncryptMessageArr = (int) EncryptElemOfIntMessage;
            encryptedIntMessageArr[i] = elOfEncryptMessageArr;
        }

        return encryptedIntMessageArr;
    }

    public String decryptForStringMessage(int[] array){
        char[] DecryptedCharMessageArr = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            BigInteger EncryptElemOfIntMessage = decryptForInt(array[i]);
            int elOfDecryptMessage = EncryptElemOfIntMessage.intValue();
            char elOfDecryptMessageArr = (char) elOfDecryptMessage;
            DecryptedCharMessageArr[i] = elOfDecryptMessageArr;
        }

        String decryptedMessage = new String(DecryptedCharMessageArr);
        return decryptedMessage;
    }

    public static void main(String[] args) {

        RSA rsa = new RSA(23, 19, 17);
        int[] enc = rsa.encryptForStringMessage("JACKPOTS");
        for (int i = 0; i < enc.length; i++) {
            System.out.print(enc[i] + ", ");
        }
        int[] encArr = {188, 371, 25, 287, 46, 282, 296, 46};
        System.out.println(rsa.decryptForStringMessage(encArr));
        //System.out.println(rsa.decryptForInt(4051753));
    }
}
