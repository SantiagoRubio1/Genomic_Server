package server;
import model.*;
import protocol.Protocol;
import utils.*;
import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.security.KeyStore;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;

public class GenomicServer {
    private static final int PORT = 8443;
    private static final Logger logger = Logger.getLogger(GenomicServer.class.getName());

    private Map<String, Patient> patients = new ConcurrentHashMap<>();
    private Map<String, Disease> diseases = new HashMap<>();
    private ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public void start() {
        try {
            // Configurar SSL
            SSLServerSocket serverSocket = createSSLServerSocket();
            logger.info("Servidor iniciado en puerto " + PORT);

            // Cargar base de datos de enfermedades
            loadDiseaseDatabase();

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                threadPool.submit(new ClientHandler(clientSocket));
            }
        } catch (Exception e) {
            logger.severe("Error en servidor: " + e.getMessage());
        }
    }

    private SSLServerSocket createSSLServerSocket() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("src/resources/certificates/genomicserver.jks"),
                "password123".toCharArray());

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(keyStore, "password123".toCharArray());

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), null, null);

        SSLServerSocketFactory factory = sslContext.getServerSocketFactory();
        return (SSLServerSocket) factory.createServerSocket(PORT);
    }

    private void loadDiseaseDatabase() {
        // Implementar carga de archivos FASTA de enfermedades
        // desde src/resources/diseases/
    }

    private class ClientHandler implements Runnable {
        private SSLSocket socket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(SSLSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    processCommand(inputLine);
                }
            } catch (Exception e) {
                logger.warning("Error manejando cliente: " + e.getMessage());
            } finally {
                try { socket.close(); } catch (Exception e) {}
            }
        }

        private void processCommand(String command) {
            // Implementar procesamiento de comandos del protocolo
        }
    }
}