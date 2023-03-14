class Solution {
    public int solution(int[] numbers) {
        boolean[] arr = new boolean[10];
        
        int target = 0;
        
        for(int i=0; i<numbers.length;i++) {
            arr[numbers[i]] = true;
        }
        
        for(int i=0; i<10;i++) {
            if(!arr[i]) target += i;
        }
        
        return target;
        
        
    }
}