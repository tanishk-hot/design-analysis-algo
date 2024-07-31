public class Knapsack{
// Add edge case handlig, adding fracional.

    public static void main(String[] args) {
        //GFG testcases
        //Passed
        int[] value = new int[] {60,100};
        int[] weight = new int[] {10,20};
        Item[] arr1 = new Item[value.length];
        ///function to put values and weight in the array of Items
        for(int i = 0; i < value.length; i++){
            arr1[i] = new Item(i , weight[i] , value[i]);
        }

        int[] value2 = new int[] {60,100};
        int[] weight2 = new int[] {10,20};
        Item[] arr2 = new Item[value.length];

        ///function to put values and weight in the array of Items
        for(int i = 0; i < value2.length; i++){
            arr2[i] = new Item(i , weight2[i] , value2[i]);
        }


        System.out.println(solution(50, arr1));
    }

    static int solution(int capacity, Item[] arr){
        Item.quickSort(arr , 0 , arr.length -1);
        int profit = 0;
        int weight = 0;
        int index =  0;
        int maxWeight = 0;
        int maxProfit = 0;
        for (int i = 0; i < arr.length; i++) {
            maxWeight += arr[i].weight;
            maxProfit += arr[i].profit;
        }
        if(maxWeight < capacity){
            return maxProfit;
        }
        int remainingCapacity = capacity;
        while(weight < capacity){
            if(remainingCapacity < arr[index].weight && index < arr.length){
                profit += remainingCapacity*(arr[index].profitToWeight);
                return profit;
            }
            profit += arr[index].profit;
            weight += arr[index].weight;
            remainingCapacity -= (int) arr[index].weight;
            index++;
        }
        return profit;
    }
}

//-------------IGNORE EVERYTHING BEYOND THIS-----------------

class Item{
    float objectNumber;
    float weight;
    float profit;
    float profitToWeight;

    Item(int objectNumber, float weight, float profit){
        this.objectNumber = objectNumber;
        this.weight = weight;
        this.profit = profit;
        this.profitToWeight = (profit/weight);
    }



    static void swap(Item[] arr, int i, int j){
        Item temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(Item[] arr, int low, int high) {
        float pivot = arr[high].profitToWeight;
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j].profitToWeight >= pivot) {
                i++;
                swap(arr, i, j);
            }
        }


        swap(arr, i + 1, high);

        return i + 1;
    }

    static void quickSort(Item[] arr, int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);


            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

}