
public class MedianStreamNumbers {

    static class MaxHeap {
        int SIZE_INCREMENT = 10;
        int[] heap = new int[SIZE_INCREMENT];
        int size = 0;
        int maxsize = SIZE_INCREMENT;

        public MaxHeap() {
            heap[0] = Integer.MAX_VALUE;
        }
        public int size() {
            return size;
        }
        public int peek() {
            return heap[1];
        }

        public void insert(int v) {
            if (size == maxsize-1) {
                maxsize += SIZE_INCREMENT;
                int[] heap1 = new int[maxsize];
                for (int i = 0; i < size; i++)
                    heap1[i] = heap[i];
                heap = heap1;
                heap1 = null;
            }
            heap[++size] = v;
            int current = size;
            while(heap[current] > heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        public int extractMax() {
            int retMax = heap[1];
            heap[1] = heap[size--];
            if (size > 1)
                maxHeapify(1);
            return retMax;
        }

        private void maxHeapify(int pos) {
            if (isleaf(pos))
                return;

            if (heap[pos] < heap[left(pos)] ||
                heap[pos] < heap[right(pos)]) {
                if (heap[left(pos)] > heap[right(pos)]) {
                    swap(pos, left(pos));
                    maxHeapify(left(pos));
                }
                else {
                    swap(pos, right(pos));
                    maxHeapify(right(pos));
                }
            }
        }
        private int left(int pos) {
            return 2*pos;
        }
        private int right(int pos) {
            return 2*pos+1;
        }

        private boolean isleaf(int pos) {
            if (pos >= size/2 && pos <= size)
                return true;
            return false;
        }

        public int getLeftChild(int p) {
            return heap[2*p];
        }
        public int getRightChild(int p) {
            return heap[2*p+1];
        }

        private int parent(int s) {
            return s/2;
        }

        private void swap(int apos, int bpos) {
            int avalue = heap[apos];
            heap[apos] = heap[bpos];
            heap[bpos] = avalue;
        }

        public void print() {
            for (int i = 1; i < size/2; i++) {
                System.out.println("Parent: " + heap[i] + ", left: " + heap[2*i] + ", right: " + heap[2*i+1]);
            }
        }
    }

    static class MinHeap {
        int SIZE_INCREMENT = 10;
        int[] heap = new int[SIZE_INCREMENT];
        int size = 0;
        int maxsize = SIZE_INCREMENT;

        public MinHeap() {
            heap[0] = Integer.MIN_VALUE;
        }
        public int size() {
            return size;
        }
        public int peek() {
            return heap[1];
        }

        public void insert(int v) {
            heap[++size] = v;
            int current = size;
            while (heap[current] < heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }
        public int extractMin() {
            int retValue = heap[1];
            heap[1] = heap[size--];
            if (size > 1)
                minHeapify(1);
            return retValue;
        }

        private void minHeapify(int pos) {
            if (isleaf(pos))
                return;
            if (heap[pos] > heap[left(pos)] ||
                heap[pos] > heap[right(pos)]) {

                if (heap[left(pos)] < heap[right(pos)]) {
                    swap(pos, left(pos));
                    minHeapify(left(pos));
                }
                else {
                    swap(pos, right(pos));
                    minHeapify(right(pos));
                }
            }
        }
        private int parent(int p) {
            return p/2;
        }
        private int left(int p) {
            return 2*p;
        }
        private int right(int p) {
            return 2*p+1;
        }
        private boolean isleaf(int p) {
            if (p >= size/2 && p <= size)
                return true;
            return false;
        }

        private void swap(int apos, int bpos) {
            int avalue = heap[apos];
            heap[apos] = heap[bpos];
            heap[bpos] = avalue;
        }

        public void print() {
            for (int i = 1; i < size/2; i++) {
                System.out.println("Parent: " + heap[i] + ", left: " + heap[2*i] + ", right: " + heap[2*i+1]);
            }
        }
    }

    private static MaxHeap maxHeap = new MaxHeap();
    private static MinHeap minHeap = new MinHeap();

    public static void addStreamNumber(int rNum) {
        if (maxHeap.size() == minHeap.size()) {
            if ( (minHeap.size() > 0) &&
                 (rNum > minHeap.peek()) ) {
                maxHeap.insert(minHeap.extractMin());
                minHeap.insert(rNum);
            }
            else {
                maxHeap.insert(rNum);
            }
        }
        else {
            if (rNum < maxHeap.peek()) {
                minHeap.insert(maxHeap.extractMax());
                maxHeap.insert(rNum);
            }
            else {
                minHeap.insert(rNum);
            }
        }
    }

    public static double getMedian() {
        if (maxHeap.size() == 0)
            return 0;

        if (maxHeap.size() == minHeap.size()) {
            return ((double)maxHeap.peek() + (double)minHeap.peek())/2;
        }
        else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        addStreamNumber(5);
        addStreamNumber(3);
        addStreamNumber(17);
        addStreamNumber(10);
        addStreamNumber(84);
        addStreamNumber(19);
        addStreamNumber(6);
        addStreamNumber(22);
        addStreamNumber(9);
        System.out.println("The median val is " + getMedian());

        /*
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();
        System.out.println("The max val is " + maxHeap.extractMax());
        MinHeap minHeap = new MinHeap();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        minHeap.print();
        System.out.println("The max val is " + minHeap.extractMin());
        */
    }
}
