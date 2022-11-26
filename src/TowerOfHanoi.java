
public class TowerOfHanoi {
    public int[][] column;
    private int size_col_1 = 0, size_col_2 = 0, size_col_3 = 0;
    private int general_capacity;

    public TowerOfHanoi(int size) {
        column = new int[3][size];
        general_capacity = size;
        initialFirstColumn(size);
    }

    private void initialFirstColumn(int size) {
        for (int i = 0; i < size; i++) {
            column[0][i] = size - i;
            size_col_1++;
        }
    }

    public void moveDish(int[] from, int[] to) {
    }

    public void printGame() {
        for (int i = 0; i < 3; i++) {
            System.out.print("Col " + i + ": ");
            for (int j = 0; j < column[i].length; j++) {
                System.out.print(column[i][j] + " ");
            }
            System.out.println();
        }
    }


}
