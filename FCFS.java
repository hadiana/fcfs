import java.util.Scanner;

/**
 * Created by hadiana_sliwa on 2/16/19.
 */
public class FCFS {
    public static void main(String[] args) {

        System.out.println("Enter the number of process");
        Scanner in = new Scanner(System.in);
        int numberOfProcesses = in.nextInt();

        int pid[] = new int[numberOfProcesses];
        int bt[] = new int[numberOfProcesses];
        int ar[] = new int[numberOfProcesses];
        int ct[] = new int[numberOfProcesses];
        int ta[] = new int[numberOfProcesses];
        int wt[] = new int[numberOfProcesses];

        for(int i = 0; i < numberOfProcesses; i++) {
            System.out.println("Enter process " + (i+1) + " arrival time: ");
            ar[i] = in.nextInt();
            System.out.println("Enter process " + (i+1) + " brust time: ");
            bt[i] = in.nextInt();
            pid[i] = i+1;
        }
        int temp;
        for (int i = 0; i < numberOfProcesses; i++) {
            for (int j = i+1; j < numberOfProcesses; j++) {

                if(ar[i] > ar[j]) {
                    temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;

                    temp = pid[i];
                    pid[i] = pid[j];
                    pid[j] = temp;
                    temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;
                }
            }
        }

        System.out.println();
        ct[0] = bt[0] + ar[0];
        for(int i = 1; i < numberOfProcesses; i++) {
            ct[i] = ct[i - 1] + bt[i];
        }
        for(int i = 0; i < numberOfProcesses; i++) {
            ta[i] = ct[i] - ar[i];
            wt[i] = ta[i] - bt[i];
        }
        System.out.println("Process\t\tAT\t\tBT\t\tCT\t\tTAT\t\tWT");
        for(int i = 0; i < numberOfProcesses; i++) {
            System.out.println(pid[i]+"\t\t\t" + ar[i] + "\t\t" + bt[i]+ "\t\t" + ct[i]+ "\t\t" + ta[i]+ "\t\t" + wt[i]);
        }

        System.out.println("gantt chart: ");
        for(int i = 0; i < numberOfProcesses; i++) {
            System.out.print("P" + pid[i] +" ");
        }
    }

}
