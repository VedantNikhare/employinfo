import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class sp {
    public static void main(String[] args) throws UnknownHostException, IOException {
        try (
            Socket s = new Socket("127.0.0.1",0)) {
                System.out.println(s.getPort());
            }
    }
}
