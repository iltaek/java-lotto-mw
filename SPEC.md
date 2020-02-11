[TODO]
- 리팩토링
  - 유사 클래스 정리 고려(LottoPaper, WinningNumbers 등)
  - 자료구조 검토 (LinkedHashSet)

[DONE]
- User Input
  - 유저 인풋을 받는 부분을 구현
  - 유저 인풋에 대한 테스트 작성
    - 유저 인풋에 대한 exception 메시지를 테스트에서 체크하도록 변경
- Lotto Number Select
  - 자동으로 로또 번호 뽑아주는 클래스 구현
  - 자동으로 뽑힌 로또 번호에 대한 테스트 작성
- 수동, 자동으로 뽑은 번호 보여주는 클래스 구현
- 리팩토링 진행
  - Indentation 줄이기
  - LottoNumber, LottoPaper 만들기
- 당첨 번호 뽑는 클래스 구현
- Prize enum 구현
- 버그 수정
  - 중복 테스트에 LottoNumber가 아니라, LottoNumber.selectedNumber 값을 비교해야 
- 당첨 결과를 뽑는 클래스 구현
  - 통계 클래스 구현