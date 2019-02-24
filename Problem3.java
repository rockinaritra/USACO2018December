package USACOProblemSetDecember_2018;

import java.io.*;
import java.util.*;

public class Problem3 {
    // Function to remove the element
    public static String[] adjustArray(String[] arr,
                                       int index) {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }

        // Create another array of size one less
        String[] anotherArray = new String[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }

        // return the resultant array
        return anotherArray;
    }

    public static void main(String[] args) {


        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("backforth.in"));
            String barn1[] = br.readLine().split(" ");
            String barn2[] = br.readLine().split(" ");
            String[] barn1RemainsDay1 = new String[9];
            String[] barn2RemainsDay1 = new String[11];
            String[] barn1RemainsDay2 = new String[10];
            String[] barn2RemainsDay2 = new String[10];
            String[] barn2RemainsDay3 = new String[11];


            Set<Integer> set1 = new HashSet<Integer>();
            Set<Integer> set2 = new HashSet<Integer>();
            Set<Integer> set3 = new HashSet<Integer>();
            Set<Integer> set4 = new HashSet<Integer>();
            int barn1_init = 1000;

            for (int i = 0; i < 10; i++) {
                set1 = new HashSet<Integer>();
                set2 = new HashSet<Integer>();
                set3 = new HashSet<Integer>();
                // day 1
                set1.add(barn1_init - Integer.parseInt(barn1[i]));
                barn1RemainsDay1 = adjustArray(barn1, i);
                System.arraycopy(barn2, 0, barn2RemainsDay1, 0, barn2.length);
                barn2RemainsDay1[barn2.length] = barn1[i];
                // day 2
                for (int k = 0; k < 11; k++) {
                    for (Iterator<Integer> it = set1.iterator(); it.hasNext(); ) {
                        Integer f = it.next();
                        set2.add(f + Integer.parseInt(barn2RemainsDay1[k]));
                    }
                    barn2RemainsDay2 = adjustArray(barn2RemainsDay1, k);
                    System.arraycopy(barn1RemainsDay1, 0, barn1RemainsDay2, 0, barn1RemainsDay1.length);
                    barn1RemainsDay2[9] = barn2RemainsDay1[k];
                    //day 3
                    for (int l = 0; l < 10; l++) {
                        for (Iterator<Integer> it = set2.iterator(); it.hasNext(); ) {
                            Integer f = it.next();
                            set3.add(f - Integer.parseInt(barn1RemainsDay2[l]));
                        }
                        System.arraycopy(barn2RemainsDay2, 0, barn2RemainsDay3, 0, barn2RemainsDay2.length);
                        barn2RemainsDay3[10] = barn1RemainsDay2[l];

                        // day 4
                        for (int m = 0; m < 11; m++) {
                            for (Iterator<Integer> it = set3.iterator(); it.hasNext(); ) {
                                Integer f = it.next();
                                set4.add(f + Integer.parseInt(barn2RemainsDay3[m]));

                            }
                        }
                        set3.clear();
                    }
                    set2.clear();
                }
                set1.clear();
            }

            int result = set4.size();


            File fout = new File("backforth.out");
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write("" + result);
            bw.newLine();
            bw.close();

        } catch (IOException e) {

        }
    }
}