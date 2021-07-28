class Solution {
     int[][] dp = new int[101][10001];
    public int solve(int k, int n){
        
        if(n==0 || n==1){return n;}
        if(k==1){return n;}
       if(dp[k][n]!=-1) return dp[k][n];
        
        int mn= Integer.MAX_VALUE;
        
        int ans=mn,l=1,h=n;
        while(l<=h)
        {
            int mid=(l+h)/2;
            int left=solve(k-1,mid-1);   
            int right=solve(k,n-mid) ;   
            int temp=1+Math.max(left,right);          
            if(left<right){                 
              l=mid+1;                       
            }
            else                             
            {    
                h=mid-1;
            }
            ans=Math.min(ans,temp);              
        }
        
          return dp[k][n]=ans;  
        
    }
        
       
    public  int superEggDrop(int k, int n) {
       
        for(int i=0;i<101;i++){
            for(int j=0;j<10001;j++){
                dp[i][j]=-1;
            }
        }
        return solve( k,  n);
    }
        
        
}