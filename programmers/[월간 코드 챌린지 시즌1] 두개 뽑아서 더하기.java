import java.util.*;

class Solution {
    Set<Integer> result = new HashSet<Integer>();
    
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        makeSum(numbers);
        answer = setToArray();
        
        return answer;
    }
    
    public void makeSum(int[] arr){
        int len = arr.length;
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                result.add(arr[i]+arr[j]);
            }
        }
    }
    
    public int[] setToArray(){
        int[] arr = new int[result.size()];
        int i=0;
        for(int val : result){
            arr[i++]=val;
        }
        
        Arrays.sort(arr);
        
        return arr;
    }
}