package ai0409;


//기본자료형(1. 숫자형, 2. 숫자가 아닌형)
public class DataTypeTest {
    public static void main(String[] args) {
        //1. 숫자형: 정수형
        byte bt = 127; //-128 ~127
        short st = 300;
        st = bt;
        int it = st;
        System.out.println("it변수에 저장된 값:" + it);
        long lg = 70000000;

        //1. 숫자형 : 실수형
        float f1 = 1000;
        f1 = lg;
        f1 = 1000.0f;
        f1 = 1000.0F;
        f1 = (float) 1000.0;

        double d1 = 2000;
        d1 = f1;
        d1 = bt;
        d1 = 207.999;


        //2. 숫자가 아닌 형 : 문자형.
        char c = 'A';
        System.out.println(c);
        System.out.println((int)c);
        System.out.println((char)(c+1));//unicode 값을 연산할 수 있다.

        //2. 숫자가 아닌 형 : 논리형
        boolean b= true;
        System.out.println(b);
        System.out.println(!b);

        System.out.println(bt == st);
    }
}
