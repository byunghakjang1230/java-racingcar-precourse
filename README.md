# 자동차 경주 게임

## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항
* <u>주어진 횟수</u> 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 프로그래밍 요구사항
* 자바 코드 컨벤션을 지키면서 프로그래밍한다. ([링크](https://naver.github.io/hackday-conventions-java/))
* indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
* 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다.
* else 예약어를 쓰지 않는다.(switch/case문 또한 사용 금지)
* 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
#### 2주차 추가 요구사항
* 일급콜렉션을 활용해 구현한다. ([참고문서](https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/))
* 모든 원시값과 문자열을 포장한다. ([참고문서](https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4))
#### 단위테스트
* 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in, Scanner) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
* JUnit5와 AssertJ 사용법에 익숙하지 않은 개발자는 첨부한 "학습테스트를 통해 JUnit 학습하기.pdf" 문서를 참고해 사용법을 익힌 후 JUnit5 기반 단위 테스트를 구현한다.

## 진행 요구사항
* 기능을 구현하기 전에 java-racingcar-precourse/README.md 파일에 구현할 기능 목록을 정리해 추가 한다.
* git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
    - [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고해 commit log를 남긴다.
* 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/next-step/nextstep-docs/blob/master/precourse) 문서를 참고한다.

***
## 실행결과 예시
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과 
pobi : - 
crong : - 
honux : -

pobi : -- 
crong : - 
honux : --

pobi : --- 
crong : --
honux : ---

pobi : ---- 
crong : --- 
honux : ----

pobi : ----- 
crong : ---- 
honux : -----

pobi, honux가 최종 우승했습니다
```

***
## 기능 도출하기
- 0~9 사이의 랜덤한 숫자 1개를 구한다.
- 자동차의 이름을 지정한다.
    - 이름이 1~5자리가 아니라면 예외처리.
- 자동차가 정지(+0) 또는 이동(+1)할 수 있다.
    - 입력된 랜덤한 숫자가 3 이하일 경우 자동차가 멈춘다.
    - 입력된 랜덤한 숫자가 4 이상일 경우 자동차가 한칸 이동한다.
- 사용자로부터 입력받은 자동차 이름들로 자동차들을 생성하는 기능.
    - 입력된 이름들을 쉼표로 분리하고 각각의 이름으로 자동차 생성.
- 사용자로부터 입력받을 이동 횟수를 검증한다.
    - 1이상의 양의 정수가 아니면 예외처리.
    - 0은 경기진행이 되지 않으니 똑같이 예외처리.
- 회차마다 자동차 전체의 이동을 진행하고 결과를 반환한다.
- 가장 많이 이동한 자동차 목록(이동 거리가 동일할 경우)을 반환하는 기능.
- 이동이 진행될 때 마다 실행결과 출력.
- 자동차 경기가 끝난 뒤 우승 결과 출력.
