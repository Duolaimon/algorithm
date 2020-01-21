package exam;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author HeJiageng
 * @Date 2019-05-28
 * @Desc
 */
public class PuYuan {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Socket socket = ss.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] reads = new byte[108];
        inputStream.read(reads);
    }
}
