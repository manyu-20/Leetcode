class Solution {
	public String reverseWords(String s) {
	   String arr[]= s.split(" ");
	   int n= arr.length;
	   String ans="";
	   for(int i=0; i<n; i++)
	   {
		   String curr= arr[i];
		   int j=curr.length()-1;
		   while(j>=0)
		   {
			   ans=ans+curr.charAt(j);
			   j--;
		   }
		   if(i!=n-1)
			  ans=ans+" ";   
	   }
	return ans;
	}
}