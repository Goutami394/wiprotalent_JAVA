//Traversal matrix-  Spiral 
// 1 2 3
// 4 5 6
// 7 8 9   result is: 1 2 3 6 9 8 7 4 5

public class TraversalM {
    public static void printspiral(int[][] mat) {
        if(mat.length==0) return;
        int top=0;
        int bottom=mat.length-1;
        int left=0;
        int right=mat[0].length-1;

        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                System.out.println(mat[top][i]+" ");
            }
            top++;
            for(int i=top;i<=bottom;)
        }
    }
    
}
