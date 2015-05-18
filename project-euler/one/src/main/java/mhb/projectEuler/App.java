package mhb.projectEuler;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class App {

    public static void main(String... args) {
        System.out.print(one());
    }

    /*
    # Run complete. Total time: 00:07:33

Benchmark                                          Mode  Cnt           Score         Error  Units
projectEuler.MyBenchmark.benchDirectMethod        thrpt   60  3477989218.486 ▒ 2745823.907  ops/s
projectEuler.MyBenchmark.benchOneMethod           thrpt   60       86523.778 ▒    1490.781  ops/s
projectEuler.MyBenchmark.benchOneStreamMethod     thrpt   60       19475.036 ▒     200.564  ops/s
projectEuler.MyBenchmark.benchOneParallelStreamSumMethod  thrpt   60  38468.320 ▒ 769.460  ops/s
projectEuler.MyBenchmark.benchOneStreamSumMethod  thrpt   60       81980.856 ▒     434.039  ops/s
projectEuler.MyBenchmark.benchOneStreamsMethod    thrpt   60       78305.225 ▒     210.831  ops/s

    */
    static int direct()
    {
        return 233168;
    }
    static int one() {
        // use a set, so when we add everything up, we only have unique values
        Set<Integer> multiples = new HashSet<>();

        // multiples of three
        for (int m = 3; m < 1000; m += 3) {
            multiples.add(m);
        }
        // multiples of 5
        for (int m = 5; m < 1000; m += 5) {
            multiples.add(m);
        }
        int acc = 0;
        for (Integer i : multiples) {
            acc += i;
        }
        return acc;
    }

    static int oneStreamSum() {
        // use a set, so when we add everything up, we only have unique values
        Set<Integer> multiples = new HashSet<>();

        // multiples of three
        for (int m = 3; m < 1000; m += 3) {
            multiples.add(m);
        }
        // multiples of 5
        for (int m = 5; m < 1000; m += 5) {
            multiples.add(m);
        }
        return multiples.stream().mapToInt(Integer::intValue).sum();
    }
    
    static int oneParallelStreamSum() {
        // use a set, so when we add everything up, we only have unique values
        Set<Integer> multiples = new HashSet<>();

        // multiples of three
        for (int m = 3; m < 1000; m += 3) {
            multiples.add(m);
        }
        // multiples of 5
        for (int m = 5; m < 1000; m += 5) {
            multiples.add(m);
        }
        return multiples.parallelStream().mapToInt(Integer::intValue).sum();
    }
    
    static int oneStreamsSumAndDifference() {
        int xStop = 1000/3;
        int yStop = 1000/3;
        int zStop = 1000/3;
        int x = IntStream.iterate(3, m -> m+3).limit(xStop).filter(m -> m < 1000).sum();
        int y = IntStream.iterate(5, m -> m+5).limit(yStop).filter(m -> m < 1000).sum();
        int z = IntStream.iterate(15, m -> m+15).limit(zStop).filter(m -> m < 1000).sum();
        return x + y - z;
    }

    static int oneStreamSumAndDifference() {
        int xStop = 1000/3;
        int yStop = 1000/3;
        int zStop = 1000/3;
        IntStream x = IntStream.iterate(3, m -> m+3).limit(xStop).filter(m -> m < 1000);
        IntStream y = IntStream.iterate(5, m -> m+5).limit(yStop).filter(m -> m < 1000);
        IntStream z = IntStream.iterate(15, m -> m+15).limit(zStop).filter(m -> m < 1000).parallel();
        int u = IntStream.concat(x, y).parallel().sum();
        return u - z.sum();
    }

}
