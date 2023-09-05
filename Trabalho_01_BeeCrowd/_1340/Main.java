package _1340;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                int n = scanner.nextInt();
                Stack<Integer> stack = new Stack<>();
                Queue<Integer> queue = new LinkedList<>();
                PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
                boolean isStack = true, isQueue = true, isPriorityQueue = true;

                for (int i = 0; i < n; i++) {
                    int operation = scanner.nextInt();
                    int x = scanner.nextInt();

                    if (operation == 1) {
                        stack.push(x);
                        queue.offer(x);
                        priorityQueue.offer(x);
                    } else {
                        if (stack.isEmpty() || stack.pop() != x) {
                            isStack = false;
                        }

                        if (queue.isEmpty() || queue.poll() != x) {
                            isQueue = false;
                        }

                        if (priorityQueue.isEmpty() || priorityQueue.poll() != x) {
                            isPriorityQueue = false;
                        }
                    }
                }

                if ((isStack && isQueue) || (isStack && isPriorityQueue) || (isQueue && isPriorityQueue)) {
                    System.out.println("not sure");
                } else if (isStack) {
                    System.out.println("stack");
                } else if (isQueue) {
                    System.out.println("queue");
                } else if (isPriorityQueue) {
                    System.out.println("priority queue");
                } else {
                    System.out.println("impossible");
                }
            }
        }
    }
}
