public class App {
    public static void main(String[] args) {
        //int[] A = {9, 2, 6, 1, 4, 3, 5};
        //int[] A = {2, 3, 6, 1, 4, 4, 5};
        int[] A = {7, 2, 100, 1, 3, 9, 5};
        sort(A, 1, A.length);
        for (int item: A) {
            System.out.print(item + " ");
        }
    }

    public static void sort(int[] A, int p, int r) {
        int q = (p + r) / 2;
        if (p < r) {
            sort(A, p, q);
            sort(A, q + 1, r);
        }
        merge(A, p, q, r);
    }

    public static void merge(int[] A, int p, int q, int r) {
        int[] temp = new int[r - p + 1];
        int cur = p - 1;
        int mid = q;
        for (int i = 0; i < temp.length; i++) {
            if (cur < mid && q < r) {
                if (A[cur] < A[q])
                    temp[i] = A[cur++];
                else
                    temp[i] = A[q++];
            }
            else if (cur < mid)
                temp[i] = A[cur++];
            else if (q < r)
                temp[i] = A[q++];
        }

        int t = p - 1;
        for (int item : temp) {
            A[t++] = item;
        }
        //System.arraycopy(temp, 0, A, p-1, temp.length);
    }

}

// System.arrayCopy(from, fromIndex, to, toIndex, count);
// from - массив, который копируем
// to - массив в которой копируем
// fromIndex - индекс в массиве from начиная с которого берем элементы для копирования
// toIndex - индекс в массиве to начиная с которого вставляем элементы
// count - количество элементов которые берем из массива from и вставляем в массив to

