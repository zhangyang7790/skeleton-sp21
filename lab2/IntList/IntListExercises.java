package IntList;

public class IntListExercises {

    /**
     * Part A: (Buggy) mutative method that adds a constant C to each
     * element of an IntList
     *
     * @param lst IntList from Lecture
     */
    public static IntList addConstant(IntList lst, int c) {
        // // first check if the list is empty
        // if (lst == null) {
        //     return null;
        // }
        // // Here Create a new IntList with the updated first element
        // IntList result = new IntList(lst.first + c, null);
        // IntList tail = result;

        // // Iterate through the rest of the list and update elements
        // IntList head = lst.rest;
        // while (head != null) {
        //     tail.rest = new IntList(head.first + c , null);
        //     head = head.rest;
        //     tail = tail.rest;
        // }
        // return result;
        IntList tmp = lst;
        while (tmp != null) {
            tmp.first += c;
            tmp = tmp.rest;
        }
        return lst;
    }

    /**
     * Part B: Buggy method that sets node.first to zero if
     * the max value in the list starting at node has the same
     * first and last digit, for every node in L
     *
     * @param L IntList from Lecture
     */
    public static void setToZeroIfMaxFEL(IntList L) {
        IntList p = L; // 计算子链表的最大值
        while (p != null) {
            if (firstDigitEqualsLastDigit(max(p))) {
                p.first = 0; // 满足条件则将当前节点值设置为0
            }
            p = p.rest; // 移动到下一个节点
        }
    }

    /** Returns the max value in the IntList starting at L. */
    public static int max(IntList L) {
        if ( L == null) {
            return 1;

        }
        int max = L.first;
        // Iterate through the rest of the list and update max
        IntList p = L.rest;
        while (p != null) {
            if (p.first > max) {
                max = p.first;
            }
            p = p.rest;
        }
        return max;
    }

    /** Returns true if the last digit of x is equal to
     *  the first digit of x.
     */
    public static boolean firstDigitEqualsLastDigit(int x) {
        // Convert x to positive to handle negative numbers
        // 末位数字： x % 10, 首位数字： 不断对X除以10， 直到剩下的数字小于10.
        x = Math.abs(x); // 处理负数

        int lastDigit = x % 10;
        while (x >= 10) {
            x = x / 10;
        }
        int firstDigit = x;
        return firstDigit == lastDigit;
    }

    /**
     * Part C: (Buggy) mutative method that squares each prime
     * element of the IntList.
     *
     * @param lst IntList from Lecture
     * @return True if there was an update to the list
     */
    public static boolean squarePrimes(IntList lst) {
        boolean updated = false; // 标记是否有更新
        IntList p = lst;

        while (p != null) {
            if (Primes.isPrime(p.first)) {
                p.first *= p.first; // 平方质数值
                updated = true;
            }
            p = p.rest;
        }
        return updated; // 返回是否有更新
    }
}
