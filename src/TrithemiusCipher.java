import java.util.Locale;

public class TrithemiusCipher {
    public static String encodeLinear(String str, int A, int B, String alphabet){
        String encodedStr = "";
        int length = alphabet.length();
        int position = -1;

        for (char ch: str.toCharArray()) {
            position++;
            int NumOfChar = alphabet.indexOf(ch);
            //int position = str.indexOf(ch);
            int K = A*position + B;
            //System.out.println("ch - " + ch + " NumOfChar: " + NumOfChar + " K: " + K);
            if(Character.compare(ch,' ') == 0) {encodedStr += Character.toString(ch);}
            else{
                if(NumOfChar + K <= length - 1){ encodedStr += Character.toString(alphabet.charAt(NumOfChar + K));}
                else{
                    int pos = -(length - NumOfChar - K);
                    if(pos >= length){
                        while(pos >= length){
                            pos = pos - length;
                        }
                    }
                    encodedStr += Character.toString(alphabet.charAt(pos));
                }
            }
        }
        return encodedStr;
    }

    public static String decodeLinear(String str, int A, int B, String alphabet){
        String decodedStr = "";
        int length = alphabet.length();
        int position = -1;
        for (char ch: str.toCharArray()) {
            position++;
            int NumOfChar = alphabet.indexOf(ch);
            int K = A*position + B;
            if(Character.compare(ch,' ') == 0)
            {decodedStr += Character.toString(ch);}
            else{

                if(NumOfChar - K >= 0 ){ decodedStr += Character.toString(alphabet.charAt(NumOfChar - K));}
                else{
                    int pos = (length + NumOfChar - K);
                    if (pos < 0 ){
                        while(pos < 0){
                            pos = length + pos;
                        }
                    }
                    decodedStr += Character.toString(alphabet.charAt(pos));
                }
                //System.out.println(decodedStr);
            }
        }
        return decodedStr;
    }

    public static String encodeQuad(String str, int A, int B, int C, String alphabet){
        String encodedStr = "";
        int length = alphabet.length();
        int position = -1;

        for (char ch: str.toCharArray()) {
            position++;
            int NumOfChar = alphabet.indexOf(ch);
            //int position = str.indexOf(ch);
            int K = A*position*position + B*position + C;
            //System.out.println("ch - " + ch + " NumOfChar: " + NumOfChar + " K: " + K);
            if(Character.compare(ch,' ') == 0)
            {encodedStr += Character.toString(ch);}
            else{
                if(NumOfChar + K <= length - 1){ encodedStr += Character.toString(alphabet.charAt(NumOfChar + K));}
                else{
                    int pos = -(length - NumOfChar - K);
                    if(pos >= length){
                        while(pos >= length){
                            pos = pos - length;
                        }
                    }
                    encodedStr += Character.toString(alphabet.charAt(pos));
                }
            }
        }
        return encodedStr;
    }

    public static String decodeQuad(String str, int A, int B, int C, String alphabet){
        String decodedStr = "";
        int length = alphabet.length();
        int position = -1;
        for (char ch: str.toCharArray()) {
            position++;
            int NumOfChar = alphabet.indexOf(ch);
            int K = A*position*position + B*position + C;
            if(Character.compare(ch,' ') == 0)
            {decodedStr += Character.toString(ch);}
            else{

                if(NumOfChar - K >= 0 ){ decodedStr += Character.toString(alphabet.charAt(NumOfChar - K));}
                else{
                    int pos = (length + NumOfChar - K);
                    if (pos < 0 ){
                        while(pos < 0){
                            pos = length + pos;
                        }
                    }
                    decodedStr += Character.toString(alphabet.charAt(pos));
                }
                //System.out.println(decodedStr);
            }
        }
        return decodedStr;
    }

    public static void main(String[] args){

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String alphabetToUpper = alphabet.toUpperCase();
        //String str = "heads will roll";// якщо ви хочете зашифрувати слово в верхньому регістрі( наприклад FACULTY) - виберіть alphabetToUpper
        String str = "faculty";
        String enc = encodeQuad(str, 1, 2, 3,  alphabet);
        System.out.println("Encoded str: " + enc);
        System.out.println("Decoded str: " + decodeQuad(enc, 1, 2, 3, alphabet));
        for(int A = 0; A < 6; A++){
            for(int B = 0; B < 6; B++) {
                for (int C = 0; C < 6; C++) {
                    System.out.println("Decoded str: " + decodeQuad("hianvsfjoeagiwntmeshkygzjix", A, B, C, alphabet) + " A = " + A + " B = " + B + " C = " + C);
                    //System.out.println("Decoded str: " + decodeLinear("f txkq ql qoxsbi cxo xtxv pljbtebob ql qeb pbx xka ixv lk x ybxze", A, B, alphabet) + A + B);
                }
            }
        }
    }
}
