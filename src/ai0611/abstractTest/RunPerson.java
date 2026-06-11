package ai0611.abstractTest;

public class RunPerson {
    public static void main(String[] args) {

        // 추상(abstract) 클래스는 new 연산자로 객체 생성이 불가능하다.
        Men men = new Men();
        men.name = "김폴리";
        men.weight = 70;
        men.height = 180;

        Women women = new Women();
        women.name = "박인소";
        women.weight = 48;
        women.height = 160;

        men.eat("김치찌개");
        men.study();
        men.sleep(8);

        women.eat("파스타");
        women.study();
        women.sleep(9);
    }
}
