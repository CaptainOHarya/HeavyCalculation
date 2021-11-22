import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int port = 55555;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            try (Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    int numberInRow = Integer.parseInt(line);
                    out.println(fibonacciCalculation(numberInRow - 1));
                }
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }

    }
    // Метод, возвращающий n-ое число Фибонначи
    public static int fibonacciCalculation(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacciCalculation(n - 1) + fibonacciCalculation(n - 2);
        }
    }

}