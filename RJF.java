import java.util.Scanner;
public class RJF {
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
        int []f=new int[n];

        int st=0,tot=0;
        for(int i=0;i<n;i++)
        {
            System.out.printf("Enter the  %d Arival time : \n",(i+1));
            at[i]=sc.nextInt();
            System.out.printf("Enter the %d brust time  :  \n",(i+1));
            bt[i]=sc.nextInt();
            pid[i]=i+1;
            f[i]=0;

        }
        while(true)
        {
            System.out.println("Hello ");
            int c=n,min=999;
            if(tot==n)
            {
                break;
            }
            for(int i=0;i<n;i++)
            {
                if((at[i]<=st) && (f[i]==0) && (bt[i]<min))
                {
                    min=bt[i];
                    c=i;
                }
            }
            if(c==n)
            {
                st++;
            }
            else
            {
                ct[c]=st+bt[c];
                 st+=bt[c];
                 tat[c]=ct[c]-at[c];
                 wt[c]=tat[c]-bt[c];
                 tot++;
                 f[c]=1;
            }
        }
        float avgwt=0,avgtat=0;
        System.out.println("ProcessId      arival    brust     complete     turn_around_time    waiting ");
        for(int i=0;i<n;i++)
        {
            System.out.println(pid[i]+"\t\t"+at[i]+"\t"+bt[i]+"\t\t"+ct[i]+"\t\t"+tat[i]+"\t\t"+wt[i]);
            avgwt+=wt[i];
            avgtat+=tat[i];
        }
        
        System.out.println("The average turn around tiem is : "+(float)avgtat/(float)n);
        System.out.println("The average waiting time is : "+(float)avgwt/(float)n);
    }
}

