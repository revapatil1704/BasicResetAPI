import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class BasicResetAPI {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // GET API
        server.createContext("/hello", (HttpExchange exchange) -> {

            if (exchange.getRequestMethod().equalsIgnoreCase("GET")) {

                String response = "Welcome to Basic REST API using Java";

                exchange.sendResponseHeaders(200, response.length());

                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });

        // POST API
        server.createContext("/data", (HttpExchange exchange) -> {

            if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {

                String response = "POST Request Received Successfully";

                exchange.sendResponseHeaders(200, response.length());

                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });

        server.setExecutor(null);
        server.start();

        System.out.println("Server started on port 8080");
    }
}