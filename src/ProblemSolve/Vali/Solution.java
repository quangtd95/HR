package ProblemSolve.Vali;

import java.util.Arrays;

/**
 * Có n đồ vật, vật thứ i có trọng lượng Ai và giá trị Bi.
 * Hãy chọn ra một số các đồ vật, mỗi vật một cái để xếp vào 1 vali có trọng lượng tối đa W
 * sao cho tổng giá trị của vali là lớn nhất.
 *
 * Hàm mục tiêu: f: tổng giá trị của vali.
 *
 * Nhận xét: giá trị của vali phụ thuộc vào 2 yếu tố: có bao nhiêu vật đang được xét và trọng lượng của các vật. Do đó bảng phương án sẽ là bảng 2 chiều: - L(i,j): tổng giá trị lớn nhất của vali khi xét từ vật 1 .. vật i và trọng lượng của vali chưa vượt quá j. Chú ý rằng khi xét đến L[i,j] thì các giá trị trên bảng phương án đều đã được tối ưu.
 *
 * Tính L(i,j): vật đang xét là ai với trọng lượng của vali không được quá j. Có 2 khả năng xảy ra:
 *
 * Nếu chọn Ai đưa vào vali, trọng lượng vali trước đó phải không quá j−Ai. Vì mỗi vật chỉ được chọn 1 lần nên giá trị lớn nhất của vali lúc đó là L(i−1,j−Ai)+Bi.
 * Nếu không chọn Ai, trọng lượng của vali là như cũ (như lúc trước khi chọn Ai): L(i−1,j).
 * Tóm lại ta có L[i,j]=max(L(i−1,j−Ai)+Bi,L(i−1,j)).
 */
public class Solution {
    public static void main(String[] args) {
        Vali[] valis = new Vali[]{
                new Vali(3, 1),
                new Vali(3, 5)
        };
        int maxWeight = 4;
        process(valis, maxWeight);
    }

    private static void process(Vali[] valis, int maxWeight) {
        int[][] bestValues = new int[valis.length][maxWeight + 1];
        for (int i = 0; i < valis.length; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                if (i == 0) {
                    if (valis[i].weight < j) {
                        bestValues[i][j] = valis[i].value;
                    } else {
                        bestValues[i][j] = 0;
                    }
                } else {
                    if (valis[i].weight < j) {
                        bestValues[i][j] = Math.max(bestValues[i - 1][j - valis[i].weight] + valis[i].value, bestValues[i - 1][j]);
                    } else {
                        bestValues[i][j] = bestValues[i - 1][j];
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(bestValues));
    }

    public static class Vali {
        int weight;
        int value;

        public Vali(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

}
