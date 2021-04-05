class Solution {
    static int[] dx={0,1,-1};
    static int[] dy={1,0,-1};
    public int[] solution(int n) {
        int[] answer = {};
        int[][] arr = new int[n][n];
        
        int cnt=0;
        for(int i=n-1; i>=0; i--){
            for(int j=n-1; j>i; j--){
                arr[i][j]=-1;
                cnt++;
            }
        }
        
        int y=0, x=0, dir=0;
        int num=1;
        int total=n*n-cnt;

		while (num<=total) {
			if ((y >= 0 && x >= 0 && y < n && x < n) && arr[y][x] == 0) {
				arr[y][x] = num++;
			} else {
				y-=dy[dir];
				x-=dx[dir];
				dir = (dir + 1) % 3;
			}

			y += dy[dir];
			x += dx[dir];
		}
        
        answer=new int[total];
        int idx=0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]!=-1){
                    answer[idx++]=arr[i][j];
                }
            }
        }
        
        return answer;
    }
}