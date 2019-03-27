package com.hackerrank.drawingbook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the pageCount function below.
     */

    static class couple {
        int fromFront;
        int fromBack;

        public couple setFromBack(int fromBack) {
            this.fromBack = fromBack;
            return this;
        }

        public couple setFromFront(int fromFront) {
            this.fromFront = fromFront;
            return this;
        }

        int getSmaller() {
            return fromFront < fromBack ? fromFront : fromBack;
        }
    }

    static int pageCount(int n, int p) {

        Map<Integer, couple> frontBook = new LinkedHashMap<Integer, couple>();
        frontBook.put(1, new couple().setFromFront(0));
        for (int i = 2; i <= n; i++) {
            int fromFront = i / 2;
            frontBook.put(i, new couple().setFromFront(fromFront));
        }

        for (int i = n; i >= 1; i--) {
            couple couple;
            if(n%2!=0){
                couple = frontBook.get(i).setFromBack((n - i)/2);
            }else{
                couple = frontBook.get(i).setFromBack((int)Math.ceil((float)(n - i)/2));
            }

            frontBook.put(i,couple);
        }

        return frontBook.get(p).getSmaller();
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    public int testPageCount(int n, int p) {
        return Solution.pageCount(n, p);
    }
}
