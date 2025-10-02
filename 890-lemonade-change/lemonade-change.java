class Solution {
    public boolean lemonadeChange(int[] bills) {
        return change(bills);
    }
    public boolean change(int[] arr){
        int count5=0;
        int count10=0;
        int count20=0;
        int amount=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==5){
                count5++;
            }
            else if(arr[i]==10){
                if(count5>0){
                    count5--;
                }
                else{
                    return false;
                }
                count10++;
            }
            else{
                if(count10>0 && count5>0){
                    count10--;
                    count5--;
                }
                else if(count5>=3){
                    count5-=3;
                }
                else{
                    return false;
                }
                count20++;
            }
        }
        return true;

    }
}