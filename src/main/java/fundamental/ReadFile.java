package main.java.fundamental;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * @author YC (shell845)
 * @date 23/2/2021 10:34 AM
 */

public class ReadFile {
    public static void readFile() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.next());

        InputStream input = new FileInputStream("./src/main/resources/test.txt");
        for (;;) {
            int n = input.read(); // 反复调用read()方法，直到返回-1
            if (n == -1) {
                break;
            }
            System.out.println((char)n); // 打印byte的值
        }
        input.close(); // 关闭流

        BufferedReader reader = new BufferedReader(new FileReader("./src/main/resources/test.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();

        List<String> allLines = Files.readAllLines(Paths.get("./src/main/resources/test.txt"));
        for (String l : allLines) {
            System.out.println(l);
        }
    }

    public static void main(String args[]) throws IOException {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        readFile();
    }
}
