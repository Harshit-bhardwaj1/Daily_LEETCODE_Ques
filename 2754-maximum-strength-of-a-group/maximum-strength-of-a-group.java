class Solution {
    public long maxStrength(int[] nums) {
        int negativeCount = 0;
        int maxNegativeNum = -10;
        long maximumStrength = 1;
        int zeroCount = 0;
        for(int num: nums){
            if(num != 0){
                if(num < 0){
                    negativeCount++;
                    maxNegativeNum = Math.max(num, maxNegativeNum);
                }
                maximumStrength *= num;
            }else{
                zeroCount++;
            }
            
        }
        if(negativeCount % 2 == 1){
            maximumStrength /= maxNegativeNum;
        }
        if(negativeCount == 1){
            if(zeroCount > 0 && zeroCount + negativeCount == nums.length){
                maximumStrength = 0;
            }
            if(nums.length == 1){
                maximumStrength *= maxNegativeNum;
            }
        }
        if(zeroCount == nums.length){
            maximumStrength = 0;
        }
        return maximumStrength;
    }
}