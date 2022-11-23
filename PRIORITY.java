import java.util.Scanner;
public class PRIORITY {
    public static void main(String[] args)
    {
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the no of process : ");
       int n=sc.nextInt();
       int []pid=new int[n];
       int []at=new int[n];
       int []bt=new int[n];
       int []ct=new int[n];
       int []tat=new int[n];
       int []wt=new int[n];
       int []priority=new int[n];

       for(int i=0;i<n;i++)
       {
            System.out.printf("Ente the %d Arival time : \n",(i+1));
            at[i]=sc.nextInt();
            System.out.printf("Enter the %d Brust time : ",(i+1));
            bt[i]=sc.nextInt();
            System.out.printf("Enter the %d Priority : ",(i+1));
            priority[i]=sc.nextInt();
            pid[i]=i+1;
       }
       int temp;
       for(int i=0;i<n;i++)
       {
        for(int j=0;j<n-i-1;j++)
        {
            if(at[j]>at[j+1])
            {
                 temp=at[j];
                 at[j]=at[j+1];
                 at[j+1]=temp;

                 temp=bt[j];
                 bt[j]=bt[j+1];
                 bt[j+1]=temp;

                 temp=pid[j];
                 pid[j]=pid[j+1];
                 pid[j+1]=temp;

                 temp=priority[j];
                 priority[j]=priority[j+1];
                 priority[j+1]=temp;
            }
            if(at[j]==at[j+1])
            {
                if(priority[j]>priority[j+1])
                {
                    temp=at[j];
                    at[j]=at[j+1];
                    at[j+1]=temp;
   
                    temp=bt[j];
                    bt[j]=bt[j+1];
                    bt[j+1]=temp;
   
                    temp=pid[j];
                    pid[j]=pid[j+1];
                    pid[j+1]=temp;
   
                    temp=priority[j];
                    priority[j]=priority[j+1];
                    priority[j+1]=temp;
                }
            }
        }
       }
       float avgwt=0,avgtat=0;

       ct[0]=bt[0]+at[0];
       tat[0]=ct[0]-at[0];
       wt[0]=tat[0]-bt[0];
       for(int i=1;i<n;i++)
       {
           ct[i]=ct[i-1]+bt[i];
           tat[i]=ct[i]-at[i];
           wt[i]=tat[i]-bt[i];
       }
       System.out.println("ProcessId    arival   brust    priority     complete     total-turn aorund     waiting ");
       for(int i=0;i<n;i++)
       {
        System.out.println(pid[i]+"\t\t"+at[i]+"\t\t"+bt[i]+"\t\t"+priority[i]+"\t\t"+ct[i]+"\t\t"+tat[i]+"\t\t"+wt[i]);
        avgwt+=wt[i];
        avgtat+=tat[i];
       }
       System.out.println("The average waiting time is : "+(float)avgwt/(float)n);
       System.out.println("The average turn around time is "+(float)avgtat/(float)n);
    }
}
