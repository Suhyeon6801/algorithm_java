import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Stack<Integer> st = new Stack<>();
        
        for(int i=progresses.length-1; i>=0; i--){
            int temp = (100-progresses[i])/speeds[i];
            temp += (100-progresses[i])%speeds[i]>0 ? 1 : 0;
            st.push(temp);
        }
        
        List<Integer> list = new ArrayList<>();
        
        while(!st.isEmpty()){
            int day=1;
            int top = st.pop();
            
            while(!st.isEmpty() && st.peek()<=top){
                day++;
                st.pop();
            }
            
            list.add(day);
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}