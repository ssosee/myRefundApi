# π API Doc.
**λͺ¨λ  APIμ λ°μ΄ν° νμμ `content-type`: `application/json` μΌλ‘ μ μ νλ€.**

## μλ ν¬μΈνΈ: /myrefund/api/{λ²μ : v1}/{κΈ°λ₯λ³ URI}
## μλ΅

```json
{
  "status": ,
  "message": "",
  "data" : {},
  "error": ""
}
```
## νμκ°μ
* μλν¬μΈνΈ: `/signup`
* λ©μλ: POST
* μμ²­ νλΌλ―Έν°
  * `user_id(String)`
  * `password(String)`
  * `email(String)`
  * `phone(String)`
* μλ΅ μμ
```json
{
  "status": 200,
  "message": "νμκ°μ μλ£",
  "data": {
    "user_id": "dlwlrma"
  },
  "error": ""
}
```

## λ‘κ·ΈμΈ
* μλν¬μΈνΈ: `/login`
* λ©μλ: POST
* μμ²­ νλΌλ―Έν°
  * `user_id(String)`
  * `password(String)`
* μλ΅ μμ
```json
{
  "status": 200,
  "message": "λ‘κ·ΈμΈ μλ£",
  "data": {
    "user_id": "dlwlrma"
  },
  "error": ""
}
```

## λ‘κ·Έμμ
* μλν¬μΈνΈ: `/logout`
* λ©μλ: POST
* μλ΅ μμ
```json
{
  "status": 200,
  "message": "λ‘κ·Έμμ μλ£",
  "data": {
    "user_id": "dlwlrma"
  },
  "error": ""
}
```

## νμ μ λ³΄ μ‘°ν
* μλν¬μΈνΈ: `/myinfo`
* λ©μλ: GET
* μμ²­ νλΌλ―Έν°
* μλ΅ μμ
```json
{
  "status": 200,
  "message": "νμ μ λ³΄ μ‘°ν μλ£",
  "data": {
    "user_id": "dlwlrma",
    "refunds": [
      {"year": 2022, "refund": "1,000 μ"},
      {"year": 2021, "refund": "2,000 μ"}
    ]
  },
  "error": ""
}
```

## νκΈμ‘ μ‘°ν
* μλν¬μΈνΈ: `/find/refund`
* λ©μλ: POST
* μμ²­ νλΌλ―Έν°
  * `salary(float)`
  * `tax(float)`
* μλ΅ μμ
```json
{
  "status": 200,
  "message": "νκΈμ‘ μ‘°ν μλ£",
  "data": {
    "user_id": "dlwlrma",
    "refund": "2,000,000 μ"
  },
  "error": ""
}
```
