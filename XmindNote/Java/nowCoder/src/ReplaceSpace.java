public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            int t = str.indexOf(" ", i);
            if (t > i) {
                result.append(str.substring(i, t));
            } else if (t < i) {
                result.append(str.substring(i));
                break;
            }
            result.append("%20");
            i = t;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace rS = new ReplaceSpace();
//        StringBuffer str = new StringBuffer("we are boys");
        StringBuffer str = new StringBuffer(" we are boys");
        String result = rS.replaceSpace(str);
        System.out.println(result);
    }
}
