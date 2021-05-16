package packageJava;

import java.util.Arrays;

public class SortingClass {
    public static void main (String[] args){
        int array[] = new int[]{15,2,10,0,2,1,6};
        mergeSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    /**
     * merge Sort algorithm
     * @param t
     * @param l
     * @param r
     */
    public static void mergeSort(int[] t,int l ,int r){
        if(l<r){
            int mid = l+(r-l)/2;
            /**
             * divide & conquer
             */
            mergeSort(t,l,mid);
            mergeSort(t,mid+1,r);

            merge(t,l,mid,r);
        }
    }

    /**
     * merge algorithm
     * @param t
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(int[] t, int l, int mid, int r) {
        int[] a = new int[mid-l+1];
        int[] b = new int[r-mid];
        for(int i = 0;i< a.length;i++){
            a[i] = t[l+i];
        }
        for(int i = 0;i<b.length;i++){
            b[i] = t[mid+i+1];
        }

        /**
         * merging the two arrays
         */
        int i = 0;
        int j = 0;
        int k = l;
        while(i<a.length && j < b.length){
            if(a[i]<b[j]){
                t[k] = a[i];
                i++;
            }else{
                t[k] = b[j];
                j++;
            }
            k++;
        }

        while(i<a.length){
            t[k] = a[i];i++;k++;
        }

        while(j<b.length){
            t[k] = b[j];j++;k++;
        }


    }

}
