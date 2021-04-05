import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        String temp=s;
        int cnt=0;
        int totalEraseCnt=0;
        
        while(true){           
            Info info = eraseZero(temp);
            temp = info.str;
            totalEraseCnt += info.cnt;
            temp = makeBinary(temp);  
            cnt++;
            
            if(temp.equals("1")){
                break;
            }          
        }
        
        answer = new int[2];
        answer[0]=cnt;
        answer[1]=totalEraseCnt;
        
        return answer;
    }
    
    public static Info eraseZero(String s){
        int eraseCnt=0;
        char[] charArray = s.toCharArray();
        String result="";
        for(int i=0; i<charArray.length; i++){
            if(charArray[i]=='0'){
                eraseCnt++;
            }else{
                result+=Character.toString(charArray[i]);
            }
        }
        
        Info info = new Info(eraseCnt, result);
        return info;
    }
    
    public static String makeBinary(String s){
        int cur = s.length();
        List<String> list = new ArrayList<>();
        while(cur>0){
            list.add(Integer.toString(cur%2));
            cur/=2;
        }
        
        Collections.reverse(list);
        
        String temp="";
        for(String i : list){
            temp+=i;
        }
        
        return temp;
    }
    
    static class Info{
        int cnt;
        String str;
        
        Info(int c, String s){
            cnt=c;
            str=s;
        }
    }
}