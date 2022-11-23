import java.util.Arrays;
public class BESTFIT {
    static void allocate(int []blocksize,int m,int []processsize,int n)
    {
             int []allocation=new int[n];
             Arrays.fill(allocation,-1);

             for(int i=0;i<n;i++)
             {
                int bitId=-1;
                for(int j=0;j<m;j++)
                {
                     if(blocksize[j]>=processsize[i])
                     {
                        if(bitId==-1)
                        {
                            bitId=j;
                        }
                        else if(blocksize[bitId]>blocksize[j])      
                        {
                            bitId=j;
                        }                  
                    }
                }
            if(bitId!=-1)
            {
                allocation[i]=bitId;

                blocksize[bitId]-=processsize[i];
            }
            }
            System.out.println("Process no    Process size    alocation ");
            for(int i=0;i<n;i++)
            {
                System.out.print((i+1)+"\t\t"+processsize[i]+"\t\t");
                if(allocation[i]!=-1)
                {
                    System.out.print(allocation[i]+1);
                }
                else
                {
                    System.out.print("Not alocate");
                }
                System.out.println();
            }
        }
             
    
    public static void main(String[] args)
    {
       int []blocksize={100, 500, 200, 300, 600};
       int []processsize={212, 417, 112, 426};
       int m=blocksize.length;
       int n=processsize.length;

       allocate(blocksize,m,processsize,n);
    }
}

