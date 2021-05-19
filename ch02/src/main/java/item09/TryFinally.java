package item09;

import java.io.*;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/17
 * Time : 3:06 PM
 */

public class TryFinally {

    public static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path)) ;
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    public static void copy(String src, String dest) throws IOException {
        final int BUFFER_SIZE = 1024;
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dest);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0) {
                   out.write(buf, 0, n);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }

    public static void main(String[] args) throws Throwable {
        firstLineOfFile("README.md");
        copy("README.md", "test2");
    }
}
