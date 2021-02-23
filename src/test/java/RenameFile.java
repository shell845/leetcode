/**
 * @author YC 04/13/2020
 */

import java.io.File;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RenameFile {
    public static void main(String[] args) {
        File f = new File("../leetcode/src/");
        File[] fs = f.listFiles();
        if (fs != null) {
            Pattern p = Pattern.compile("\\D+\\d+");
            // Pattern p = Pattern.compile(".*");
            for (File file:fs) {
                String name = file.getName();
                Matcher m = p.matcher(name);
                if (m.find()) {
                    String[] s = name.split("\\.")[0].split("(?<=\\D)(?=\\d)()");
                    String newName = "_" + s[1] + "_" + s[0] + ".java";
                    file.renameTo(new File("../leetcode/src/" + newName));
                    System.out.println(newName);
                }
            }
        }
    }
}
