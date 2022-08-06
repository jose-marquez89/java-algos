class MaxHeap {
    private int[] heapArray;
    private int heapSize;

    public MaxHeap() {
        heapArray = new int[2];
        heapSize = 0;
    }

    private void resizeArray() {
        int newLength = heapArray.length * 2;
        int[] newArray = new int[newLength];
        if (newArray != null) {
            for(int i = 0; i < heapArray.length; i++) {
                newArray[i] = heapArray[i];
            }
            heapArray = newArray;
        }
    }

    // percolate up the heap
    void percolateUp(int nodeIndex) {
        while (nodeIndex > 0) {
            int parentIndex = (nodeIndex - 1) / 2;

            if (heapArray[nodeIndex] <= heapArray[parentIndex]) {
                return;
            }
            else {
                int temp = heapArray[nodeIndex];
                heapArray[nodeIndex] = heapArray[parentIndex];
                heapArray[parentIndex] = temp;
            }
        }
    }

    void percolateDown(int nodeIndex) {
        int childIndex = 2 * nodeIndex + 1;
        int value = heapArray[nodeIndex];

        while (childIndex < heapSize) {
            int maxValue = value;
            int maxIndex = -1;
            int i = 0;

            while (i < 2 && i + childIndex < heapSize) {
                if (heapArray[i + childIndex] > maxValue) {
                    maxValue = heapArray[i + childIndex];
                    maxIndex = i + childIndex;
                }
                i++;
            }

            if (maxValue == value) {
                return;
            }
            else {
                int temp = heapArray[nodeIndex];
                heapArray[nodeIndex] = heapArray[maxIndex];
                heapArray[maxIndex] = temp;

                nodeIndex = maxIndex;
                childIndex = 2 * nodeIndex + 1;
            }
        }
    }

    void insert(int value) {
        if (heapSize == heapArray.length) {
            resizeArray();
        }

        heapArray[heapSize] = value;
        heapSize++;

        percolateUp(heapSize - 1);
    }

    int remove() {
        int maxValue = heapArray[0];

        int replaceValue = heapArray[heapSize - 1];
        heapSize--;
        if (heapSize > 0) {
            heapArray[0] = replaceValue;

            percolateDown(0);
        }
    
        return maxValue;
    }
}