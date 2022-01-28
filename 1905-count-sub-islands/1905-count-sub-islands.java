class Solution 
{
    int flag = 0;
    public int countSubIslands(int[][] grid1, int[][] grid2) 
    {
        int count = 0;
        for( int i = 0 ; i < grid2.length ; i++ )
        {
            for( int j = 0 ; j < grid2[i].length ; j++ )
            {
                if( grid2[i][j] == 1 )
                {
                    traverse( grid1,grid2,i,j );
                    if(flag == 0) count++;
                    flag = 0;
                }
            }
        }
        return count;
    }
    public void traverse(int[][] grid1,int[][] grid2, int i , int j )
    {
        if( i >= 0 && i < grid2.length && j >= 0 && j < grid2[i].length && grid2[i][j] == 1 )
        {
            if( grid1[i][j] == 0 )
            {
                flag = 1;
            }
            grid2[i][j] = 0;
            traverse( grid1, grid2, i+1, j );
            traverse( grid1, grid2, i-1, j );
            traverse( grid1, grid2, i, j+1 );
            traverse( grid1, grid2, i, j-1 );
        }
    }
}