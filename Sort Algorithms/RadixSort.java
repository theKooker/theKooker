package packageJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyClass {
    public static void main (String[] args){
        int array[] = new int[]{15,2,10,15,2,1,613,9};
        radixSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     *
     * @param t
     */
    public static void radixSort(int[] t){
        int d = getMax(t);
        for(int i = 0;i<d;i++){
            kSort(t,i);
            System.out.println(Arrays.toString(t)+" stelle = "+i);
        }
    }

    /**
     *
     * @param t
     * @param i
     */
    private static void kSort(int[] t, int i) {
        ArrayList<Integer> list[] = new ArrayList[10];
        for(int index =  0;index < 10;index++){
            list[index] = new ArrayList<Integer>();
        }
        for(int element : t){
            int indexInList = (element/(int)Math.pow(10,i))%10;
            System.out.println("element is  "+element+" indexInList = "+indexInList);
            list[indexInList].add(element);
        }

        System.out.println(Arrays.stream(list).filter(teil->!teil.isEmpty()).count());
        int counter = 0;
        for(int index= 0;index<list.length;index++){
            System.out.println("index = "+index+" empty ? "+list[index].isEmpty());
            if(!list[index].isEmpty()){
                for(int j = 0;j<list[index].size();j++){
                    t[counter] = list[index].get(j);
                    counter++;
                }
            }

        }

}}