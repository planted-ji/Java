package variable.ex;

public class OperationEx1 {
    public static void main(String[] args) {
        // 변수 초기화
        int num1 = 10;
        int num2 = 20;
        int num3 = 30;

        // 변수 합 계산
        int sum = num1 + num2 + num3;
        int average = sum / 3; //java에서 int끼리의 나눗셈은 자동으로 소수점 이하를 버림
        
        // 결과
        System.out.println(sum);
        System.out.println(average);
    }
}
