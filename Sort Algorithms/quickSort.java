package packageJava;

import java.util.Arrays;

public class MyClass {
    public static void main (String[] args){
        int array[] = new int[]{15,2,10,0,2,1,6};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    /**
     * quick sort algorithm
     * @param t
     * @param l
     * @param r
     */
    public static void quickSort(int[] t,int l ,int r){
        if(l<r){
            int pivot = t[r];
            int i = l-1;
            int j = r;
            do{
                do{
                    i++;
                }while(t[i]<pivot);
                do{
                    j--;
                }while(j>=l &&  t[j]>pivot);
                if(i<j){
                    int tmp = t[i];
                    t[i] = t[j];
                    t[j] = tmp;
                }
            }while(i<j);
            int tmp = t[i];
            t[i] = t[r];
            t[r] = tmp;
            quickSort(t,l,i-1);
            quickSort(t,i+1,r);

        }
    }
}
