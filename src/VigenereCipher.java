public class VigenereCipher {

    public static String encode(String plainText, String K, String alphabet){
        String encodedStr = "";
        int[] text_i = new int[plainText.length()];
        int[] K_i = new int[K.length()];
        int position = -1;

        for(char ch : K.toCharArray()){
            position++;
            K_i[position] = alphabet.indexOf(ch);
        }

        position = -1;

        int KlengthChecker = 0;
        for (char ch: plainText.toCharArray()) {
            position++;
            text_i[position] = alphabet.indexOf(ch);
            if(KlengthChecker >= K.length()){ KlengthChecker = 0;}
            if(Character.compare(ch,' ') == 0) {encodedStr += Character.toString(ch);}
            else{
                if(text_i[position] + K_i[KlengthChecker] <= alphabet.length() - 1)
                {encodedStr += Character.toString(alphabet.charAt(text_i[position] + K_i[KlengthChecker]));}
                else{
                    int pos = -(alphabet.length() - text_i[position] - K_i[KlengthChecker]);
                    if(pos >= alphabet.length()){
                        while(pos >= alphabet.length()){
                            pos = pos - alphabet.length();
                        }
                    }
                    encodedStr += Character.toString(alphabet.charAt(pos));
                }
            }
            KlengthChecker++;
        }
        return encodedStr;
    }

    public static String decode(String cryptoText, String K, String alphabet){
        String decodedStr = "";
        int[] text_i = new int[cryptoText.length()];
        int[] K_i = new int[K.length()];
        int position = -1;

        for(char ch : K.toCharArray()){
            position++;
            K_i[position] = alphabet.indexOf(ch);
        }

        position = -1;

        int KlengthChecker = 0;
        for (char ch: cryptoText.toCharArray()) {
            position++;
            text_i[position] = alphabet.indexOf(ch);
            if(KlengthChecker >= K.length()){ KlengthChecker = 0;}
            if(Character.compare(ch,' ') == 0) {decodedStr += Character.toString(ch);}
            else{
                if(text_i[position] - K_i[KlengthChecker] >= 0)
                {decodedStr += Character.toString(alphabet.charAt(text_i[position] - K_i[KlengthChecker]));}
                else{
                    int pos = (alphabet.length() + text_i[position] - K_i[KlengthChecker]);
                    if(pos < 0 ){
                        while(pos < 0 ){
                            pos = pos + alphabet.length();
                        }
                    }
                    decodedStr += Character.toString(alphabet.charAt(pos));
                }
            }
            KlengthChecker++;
        }
        return decodedStr;
    }

    public static void main(String[] args){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(encode("ihavebecomesonumb", "lpark", alphabet));
        System.out.println(decode("rpsposdr", "depo", alphabet));
    }
}
