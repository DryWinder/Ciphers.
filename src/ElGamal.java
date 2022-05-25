import java.math.BigInteger;

public class ElGamal {
    private BigInteger g;
    private BigInteger p;
    private BigInteger x;
    private BigInteger y;
    private BigInteger k;
    private BigInteger a;
    private BigInteger b;

    public ElGamal(BigInteger p, BigInteger g, BigInteger x, BigInteger k, int M) {
        this.g = g;
        this.p = p;
        this.x = x;
        this.y = (g.pow(x.intValue())).remainder(p);
        this.k = k;
        this.a = (g.pow(k.intValue())).remainder(p);
        this.b = ((y.pow(k.intValue())).multiply(BigInteger.valueOf(M))).remainder(p);

    }


    public void info(ElGamal elGamal){
        System.out.println("p = " + elGamal.p + " g = " + elGamal.g + " x = " + elGamal.x);
        System.out.println("y = " + elGamal.y + " k = " + elGamal.k + " a = " + elGamal.a + " b = " + elGamal.b);
    }

    public BigInteger decrypt(ElGamal elGamal){
        BigInteger a_pow = (a.modPow(x,p));
        BigInteger a_pow_inv = a_pow.modInverse(p);
        BigInteger decryptM = a_pow_inv.multiply(b).mod(p);
        System.out.println(decryptM);
        return decryptM;
    }

    public static void main(String[] args) {
        ElGamal elGamal = new ElGamal(BigInteger.valueOf(4339),BigInteger.valueOf(2),BigInteger.valueOf(8), BigInteger.valueOf(503), 2406);
        elGamal.info(elGamal);
        elGamal.decrypt(elGamal);
    }
}
