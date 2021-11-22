import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String host = "127.0.0.1";
    private static final int port = 55555;

    public static void main(String[] args) {

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {
            String input;
            while (true) {
                System.out.println("Введите номер числа последовательности ряда Фибоначчи:");
                input = scanner.nextLine();
                out.println(input);
                if (input.equals("end"))
                    break;
                System.out.println("От сервера получен элемент: " + in.readLine());
            }

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace(System.out);
        }
    }

}
