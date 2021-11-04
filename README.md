# URL-Shortener ✂️

<br>

## 🎯 Requirements Spec

- 웹 페이지 입력폼에 URL 입력 시 단축된 결과 출력

- 브라우저의 주소창에 단축 URL 입력 시 기존 URL로 리다이렉트

- 같은 URL 입력 시 동일한 결과값 도출

- 결과값은 주소를 제외하고 8글자 이내로 생성


<br>

## 🎮 Skill

#### Backend

`Java` `SpringBoot` `Gradle` `H2Database` `SpringDataJPA`

#### Frontend

`Mustache` `JavaScript` `jQuery` `CSS`

<br>

## 🧩 API Spec

> Request URL : http://localhost:8080/

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
