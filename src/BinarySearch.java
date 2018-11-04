public class BinarySearch {

    int recursiveBinarySearch(int[] arr, int start, int length, int target) {
        if (length > 0) {
            int mid = start + (length / 2);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                return recursiveBinarySearch(arr, ++mid, arr.length - mid, target);
            } else {
                return recursiveBinarySearch(arr, start, mid - start, target);
            }
        }
        return -1;
    }

    int iterativeBinarySearch(int[] arr, int start, int length, int target) {

        while(length > 0) {
            int mid = start + (length / 2);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
                length = arr.length - start;
            } else {
                length = mid - start;
            }
        }
        return -1;

    }

    // Driver method to test above
    public static void main(String args[])
    {
        BinarySearch ob = new BinarySearch();
        int result;
        long startTime, endTime;
        int arr[] = {2,3,4,10,40,50,100};
        int length = arr.length;
        int target = 40;

        startTime = System.nanoTime();
        result = ob.recursiveBinarySearch(arr,0,length-1, target);
        endTime = System.nanoTime();
        System.out.println("recursiveBinarySearch took " + (endTime - startTime) + "ms and result is: " +
                ((result == -1) ? "Element not present" : "Element found at index " + result));

        startTime = System.nanoTime();
        result = ob.iterativeBinarySearch(arr,0,length-1, target);
        endTime = System.nanoTime();
        System.out.println("iterativeBinarySearch took " + (endTime - startTime) + "ms and result is: " +
                ((result == -1) ? "Element not present" : "Element found at index " + result));
    }
}
