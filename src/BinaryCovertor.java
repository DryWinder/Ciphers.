public class BinaryCovertor {

    public static String binConvertor(String str){
        String binaryStr = new String();
        String temp = new String();
        char symbols[] = str.toCharArray();

        for(char ch : symbols){
            temp = String.format("%8s", Integer.toBinaryString(ch)).replaceAll(" ", "0");
            binaryStr += temp + " ";
        }

        return binaryStr;
    }
    public static String keyToBinConventor(String key){
        String binaryKey = new String();
        String strKey = new String();
        String[] nums = key.split(" ");

        for(String num : nums) {
            int number = Integer.parseInt(num);
            strKey += (char)number;
        }

        binaryKey = BinaryCovertor.binConvertor(strKey);
        return binaryKey;
    }


    public static String binToStrConvertor(String binary) {
        String[] parts = binary.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String part : parts) {
            int val = Integer.parseInt(part, 2);
            String c = Character.toString(val);
            sb.append(c);
        }

        String Str = sb.toString();
        return Str;
    }

    public static void main(String[] args){
        System.out.println(binToStrConvertor("10111010 11111011 10011000 00000011 00110011 00100000 11001111 01110011 10001111 00110111 10110111"));
        System.out.println(keyToBinConventor("186 251 152 3 51 32 207 115 143 55 183 115 3 252 "));
    }
}
