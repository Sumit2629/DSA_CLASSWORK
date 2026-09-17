class Solution {
    public int c=0;
    public int totalNQueens(int n) {
        char[][] arr=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]='.';
            }
        }
        helper(arr,0);
        return c;
    }
    public void helper(char[][] arr,int r){
        if(r==arr.length){
            c++;
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(isSafe(arr,r,i)){
                arr[r][i]='Q';
                helper(arr,r+1);
                arr[r][i]='.';
            }
        }
    }
    public boolean isSafe(char[][] arr,int r,int c){
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[r][i]=='Q') return false;
        }
        for(int i=0;i<n;i++){
            if(arr[i][c]=='Q') return false;
        }
        int i=r;
        int j=c;
        while(i>=0 && j<n){
            if(arr[i][j]=='Q') return false;
            i--;j++;
        }
        i=r;
        j=c;
        while(i>=0 && j>=0){
            if(arr[i][j]=='Q') return false;
            i--;j--;
        }
        i=r;
        j=c;
        while(i<n&&j>=0){
            if(arr[i][j]=='Q') return false;
            i++;j--;
        }    
        i=r;
        j=c;
        while(i<n&&j<n){
            if(arr[i][j]=='Q') return false;
            i++;j++;
        }
        return true;  
    }
}