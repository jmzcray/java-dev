public class BinarySearch {

    int binarySearch(int[] arr, int start, int length, int target) {
        if (length > 0) {
            int index = start + (length / 2);
            if (arr[index] == target) {
                return index;
            } else if (arr[index] < target) {
                return binarySearch(arr, ++index, arr.length - index, target);
            } else {
                return binarySearch(arr, start, index - start, target);
            }
        }
        return -1;
    }

    // Driver method to test above
    public static void main(String args[])
    {
        BinarySearch ob = new BinarySearch();
        int arr[] = {2,3,4,10,40};
        int length = arr.length;
        int target = 1;
        int result = ob.binarySearch(arr,0,length-1, target);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}
