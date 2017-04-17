package src.com.bjpowernode.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 类TestIOStream.java的实现描述：TODO 类实现描述
 * 读取流的三要素：1.开流必须
 * @author tangjinhui 2017年3月23日 上午8:39:32
 */
public class TestIOStream {
    private final static Log log = LogFactory.getLog(TestIOStream.class);

    public static void main(String[] args) {

        //=====================================================第一种读取IO流的方式一
        FileInputStream inputFile = null;
        Scanner sc = null;
        try {
            inputFile = new FileInputStream("C:\\Users\\tangjinhui\\Desktop\\test.html");
            sc = new Scanner(inputFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }

            if (sc.ioException() != null) {
                throw sc.ioException();
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.info("io" + e.getMessage());
        } finally {
            if (inputFile != null) {
                try {
                    inputFile.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    log.error("error message", e);
                }
            }

            if (sc != null) {
                sc.close();
            }

        }
        //=====================================================第一种读取IO流的方式一
    }
}
