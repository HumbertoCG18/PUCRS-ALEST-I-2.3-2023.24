import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class P1452{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            if (n == 0 && m == 0)
                break;
            Map<String, List<Integer>> serversForApp = new HashMap<>();
            List<List<Boolean>> connected = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int apps = scanner.nextInt();
                List<Boolean> row = new ArrayList<>();
                for (int j = 0; j < m; ++j) {
                    row.add(false);
                }
                connected.add(row);
                for (int j = 0; j < apps; ++j) {
                    String app = scanner.next();
                    if (!serversForApp.containsKey(app)) {
                        serversForApp.put(app, new ArrayList<>());
                    }
                    serversForApp.get(app).add(i);
                }
            }
            int connectionCount = 0;
            for (int i = 0; i < m; ++i) {
                int apps = scanner.nextInt();
                for (int j = 0; j < apps; ++j) {
                    String app = scanner.next();
                    List<Integer> servers = serversForApp.get(app);
                    for (int k = 0; k < servers.size(); ++k) {
                        if (!connected.get(servers.get(k)).get(i)) {
                            connected.get(servers.get(k)).set(i, true);
                            ++connectionCount;
                        }
                    }
                }
            }
            System.out.println(connectionCount);
        }
        scanner.close();
    }
}
