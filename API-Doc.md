# 📗 API Doc.
**모든 API의 데이터 형식은 `content-type`: `application/json` 으로 정의 한다.**

## 엔드 포인트: /myrefund/api/{버전: v1}/{기능별 URI}
## 응답

```json
{
  "status": ,
  "message": "",
  "data" : {},
  "error": ""
}
```
## 회원가입
* 엔드포인트: `/signup`
* 메서드: POST
* 요청 파라미터
  * `user_id(String)`
  * `password(String)`
  * `email(String)`
  * `phone(String)`
* 응답 예시
```json
{
  "status": 200,
  "message": "회원가입 완료",
  "data": {
    "user_id": "dlwlrma"
  },
  "error": ""
}
```

## 로그인
* 엔드포인트: `/login`
* 메서드: POST
* 요청 파라미터
  * `user_id(String)`
  * `password(String)`
* 응답 예시
```json
{
  "status": 200,
  "message": "로그인 완료",
  "data": {
    "user_id": "dlwlrma"
  },
  "error": ""
}
```

## 회원 정보 조회
* 엔드포인트: `/myinfo`
* 메서드: GET
* 요청 파라미터
* 응답 예시
```json
{
  "status": 200,
  "message": "회원 정보 조회 완료",
  "data": {
    "user_id": "dlwlrma",
    "refunds": [
      {"year": "2022", "refund": 1000},
      {"year": "2021", "refund": 2000}
    ]
  },
  "error": ""
}
```

## 환급액 조회
* 엔드포인트: `/find/refund`
* 메서드: POST
* 요청 파라미터
  * `salary(float)`
  * `tax(float)`
* 응답 예시
```json
{
  "status": 200,
  "message": "환급액 조회 완료",
  "data": {
    "user_id": "dlwlrma",
    "refund": "2,000,000 원"
  },
  "error": ""
}
```
