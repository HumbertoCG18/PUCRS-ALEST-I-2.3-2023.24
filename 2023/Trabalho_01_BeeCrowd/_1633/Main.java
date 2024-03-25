package _1633;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            int i, t = 1;
            long ans = 0;
            PriorityQueue<Pair> q = new PriorityQueue<>();

            Pair[] proc = new Pair[n];

            for (i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                proc[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            java.util.Arrays.sort(proc);

            i = 0;

            while (i < n || !q.isEmpty()) {
                while (i < n && proc[i].first <= t) {
                    q.add(new Pair(proc[i].second, proc[i].first));
                    i++;
                }

                if (!q.isEmpty()) {
                    ans += t - q.peek().second;
                    t += q.peek().first;
                    q.poll();
                } else if (i < n) {
                    t = proc[i].first;
                }
            }

            System.out.println(ans);
        }
    }

    static class Pair implements Comparable<Pair> {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.first, other.first);
        }
    }
}
