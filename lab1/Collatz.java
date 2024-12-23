public class Collatz {
    public static int nextNumber(int n) {
        if (n % 2 == 0) {
            return n / 2;

        } else {
            return 3 * n + 1;
        }
    }

    public static void main(String[] args){
        int n = 5;
        int count = 1;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
            count++;

        }
        System.out.println("\nSequence length: " + count);
    }
}

// 定义

// 考拉兹猜想（Collatz Conjecture）是一个简单但尚未证明的数学猜想，由德国数学家 Lothar Collatz 在 1937 年提出。其规则适用于任意正整数 
// n
// n，通过以下步骤产生一个数列：

// 如果 
// n
// n 是偶数，则下一个数字为 
// n
// /
// 2
// n/2。
// 如果 
// n
// n 是奇数，则下一个数字为 
// 3
// n
// +
// 1
// 3n+1。
// 不断重复上述步骤。
// 猜想的核心： 对于任意正整数 
// n
// n，经过有限次计算，最终都能收敛到 1。

