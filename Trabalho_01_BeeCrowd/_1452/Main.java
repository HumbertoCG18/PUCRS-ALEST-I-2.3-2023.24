package _1452;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int N = scanner.nextInt(); // Número de servidores
            int M = scanner.nextInt(); // Número de clientes

            if (N == 0 && M == 0) {
                break; // Fim da entrada
            }

            HashMap<String, HashSet<Integer>> serverApplications = new HashMap<>();

            // Lê as aplicações fornecidas por cada servidor
            for (int i = 0; i < N; i++) {
                int Qi = scanner.nextInt(); // Número de aplicações fornecidas pelo servidor
                for (int j = 0; j < Qi; j++) {
                    String application = scanner.next();
                    if (!serverApplications.containsKey(application)) {
                        serverApplications.put(application, new HashSet<>());
                    }
                    serverApplications.get(application).add(i);
                }
            }

            int totalConnections = 0;

            // Processa as aplicações requisitadas por cada cliente
            for (int i = 0; i < M; i++) {
                int Pj = scanner.nextInt(); // Número de aplicações requisitadas pelo cliente
                HashSet<Integer> connectedServers = new HashSet<>();

                for (int j = 0; j < Pj; j++) {
                    String application = scanner.next();
                    if (serverApplications.containsKey(application)) {
                        connectedServers.addAll(serverApplications.get(application));
                    }
                }

                totalConnections += connectedServers.size();
            }

            System.out.println(totalConnections);
        }

        scanner.close();
    }
}
