public class CaesarCipher {

    public static String encode(String str, int K, String alphabet){
        String encodedStr = "";
        int length = alphabet.length();

        for (char ch: str.toCharArray()) {
            //System.out.println(ch);
            int NumOfChar = alphabet.indexOf(ch);
            //System.out.println(NumOfChar + K);
            if(Character.compare(ch,' ') == 0) {encodedStr += Character.toString(ch);}
            else{
                if(NumOfChar + K <= length - 1){ encodedStr += Character.toString(alphabet.charAt(NumOfChar + K));}
                else{
                    int pos = -(length - NumOfChar - K);
                    encodedStr += Character.toString(alphabet.charAt(pos));
                }
                //System.out.println(encodedStr);
            }
        }
        return encodedStr;
    }

    public static String decode(String str, int K, String alphabet){
        String decodedStr = "";
        int length = alphabet.length();

        for (char ch: str.toCharArray()) {
            //System.out.println(ch);
            int NumOfChar = alphabet.indexOf(ch);
            //System.out.println(NumOfChar - K);
            if(Character.compare(ch,' ') == 0)
            {decodedStr += Character.toString(ch);}
            else{

                if(NumOfChar - K >= 0 ){ decodedStr += Character.toString(alphabet.charAt(NumOfChar - K));}
                else{
                    int pos = (length + NumOfChar - K);
                    decodedStr += Character.toString(alphabet.charAt(pos));
                }
                //System.out.println(decodedStr);
            }
        }
        return decodedStr;
    }

    public static void main(String[] args){

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String str = "si vis pacem para bellum";
        //String str = "faculty";
        String enc = encode(str, 1, alphabet);
        System.out.println("Encoded str: " + enc);
        System.out.println("Decoded str: " + decode(enc, 25, alphabet));
        for(int K = 0; K < 26; K++){
            System.out.println("Decoded str: " + decode("f txkq ql qoxsbi cxo xtxv pljbtebob ql qeb pbx xka ixv lk x ybxze", K, alphabet) + K);
        }
    }
}
