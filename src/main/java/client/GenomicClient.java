package client;

import javax.net.ssl.*;
import java.io.*;
import java.security.cert.X509Certificate;
import java.util.Scanner;

public class GenomicClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8443;

    public void start() {
        try {
            SSLSocket socket = createSSLSocket();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            showMenu();

            while (true) {
                System.out.print("Seleccione opción: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consumir newline

                switch (option) {
                    case 1:
                        createPatient(scanner, out, in);
                        break;
                    case 2:
                        getPatient(scanner, out, in);
                        break;
                    case 3:
                        updatePatient(scanner, out, in);
                        break;
                    case 4:
                        deletePatient(scanner, out, in);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en cliente: " + e.getMessage());
        }
    }

    private SSLSocket createSSLSocket() throws Exception {
        // Configurar SSL para aceptar certificados auto-firmados
        TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() { return null; }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());

        SSLSocketFactory factory = sc.getSocketFactory();
        return (SSLSocket) factory.createSocket(SERVER_HOST, SERVER_PORT);
    }

    private void showMenu() {
        System.out.println("=== Sistema Genómico Seguro ===");
        System.out.println("1. Crear paciente");
        System.out.println("2. Consultar paciente");
        System.out.println("3. Actualizar paciente");
        System.out.println("4. Eliminar paciente");
        System.out.println("5. Salir");
    }

    private void createPatient(Scanner scanner, PrintWriter out, BufferedReader in) {
        // Implementar creación de paciente
        System.out.println("Ingrese datos del paciente:");
        // Recopilar datos y enviar al servidor
    }
}