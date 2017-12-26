package chenweipan.journal.util;

public class StringUtil {

    public static boolean isNotEmpty(String str){
        if(str!=null){
            if(!str.equals(""))
                return true;
        }
        return false;
    }
}
