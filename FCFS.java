/* FCFS Practicla */

import java.text.ParseException;
public class FCFS{
    static void findwaiting(int []wt,int []bt,int n)
    {
        wt[0]=0;
        for(int i=1;i<n;i++)
        {
            wt[i]=wt[i-1]+bt[i-1];
        }
    }
    static void findaround(int []tat,int []wt,int []bt,int n)
    {
         for(int i=0;i<n;i++)
         {
            tat[i]=wt[i]+bt[i];
         }
    }
     static void findvalues(int []pid,int []bt,int n)
    {
        int []wt=new int[n];
        int tat[]=new int[n];

        findwaiting(wt,bt,n);
        findaround(tat,wt,bt,n);

        float avgwt=0,avgtat=0;
        System.out.println("process   brust     waiting     turnaround_time ");
        for(int i=0;i<n;i++)
        {
            System.out.println(pid[i]+"\t\t"+bt[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
            avgwt+=wt[i];
            avgtat+=tat[i];
        }
        System.out.println("The avreage waiting time : "+(float)avgwt/(float)n);
        System.out.println("The average turn around time  :"+(float)avgtat/(float)n);
    }
    public static void main(String[] args) throws ParseException
    {
        int []pid={1,2,3};
        int []bt={10,5,8};
        int n=pid.length;

        findvalues(pid,bt,n);
    }
}
