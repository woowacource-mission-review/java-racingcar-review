# java-racingcar
- 요구사항: https://techcourse.woowahan.com/s/1aKh56So/ls/vyt2vo7Y

## 객체지향 생활 체조

- 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기만 한다.
- 규칙 2: else 예약어를 쓰지 않는다.
- 규칙 3: 모든 원시값과 문자열을 포장한다.
- 규칙 4: 한 줄에 점을 하나만 찍는다.
- 규칙 5: 줄여쓰지 않는다(축약 금지).
- 규칙 6: 모든 엔티티를 작게 유지한다.
- 규칙 7: 2개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
- 규칙 8: 일급 콜렉션을 쓴다.
- 규칙 9: 게터/세터/프로퍼티를 쓰지 않는다.

## To Do List
1. 자동차 객체
    1. ~~자동차는 전진 또는 멈출 수 있다.~~
    2. ~~자동차에 이름을 부여할 수 있다.~~
2. 자동차 전진 전략 객체
    1. ~~자동차가 전진하는 조건은 0-9 난수를 구하고 4 이상일 경우 전진, 3 이하일 경우 멈춘다.~~
3. 게임 로직 객체
    1. ~~입력받은 자동차 이름 리스트로 자동차 객체를 생성한다.~~
    3. ~~자동차들을 전진 또는 멈춘다.~~
    4. 우승자(들)를 찾는다.
4. 입출력 뷰 객체
    1. 사용자로부터 자동차 이름의 리스트를 콘솔로 입력받는다.
    2. 사용자로부터 진행할 레이싱 횟수를 콘솔로 입력받는다.
    3. 레이싱 상황을 콘솔에 출력한다.
    4. 게임 결과(우승자들)를 콘솔에 출력한다.
5. 메인 앱
    1. 입력받은 레이싱 횟수동안 레이싱 게임을 진행한다.
    2. 입출력 뷰 객체를 생성하고 호출한다.

## 리뷰어에게
1. 전략패턴을 활용하여 테스트할 수 없는 부분(난수 발생)을 테스트할 수 있는 부분과 분리하여 테스트 커버리지를 높였습니다.
2. TDD 를 준수하고자 노력했습니다. 커밋 메시지를 확인해주세요.