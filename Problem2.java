package USACOProblemSetDecember_2018;
		
		import java.io.*;
		import java.util.Arrays;

		public class Problem2 {
		    public static class Cow {
		        public int startTime;
		        public int endTime;
		        public int numBuckets;

		        public Cow(int startTime, int endTime, int numBuckets) {
		            this.startTime = startTime;
		            this.endTime = endTime;
		            this.numBuckets = numBuckets;
		        }

		    }

		    public static void main(String[] args) {
		        BufferedReader br = null;
		        try {
		            br = new BufferedReader(new FileReader("blist.in"));

		            int numberOfCows = Integer.parseInt(br.readLine());
		            Cow[] cows = new Cow[numberOfCows];
		            for (int i = 0; i < numberOfCows; i++) {
		                String cow[] = br.readLine().split(" ");
		                Cow cow1 = new Cow(Integer.parseInt(cow[0]), Integer.parseInt(cow[1]), Integer.parseInt(cow[2]));
		                cows[i] = cow1;
		            }

		            int[] timeSlots = new int[1001];
		            for (int i = 0; i < numberOfCows; i++) {
				if(cows[i].startTime <= cows[i].endTime) {
		                	for (int j = cows[i].startTime; j <= cows[i].endTime; j++) {
		                    		timeSlots[j] = timeSlots[j] + cows[i].numBuckets;
		                	}
				}
		            }

				int k;
				int max = timeSlots[1]; 
				for (k = 2; k < 1001; k++) 
		        	if (timeSlots[k] > max) 
		            	max = timeSlots[k]; 
		  

		            File fout = new File("blist.out");
		            FileOutputStream fos = new FileOutputStream(fout);
		            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		            bw.write("" + max);
		            bw.newLine();
		            bw.close();

		        } catch (IOException e) {

		        }

		    }
		
		
	}


