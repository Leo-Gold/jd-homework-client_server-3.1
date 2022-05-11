import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        socket();
    }

    public static void socket() {
        try (
                ServerSocket serverSocket = new ServerSocket(Const.PORT.getPort());
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
                BufferedReader in = new BufferedReader(inputStreamReader);
        ) {

            System.out.println("New connection accepted");
            final String name = in.readLine();
            out.println(String.format("Hi %s, your port is %d and %d", name, clientSocket.getLocalPort(), clientSocket.getPort()));
            String resp = in.readLine();
            out.println(resp);

            out.println("Write your name");
            final String username = in.readLine();
            out.println("Are you child? (yes/no)");
            final String isChild = in.readLine();
            if(isChild.equals("yes")) {
                out.println(String.format("Welcome to the kids area, %s! Let's play!", username));
            } else if (isChild.equals("no")) {
                out.println(String.format("Welcome to the adult zone, %s", username));
            }
            out.println("exit");

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
