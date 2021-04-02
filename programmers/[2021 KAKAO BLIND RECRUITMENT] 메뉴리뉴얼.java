import java.util.*;

class Solution {
    private static List<String> menuComb = new ArrayList<>();//메뉴조합들
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        //1.한 메뉴당 course길이 만큼 메뉴조합 만들기
        for(int i=0; i<orders.length; i++){
            char[] menuArray = orders[i].toCharArray();
            Arrays.sort(menuArray);
            
            for(int j=0; j<menuArray.length-1; j++){
                for(int k=0; k<course.length; k++){
                    dfs(menuArray,1,j,course[k], String.valueOf(menuArray[j]));
                }
            }  
        }
        
        //2.메뉴 조합별로 주문 횟수 구하고 key값은 따로 담아둔다.
        //key를 담아둔 배열은 주문횟수 내림차순으로 정렬
        HashMap<String, Integer> map = new HashMap<>();
        List<String> menuComponents = new ArrayList<>();
        for(String s : menuComb){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        for(String key : map.keySet()){
            menuComponents.add(key);
        }
        
        Collections.sort(menuComponents, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return map.get(o2).compareTo(map.get(o1));
			}
        });
        

        //3. course길이와 같은 menuComponents중 주문횟수가 2이상인 것의 max 갱신
        //max값보다 크거나 같은 menuComponents들을 담는다.
        List<String> menuList = new ArrayList<>();
        for(int i=0; i<course.length; i++){
            int maxLen=2;
            for(String s : menuComponents){
                if(s.length()==course[i] && map.get(s)>=maxLen){
                    menuList.add(s);
                    maxLen=map.get(s);
                }
            }
        }
        
        //4.알파벳 순으로 정렬
        Collections.sort(menuList);
        answer = new String[menuList.size()];
        int idx=0;
        for(String s : menuList){
            answer[idx++]=s;
        }
        
        return answer;
    }
    
    public static void dfs(char[] arr, int cnt, int idx, int menuCnt, String str){
        if(cnt==menuCnt){
            menuComb.add(str);
            //return;
        }
        
        for(int i=idx+1; i<arr.length; i++){
            dfs(arr, cnt+1, i, menuCnt, str+arr[i]);
        }
    }
}