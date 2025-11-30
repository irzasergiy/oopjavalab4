import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        int N = 15;
        int M = 5;
        int a = 30;
        int b = 50;
        Random r = new Random();

        List<IntStream> streams = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = a + r.nextInt(b - a + 1);
            }
            streams.add(Arrays.stream(arr));
        }

        IntStream result = streams.stream().reduce(IntStream.empty(), IntStream::concat);
        result.forEach(x -> System.out.print(x + " "));
    }
}
