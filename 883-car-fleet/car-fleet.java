class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        return CarFleet(target,position,speed);
    }
    public int CarFleet(int target, int[] position, int[] speed){
        int n = position.length;

        int [][] cars = new int[n][2];
        for(int i=0; i<n; i++){
            cars[i][0]=position[i];
            cars[i][1]=speed[i];
        }
        Arrays.sort(cars, (a,b) -> b[0]-a[0]);
        int fleets = 0;
        double timePrev = 0;
        for(int i=0; i<n; i++){
            double timeCurr = (double)(target - cars[i][0]) / cars[i][1];

            if (timeCurr > timePrev) {
                fleets++;
                timePrev = timeCurr;
            }
        }
        return fleets;
    }
}