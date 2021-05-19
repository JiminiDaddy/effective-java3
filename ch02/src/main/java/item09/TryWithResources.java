package item09;

import java.io.*;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/17
 * Time : 3:22 PM
 */

public class TryWithResources {
    public static String firstLineOfFile(String path, String defaultValue) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public static void copy(String src, String dest) {
        final int BUFSIZE = 1024;
        try(InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dest)) {
            int n;
            byte[] buf = new byte[BUFSIZE];
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        firstLineOfFile("README.md", "DEFAULT");
        copy("README.md", "test3");
    }
}

