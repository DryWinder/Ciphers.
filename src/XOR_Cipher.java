import java.util.Random;

public class XOR_Cipher {

    public static String keyGenerator(String plainText, int seed){
        String key = new String();
        Random generator = new Random(seed);

        for(int index = 0; index < plainText.length(); index++){
            int part = generator.nextInt(256);
            String temp = Integer.toString(part);
            key += temp + " ";
        }

        return key;
    }

    public static String encode(String plainText, int seed){
        String encodedStr = new String();
        String binText = BinaryCovertor.binConvertor(plainText);
        String keyTemp = keyGenerator(plainText, seed);
        String key = BinaryCovertor.keyToBinConventor(keyTemp);

        System.out.println("Text: " + binText);
        System.out.println("Key: " + key);

        key = key + " ";// add space to get red of exception that wiil occure in line 32
        char textChars[] = binText.toCharArray();
        char keyChars[] = key.toCharArray();

        if(key.length() < binText.length()){key += key;}
        for(int pos = 0; pos < binText.length(); pos++){
            int textNum = Character.getNumericValue(textChars[pos]);
            int keyNum = Character.getNumericValue(keyChars[pos]);

            int resNum = textNum + keyNum;

            if(resNum == 2){encodedStr += Integer.toString(0);}
            else if(resNum == -2){encodedStr += " ";}
            else{encodedStr += Integer.toString(resNum);}
        }
        return encodedStr;
    }

    public static String decode(String cryptoText, String key){
        String decodedStr = "";

        char textChars[] = cryptoText.toCharArray();
        char keyChars[] = key.toCharArray();

        if(key.length() < cryptoText.length()){key += key;}
        for(int pos = 0; pos < cryptoText.length(); pos++){
            int textNum = Character.getNumericValue(textChars[pos]);
            int keyNum = Character.getNumericValue(keyChars[pos]);

            int resNum = textNum + keyNum;

            if(resNum == 2){decodedStr += Integer.toString(0);}
            else if(resNum == -2){decodedStr += " ";}
            else{decodedStr += Integer.toString(resNum);}
        }
        System.out.println("Decoded binary sequence: " + decodedStr);
        return BinaryCovertor.binToStrConvertor(decodedStr);
    }

    public static void main(String[] args){
        System.out.println("Crypto text: " + encode("UKRAINE", 8));
        System.out.println("Decoded text: " + decode("11101111 10110000 11001010 01000010 01111010 01101110 10001010", "10111010 11111011 10011000 00000011 00110011 00100000 11001111"));
    }
}
