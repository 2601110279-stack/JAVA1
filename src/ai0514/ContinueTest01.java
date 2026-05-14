package ai0514;

public class ContinueTest01 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 100; i++){
            if(i % 2 == 1)
                continue;
            sum += i;
        }
        System.out.println("1부터 100까지의 합계(4의 배수 제외한 합계) : " + sum);
    }
}
