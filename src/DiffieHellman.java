import java.math.BigInteger;

public class DiffieHellman {
    private BigInteger g;
    private BigInteger p;
    private BigInteger a;
    private BigInteger b;
    private BigInteger A;
    private BigInteger B;

    public DiffieHellman(BigInteger g, BigInteger p) {
        this.g = g;
        this.p = p;
    }

    public void info(DiffieHellman dh) {
        System.out.println("p = " + dh.p + " g = " + dh.g);
        System.out.println("a = " + dh.a + " b = " + dh.b);
        System.out.println("A = " + dh.A + " B = " + dh.B);
    }

    public void A(BigInteger a){
        this.a = a;
        this.A = (g.pow(a.intValue())).remainder(p);
    }

    public void B(BigInteger b){
        this.b = b;
        this.B = (g.pow(b.intValue())).remainder(p);
    }

    public BigInteger senderKey(DiffieHellman dh, BigInteger b){
        dh.B(b);
        BigInteger key = (B.pow(a.intValue())).remainder(p);
        return key;
    }

    public BigInteger recieverKey(DiffieHellman dh, BigInteger a){
        dh.A(a);
        BigInteger key = (A.pow(b.intValue())).remainder(p);
        return key;
    }

    public void senderAction(DiffieHellman dh, BigInteger a, BigInteger b){
        dh.A(a);
        BigInteger key = senderKey(dh, b);
        System.out.println("Sender's key = " + key);
    }

    public void recieverAction(DiffieHellman dh, BigInteger a, BigInteger b){
        dh.B(b);
        BigInteger key = recieverKey(dh, a);
        System.out.println("Reciever's key = " + key);
    }

    public static void main(String[] args) {
        DiffieHellman dh = new DiffieHellman(BigInteger.valueOf(5), BigInteger.valueOf(19));
        dh.senderAction(dh, BigInteger.valueOf(5), BigInteger.valueOf(15));
        dh.recieverAction(dh, BigInteger.valueOf(5), BigInteger.valueOf(15));
        dh.info(dh);
    }

}
