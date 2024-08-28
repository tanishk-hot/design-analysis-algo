public class Knapsack{
// Add edge case handlig, adding fracional.

    public static void main(String[] args) {
        // Test case 1: Standard case
        int[] value1 = new int[] {60, 100, 120};
        int[] weight1 = new int[] {10, 20, 30};
        Item[] items1 = new Item[value1.length];
        for (int i = 0; i < value1.length; i++) {
            items1[i] = new Item(i, weight1[i], value1[i]);
        }
        int capacity1 = 50;
        System.out.println("Test case 1 result: " + solution(capacity1, items1));
        // Expected output: 240.0
        // Explanation: Take all items (10 + 20 + 30 = 60) and fraction of the third item.

        System.out.println("\n\nTest case 2:\n\n");

        // Test case 2: Capacity is smaller than any item's weight
        int[] value2 = new int[] {100, 200, 300};
        int[] weight2 = new int[] {50, 60, 70};
        Item[] items2 = new Item[value2.length];
        for (int i = 0; i < value2.length; i++) {
            items2[i] = new Item(i, weight2[i], value2[i]);
        }
        int capacity2 = 40;
        System.out.println("Test case 2 result: " + solution(capacity2, items2));
        // Expected output: 0.0
        // Explanation: Capacity is less than the weight of any item.

        System.out.println("\n\nTest case 3:\n\n");

        // Test case 3:
        int[] value3 = new int[] {10, 20, 30};
        int[] weight3 = new int[] {1, 2, 3};
        Item[] items3 = new Item[value3.length];
        for (int i = 0; i < value3.length; i++) {
            items3[i] = new Item(i, weight3[i], value3[i]);
        }
        int capacity3 = 0;
        System.out.println("Test case 3 result: " + solution(capacity3, items3));
        // Expected output: 170.0


        System.out.println("\n\nTest case 4:\n\n");

        // Test case 4: All items fit exactly into the capacity
        int[] value4 = new int[] {60, 100, 120};
        int[] weight4 = new int[] {10, 20, 30};
        Item[] items4 = new Item[value4.length];
        for (int i = 0; i < value4.length; i++) {
            items4[i] = new Item(i, weight4[i], value4[i]);
        }
        int capacity4 = 60;
        System.out.println("Test case 4 result: " + solution(capacity4, items4));
        // Expected output: 180.0
        // Explanation: Take all items with total weight 10 + 20 + 30 = 60 and total profit 60 + 100 + 120 = 280.

        System.out.println("\n\nTest case 5:\n\n");

        // Test case 5: Items with identical weights but different values
        int[] value5 = new int[] {60, 100, 120};
        int[] weight5 = new int[] {10, 10, 10};
        Item[] items5 = new Item[value5.length];
        for (int i = 0; i < value5.length; i++) {
            items5[i] = new Item(i, weight5[i], value5[i]);
        }
        int capacity5 = 15;
        System.out.println("Test case 5 result: " + solution(capacity5, items5));
        // Expected output: 170.0
        // Explanation: Take all items (full capacity 15) with total profit of 60 + 100 + 120 = 170.
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