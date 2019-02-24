package USACOProblemSetDecember_2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Problem1 {

	public static void main(String[] args) {

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("mixmilk.in"));

			String first_bucket[] = br.readLine().split(" ");
			int c1 = Integer.parseInt(first_bucket[0]);
			int m1 = Integer.parseInt(first_bucket[1]);

			String second_bucket[] = br.readLine().split(" ");
			int c2 = Integer.parseInt(second_bucket[0]);
			int m2 = Integer.parseInt(second_bucket[1]);

			String third_bucket[] = br.readLine().split(" ");
			int c3 = Integer.parseInt(third_bucket[0]);
			int m3 = Integer.parseInt(third_bucket[1]);

			for (int i = 0; i < 33; i++) {
				if (c2 >= m1 + m2) {
					m2 = m1 + m2;
					m1 = 0;
				} else {
					m1 = (m1 + m2) - c2;
					m2 = c2;
				}

				if (c3 >= m2 + m3) {
					m3 += m2;
					m2 = 0;
				} else {
					m2 = (m2 + m3) - c3;
					m3 = c3;
				}

				if (c1 >= m3 + m1) {
					m1 += m3;
					m3 = 0;
				} else {
					m3 = (m3 + m1) - c1;
					m1 = c1;
				}

			}

			if (c2 >= m1 + m2) {
				m2 += m1;
				m1 = 0;
			} else {
				m1 = (m1 + m2) - c2;
				m2 = c2;
			}

			File fout = new File("mixmilk.out");
			FileOutputStream fos = new FileOutputStream(fout);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

			bw.write("" + m1);
			bw.newLine();
			bw.write("" + m2);
			bw.newLine();
			bw.write("" + m3);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
