package ai0825;

import java.util.Arrays;
import java.util.Random;

public class LABRandomWiseSaying {
    public static void main(String[] args) {
        String[] wiseSay = {
                "실패는 새로운 시작이다",
                "계획 없는 목표는 그냥 바램에 불과하다",
                "가장 어려운 일은 스스로를 깨끗이 닦는 일이다",
                "네 자신을 믿어라. 너 자신이 가장 큰 기적이다",
                "성공은 준비된 사람을 만나게 된다",
                "성공의 비결은 실패를 견뎌내는 데 있다",
                "시작은 반이다",
                "행동은 모든 성공의 기초다",
                "당신의 미래는 당신이 만든다",
                "시작한다고 했을땐 늦었다. 그러니까 빨리 시작해라"
        };
        Random rand = new Random();
        int randomIndex =rand.nextInt(wiseSay.length);
        System.out.println("오늘의 명언 : " + wiseSay[randomIndex]);
    }
}
