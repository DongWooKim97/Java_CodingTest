class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        
        for(int i=0; i<signs.length; i++) {
            int tmp = absolutes[i];
            if(signs[i] == false) {
                tmp = tmp * -1;
            }
            sum += tmp;
        }
        
        return sum;
    }
}