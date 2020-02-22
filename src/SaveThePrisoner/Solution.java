package SaveThePrisoner;

import java.io.*;

public class Solution {
    // Complete the saveThePrisoner function below.
    /*
      n  : the number of prisoners
      m  : the number of sweets
      s  : the chair number to start passing out treats at
     */
    static int saveThePrisoner(int n, int m, int s) {
        int a = m + s - 1;
        if (a > n) {
            if (a % n == 0) return n;
            return a % n;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("src/SaveThePrisoner/input00.txt");
        File out = new File("src/SaveThePrisoner/output00.txt");
        FileReader fileReader = new FileReader(file);
        FileOutputStream fileWriter = new FileOutputStream(out);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileWriter));
        String line;
        line = bufferedReader.readLine();
        int k = Integer.parseInt(line);
        for (int i = 0; i < k; i++) {
            if (i == 2) {
                System.out.println("DEBUG");
            }
            line = bufferedReader.readLine();
            String[] input = line.split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int s = Integer.parseInt(input[2]);
            int result = saveThePrisoner(n, m, s);
            System.out.println(result);
            bufferedWriter.write(result + "");
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        fileReader.close();
        bufferedWriter.close();
        fileWriter.close();
    }
}
