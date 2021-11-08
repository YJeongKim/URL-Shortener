# URL-Shortener ✂️

<br>

## 🎯 Requirements Spec

- 웹 페이지 입력폼에 URL 입력 시 단축된 결과 출력

- 브라우저의 주소창에 단축 URL 입력 시 기존 URL로 리다이렉트

- 같은 URL 입력 시 동일한 결과값 도출

- 결과값은 주소를 제외하고 8글자 이내로 생성

<br>

## 🎮 Skill

### Backend

`Java` `SpringBoot` `Gradle` `H2Database` `SpringDataJPA`

### Frontend

`Mustache` `JavaScript` `jQuery` `CSS`

<br>

## 🧩 API Spec

> Request URL : http://localhost:8080/

<br>

### `POST` /api/urls

```
✔️ 입력한 URL을 단축한다.
```

- Request
    - Start Line

        ```bash
        POST /api/urls HTTP/1.1
        ```

    - Body

      ```json
      {
          "url" : "string/단축할 URL"
      }
      ```

- Response

    - Status Line

        ```bash
        200 OK
        400 Bad Request         // 잘못된 형식의 URL인 경우
        ```

    - Body

      ```json
      {
          "originalUrl"   : "string/기존 URL",
          "shortenedUrl"  : "string/단축된 URL", 
          "redirectCount" : "int/리다이렉트 횟수" 
      }
      ```

<br>

### `GET` /{path}

```
✔️ 기존 URL로 리다이렉트한다.
```

- Request
    - Start Line

        ```bash
        GET /{path} HTTP/1.1
        ```

- Response

    - Status Line

        ```bash
        200 OK
        404 Not Found         // 존재하지 않는 URL일 경우
        ```

<br>

## 🎨 Result

<img src="https://user-images.githubusercontent.com/33328991/140698465-4f6e5022-df6d-4561-9402-08554cf2b672.gif">

<br>

<details>

<summary>1차 Version</summary>

### # 첫 실행

- Nothing

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140486570-7c74e276-e94c-4aa2-93a3-56563410241e.png">

### # URL 단축 요청

- URL 입력 >> Shorten 버튼 클릭

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140486583-90a6b58a-fa16-4d67-96ae-e9262f43d08e.png">

- 단축된 URL 확인

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140487248-d6755f9f-0234-4fa8-8504-d1c16bd0de6b.png">

- Copy 버튼 클릭 >> 단축된 URL 클립보드에 복사

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140487268-7e3bbbf7-dd2c-449e-9307-409cf72c5056.png">
  
### # 잘못된 URL로 단축 요청

- 잘못된 URL 입력 >> "유효하지 않는 URL 입니다." 알림

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140488304-349738cf-cc7f-4b09-8490-dc304dd90e9a.png">

- 알러트 창 확인 버튼 >> 텍스트 입력 상자 초기화

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140488321-bfc46152-8f18-4231-8d92-bbe69b5952ae.png">

</details>

<details>

<summary>2차 Version</summary>

> 변경된 사항 : UI 변경, clear 기능 추가

### # 첫 실행

- Nothing

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140643232-c6f0964a-a350-46c7-9e8a-54da999bcfa1.png">

### # URL 단축 요청

- URL 입력 >> Shorten 버튼 클릭 >> 단축된 URL 확인

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140643237-0ab253c4-6173-48a2-83ba-d01d5703295d.png">

- Copy 버튼 클릭 >> 단축된 URL 클립보드에 복사

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140643239-019e078e-e483-40e4-af28-a3eaac6e20ce.png">

### # 잘못된 URL로 단축 요청

- 잘못된 URL 입력 >> "유효하지 않는 URL 입니다." 알림

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140643245-d32be208-e4b5-4f12-a4e8-792e27a10ae6.png">

- 알러트 창 확인 버튼 >> 텍스트 입력 상자 초기화

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140643252-5a700ce5-e43c-4024-9cc6-5cda31364201.png">

### # 단축된 URL로 리다이렉트 요청

- 브라우저 주소창에 단축된 URL 입력

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140644133-a7abf2de-ec03-4fcc-9b52-fa10435088c1.png">

- 기존 URL로 리다이렉트

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140644149-9d657403-49f5-44ca-9c12-fa71f008722a.png">

### # 입력 초기화

- URL 입력 후 단축된 상태

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140643831-5f9d9149-f25b-478a-b56c-2e1c72a400e0.png">

- Clear 버튼 클릭 >> 텍스트 입력 상자 모두 초기화

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140643258-f5b2221f-9411-4e59-9572-555f0d05a4be.png">

</details>
