import java.util.Arrays;
public class FIRSTFIT{
    static void allocate(int []blocksize,int m,int []processsize,int n)
    {
                int []allocation=new int[n];
                Arrays.fill(allocation,-1);
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<m;j++)
                    {
                        if(blocksize[j]>=processsize[i])
                        {
                            allocation[i]=j;
                            blocksize[j]-=processsize[i];
                            break;
                        }
                    }
                }
                System.out.println("Process no     Process size     Allocated ");
                for(int i=0;i<n;i++)
                {
                    System.out.print((i+1)+"\t\t"+processsize[i]+"\t\t");
                    if(allocation[i]!=-1)
                    {
                        System.out.print(allocation[i]+1);
                    }
                    else
                    {
                        System.out.print("not allocated");
                    }
                    System.out.println();
                }
    }
    public static void main(String []args)
    {
        int []blocksize={100, 500, 200, 300, 600};
		int []processsize = {212, 417, 112, 426};
        int m=blocksize.length;
        int n=processsize.length;
        allocate(blocksize,m,processsize,n);
    }
}
