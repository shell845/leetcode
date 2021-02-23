package main.java.fundamental;

import java.io.*;
import java.net.URL;

/**
 * @author YC (shell845)
 * @date 13/2/2021 4:30 PM
 */

public class IODemo {
    public static void main(String args[]) throws IOException {
        URL url = new URL("http://www.baidu.com");

        /* 字节流 */
        InputStream is = url.openStream();

        /* 字符流 */
        InputStreamReader isr = new InputStreamReader(is, "utf-8");

        /* 提供缓存功能 */
        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}
