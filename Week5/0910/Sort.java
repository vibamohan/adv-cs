public class Sort {
    private static int binarySearchCalls;

    public Sort() {
    }

    public static void scramble(MyArrayList<Integer> numbers) {
        for (int i = numbers.size() - 1; i > 0; i--) {
            int randomIndex = (int) (Math.random() * (i + 1));
            swap(numbers, i, randomIndex);
        }
    }

    public static void bubbleSort(MyArrayList<Integer> numbers) {
        for (int end = numbers.size() - 1; end > 0; end--) {
            boolean swapped = false;
            for (int i = 0; i < end; i++) {
                if (numbers.get(i) > numbers.get(i + 1)) {
                    swap(numbers, i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                return;
            }
        }
    }

    public static void mergeSort(MyArrayList<Integer> numbers) {
        if (numbers.size() < 2) {
            return;
        }
        mergeSort(numbers, 0, numbers.size() - 1);
    }

    public static int binarySearch(MyArrayList<Integer> numbers, int target) {
        binarySearchCalls = 0;
        return binarySearch(numbers, target, 0, numbers.size() - 1);
    }

    public static int getBinarySearchCalls() {
        return binarySearchCalls;
    }

    private static void mergeSort(
        MyArrayList<Integer> numbers, int low, int high
    ) {
        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        mergeSort(numbers, low, middle);
        mergeSort(numbers, middle + 1, high);
        merge(numbers, low, middle, high);
    }

    private static void merge(
        MyArrayList<Integer> numbers, int low, int middle, int high
    ) {
        MyArrayList<Integer> merged = new MyArrayList<>();
        int left = low;
        int right = middle + 1;

        while (left <= middle && right <= high) {
            if (numbers.get(left) <= numbers.get(right)) {
                merged.add(numbers.get(left++));
            } else {
                merged.add(numbers.get(right++));
            }
        }
        while (left <= middle) {
            merged.add(numbers.get(left++));
        }
        while (right <= high) {
            merged.add(numbers.get(right++));
        }
        for (int i = 0; i < merged.size(); i++) {
            numbers.set(low + i, merged.get(i));
        }
    }

    private static int binarySearch(
        MyArrayList<Integer> numbers, int target, int low, int high
    ) {
        if (low > high) {
            return -1;
        }

        binarySearchCalls++;
        int middle = low + (high - low) / 2;
        int value = numbers.get(middle);
        if (value == target) {
            return middle;
        }
        if (target < value) {
            return binarySearch(numbers, target, low, middle - 1);
        }
        return binarySearch(numbers, target, middle + 1, high);
    }

    private static void swap(MyArrayList<Integer> numbers, int first, int second) {
        int value = numbers.get(first);
        numbers.set(first, numbers.get(second));
        numbers.set(second, value);
    }
}
