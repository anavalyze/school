public class Sortieren {
    
    public static void bubblesort(int[] arr){
        boolean sorting = true;
        int i = 0;
        int j;
        int c = 0;
        while(sorting){
            if((i+1) == arr.length){
                if(c == arr.length){
                    sorting = false;
                }else{
                    i = 0;
                    c++;
                } 
            }else{
                if(arr[i] > arr[i+1]){
                    j = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = j;
                    i++;
                }else{i++;}
            }
        }
    }

    public static void insertionsort(int[] arr){
        boolean sorting = true;
        int j = 0;
        int z;
        while(sorting){
            int s = 0;
            for (int i = s; i < arr.length; i++) {
                if(arr[i] < arr[j]){
                    j = i;
                }   
                z = arr[j];
                arr[j] = arr[s];
                arr[s] = z;
                s++;
                if(s == arr.length){
                    sorting = false;
                }
            }
            

        }
    }

}
