# 구현해야 할 사항 목록
 * View 개선
   - LottoUserInputReceiver가 사용자의 입력 오류 이후 재시도를 요청하도록 개선.
    
# 구현 완료 한 사항 목록
 * Model 구현
   - 로또 번호를 정의한 LottoNumber 클래스.
   - 로또 번호 6개를 가지는 LottoTicket 클래스.
   - 로또 관련 여러가지 상수를 담는 LottoStaticConstants 클래스.
   - 로또 티켓을 자동 또는 수동으로 생성하는 LottoMachine 클래스.
   - 구매한 모든 로또 티켓들을 관리하는 LottoTickets 클래스.
   - 로또 당첨 번호와 보너스 번호를 담는 LottoWinningNumber 클래스.
   - 로또 당첨 등수를 정의한 LottoResult 클래스.
   - 각 로또 티켓에 대해 당첨 결과를 확인하는 LottoResultDetector 클래스.
   - 각 로또 티켓들에 대해 얻어진 당첨 결과들을 관리하는 LottoResults 클래스.
   - 유효한 사용자 입력 값 만을 담는 LottoUserInput 클래스.
 * View 구현
   - 로또 프로그램 실행 결과를 받아 요구 사항에 맞게 출력해주는 LottoOutputPrinter 클래스.
   - 로또 프로그램 구동을 위해 사용자 입력 값을 받는 LottoUserInputReceiver 클래스.
 * Controller 구현
   - 로또 프로그램을 실행하는 LottoMain 클래스.
 * Model 개선
   - LottoWinningNumber가 LottoTicket을 활용하도록 개선.
   - LottoResultDetector가 LottoResult를 얻는 과정에서 호출하는 API chain이 parameter로 First Class Collection을 활용하도록 개선.
 * Controller 개선
   - Controller 기능 메소드 분리 및 객체 지향화.
   