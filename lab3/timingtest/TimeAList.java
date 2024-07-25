package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        int[] Ns = {1000, 2000,4000,8000,16000,32000,64000,128000};

        Alist<Integer> sizes = new Alist<>();
        Alist<Double> times = new Alist<>();
        Alist<Integer> opCounts = new Alist<>();

        for (int N : Ns) {
            Alist<Integer> list = new Alist<>();
            Stopwatch sw = new Stopwatch();

            for (int i = 0; i < N; i++) {
                list.addLast(i);
        }
            double timeInSeconds = sw.elapsedTime();

            sizes.addLast(N);
            times.addLasst(timeInSeconds);
            opCounts.addLast(N);
    }
}       
}
