import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        //**Int[]는 내림차순(Collections.reverseOrder())으로 정렬할 수 없으므로 Integer[]로 바꾸고 정렬
        Integer[] arr = new Integer[n];
        
        for(int i=0; i<n; i++)
            arr[i]=citations[i];
        
        Arrays.sort(arr, Comparator.reverseOrder());//객체여야 reverseOrder
        
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]<i+1)
                return i;
        }
        
        answer=arr.length;
        
        return answer;
    }
}