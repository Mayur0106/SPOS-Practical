import java.util.*;
public class Fcfs{
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
         System.out.println( " Enter no of process  ");
         int n=sc.nextInt();
         int []pid=new int[n]; //* */
         int []ar=new int[n];  //* */
         int []bt=new int[n];  //* */
         int []ct=new int[n];
         int []ta=new int[n];
         int []wt=new int[n];

         int temp;
         float avgwt=0,avgta=0;
         for(int i=0;i<n;i++)
         {
            System.out.println("enter process "+(i+1)+" arrival Time ");
            ar[i]=sc.nextInt();
            System.out.println("enter process "+(i+1)+"brust time ");
            bt[i]=sc.nextInt();
            pid[i]=i+1;
         }
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<n-(i+1);j++)
        {
            if(ar[j]>ar[j+1])
            {
                temp=ar[j];
                ar[j]=ar[j+1];
                ar[j+1]=temp;
                temp=bt[j];
                bt[j]=bt[j+1];
                bt[j+1]=temp;
                temp=pid[j];
                pid[j]=pid[j+1];
                pid[j+1]=temp;
            }
        }
      }
      for(int i=0;i<n;i++)
      {
        if(i==0)
        {
            wt[i]=0;
        }
        else
        {
            wt[i]=wt[i-1]+bt[i-1];
        }
        ta[i]=wt[i]+bt[i];
        avgwt+=wt[i];
        avgta+=ta[i];
      }
      System.out.println("\n pid arrival brust complete turn waiting ");
      for(int i=0;i<n;i++)
      {
        System.out.println(pid[i]+"\t"+ar[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+ta[i]+"\t"+wt[i]);
      }
      sc.close();
      System.out.println("\n average waiting time: "+(avgwt/n));
      System.out.println("average turnaround time: "+(avgta/n));
    }
}