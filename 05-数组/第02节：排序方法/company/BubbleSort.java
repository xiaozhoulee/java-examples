package company;

public class BubbleSort {
    public static void main(String[] args){
        int [] a = {3,4,7,1,8};
        for(int i=a.length-1;i>0;i--){
            // {int i=0;i<a.length-1i++}这样写，如果数组的长度很大会影响运行速度
            //j<i可以让排序次数变少，方便增加效率
            for (int j =0;j<i;j++){
                if (a[j] >a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        for(int i =0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
