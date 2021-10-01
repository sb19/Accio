// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int row=sc.nextInt();
        int col=sc.nextInt();
        int[][] arr = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int[][] pre =new int[row][col];
        int sum=0;
	//prefix sum of first row
        for(int j=0;j<col;j++){
            sum+=arr[0][j];
            pre[0][j]=sum;
        }
        
        sum=0;
	//prefix sum of first column
        for(int i=0;i<row;i++){
            sum+=arr[i][0];
            pre[i][0]=sum;
        }
        //prefix sum of other positions
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                pre[i][j]=pre[i-1][j]+pre[i][j-1]+arr[i][j]-pre[i-1][j-1];
            }
        }
        
	//(i,j) to (x,y)
        int i = sc.nextInt();
        int j= sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int ans;
        if(i==0 && j==0){
            ans = pre[x][y];
            System.out.println(ans);
        }
        else if (i==0){
             ans = pre[x][y]-pre[x][j-1];
            System.out.println(ans);
        }
        else if(j==0){
               ans = pre[x][y]-pre[i-1][y];
            System.out.println(ans);
        }
        else{
        ans = pre[x][y]-pre[x][j-1]-pre[i-1][y]+pre[i-1][j-1];
        System.out.println(ans);}   
    }
}