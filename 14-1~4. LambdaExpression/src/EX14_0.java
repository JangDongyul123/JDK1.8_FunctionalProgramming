import java.util.*;

public class EX14_0 {
    public static void main(String[] args) {
        //Object obj = (a,b)-> a>b ? a:b;
        //자바에서 람다식은 익명함수가 아니라 익명객체이다.
        //왜냐하면 자바에서는 함수가 혼자 존재할 수 없기 때문이다.
        //즉 Object obj = (a,b)-> a>b ? a:b; 는
        //Object obj = new Object( ){
        //                  int max(int a, int b){
        //                      return a>b?a:b;
        //                  }
        //              };
        //와 같다.
        //그렇지만, 위처럼 Object obj = (a,b)-> a>b ? a:b; 이렇게 써도 에러가 생기긴 한다.
        //람다식은 함수형 인터페이스로 다뤄야 하기 때문이다.
        Object obj1 = new Object() {
            int max(int a, int b) {
                return a > b ? a : b;
            }
        };
        //근데 이렇게는 되는데?
        //어쨋든 위와 아래가 같다.
        Object obj2 = new Object( ){
                          int max(int a, int b){
                              return a>b?a:b;
                          }
                      };

        //그리고 아래처럼 사용이 안되는 이유는
        //익명객체의 부모 클래스인 Object 에 max 함수가 없기 때문이다.
        //이해 안되면 업캐스팅 공부하기
        int value1 = obj1.max(3,5);
        int value2 = obj2.max(3,5);
        //그래서 필요한 게 함수형 인터페이스다.



    }
}
