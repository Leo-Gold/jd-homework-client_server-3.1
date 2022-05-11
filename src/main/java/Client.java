import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket(Const.URL.getUrl(), Const.PORT.getPort());
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
                BufferedReader in = new BufferedReader(inputStreamReader);
                ) {
            out.println("GET / HTTP/1.1\n" +
                    "Host: netology.homework");
            System.out.println(in.readLine());
            System.out.println(in.readLine());

            while (message(in, out));
            
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static boolean message(BufferedReader in, PrintWriter out) throws IOException {
        InputStreamReader inputStreamReaderConsole =  new InputStreamReader(System.in);
        BufferedReader userInput = new BufferedReader(inputStreamReaderConsole);
        boolean result;
        String output = in.readLine();
        if (!output.equals("exit")) {
            System.out.println(output);
            String input = userInput.readLine();
            out.println(input);
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
