class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-3;i++){
            for(int j = i+1;j<nums.length-2;j++){
                int sum = target - (nums[i] + nums[j]);
                int front = j+1;
                int back = nums.length - 1;
                
                while(front < back){
                    int total = nums[front] + nums[back];
                    if(total == sum){
                        List<Integer> ll = new ArrayList<>();
                        ll.add(nums[i]);
                        ll.add(nums[j]);
                        ll.add(nums[front]);
                        ll.add(nums[back]);
                        list.add(new ArrayList<>(ll));
                        while(front < back && nums[front] == ll.get(2)){
                            front++;
                        }
                        while(back > front && nums[back] == ll.get(3)){
                            back--;
                        }
                    }
                    else if(total < sum){
                        front++;
                    }
                    else{
                        back--;
                    }
                }
                while(j+1 < nums.length && nums[j+1] == nums[j]){
                    j++;
                }
            }
            while(i+1 < nums.length && nums[i+1] == nums[i]){
                i++;
            }
        }
        
        return list;
    }
}