/* ROUNDROBIN Algorithm  */

import java.util.Arrays;
public class ROUNDROBIN{
    public static void main(String []args)
    {
        int []pid={1,2,3};
        int []bt={10, 5, 8 };
        int quantum=2;
        int n=bt.length;
        int []wt=new int[n];
        int []tat=new int[n];
        float avgwt=0,avgtat=0;
        int []rembt=Arrays.copyOf(bt,n);
        
        int t=0;
        while(true)
        {
            boolean b=true;
            for(int i=0;i<n;i++)
            {
                if(rembt[i]>0)
                {
                    b=false;
                    if(rembt[i]>quantum)
                    {
                        t+=quantum;
                        rembt[i]-=quantum;
                    }
                    else
                    {
                        t+=rembt[i];
                        wt[i]=t-bt[i];
                        rembt[i]=0;

                    }
                }
            }
            if(b==true)
            {
                break;
            }
        }
        for(int i=0;i<n;i++)
        {
            tat[i]=wt[i]+bt[i];
            avgwt+=wt[i];
            avgtat+=tat[i];
        }

        System.out.printf("%15s%15s%15s%15s","Process","Brust Time ","Turn around time ","waiting time");
        System.out.println();
        for(int i=0;i<n;i++)
        {
            System.out.printf("%15d%15d%15d%15d",pid[i],bt[i],tat[i],wt[i]);
            System.out.println();
        }
        System.out.println("The average turn around time "+avgtat/(float)n);
        System.out.println("The average waiting time "+avgwt/(float)n);

    }
}
