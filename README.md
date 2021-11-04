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
          "url" : "string"     // 단축할 URL
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
          "originalUrl"   : "string",     // 기존 URL
          "shortenedUrl"  : "string",     // 단축된 URL
          "redirectCount" : "int"         // 리다이렉트 횟수
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