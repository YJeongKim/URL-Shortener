# URL-Shortener โ๏ธ

<br>

## ๐ฏ Requirements Spec

- ์น ํ์ด์ง ์๋ ฅํผ์ URL ์๋ ฅ ์ ๋จ์ถ๋ ๊ฒฐ๊ณผ ์ถ๋ ฅ

- ๋ธ๋ผ์ฐ์ ์ ์ฃผ์์ฐฝ์ ๋จ์ถ URL ์๋ ฅ ์ ๊ธฐ์กด URL๋ก ๋ฆฌ๋ค์ด๋ ํธ

- ๊ฐ์ URL ์๋ ฅ ์ ๋์ผํ ๊ฒฐ๊ณผ๊ฐ ๋์ถ

- ๊ฒฐ๊ณผ๊ฐ์ ์ฃผ์๋ฅผ ์ ์ธํ๊ณ  8๊ธ์ ์ด๋ด๋ก ์์ฑ

<br>

## ๐ฎ Skill

### Backend

`Java` `SpringBoot` `Gradle` `H2Database` `SpringDataJPA`

### Frontend

`Mustache` `JavaScript` `jQuery` `CSS`

<br>

## ๐งฉ API Spec

> Request URL : http://localhost:8080/

<br>

### `POST` /api/urls

```
โ๏ธ ์๋ ฅํ URL์ ๋จ์ถํ๋ค.
```

- Request
    - Start Line

        ```bash
        POST /api/urls HTTP/1.1
        ```

    - Body

      ```json
      {
          "url" : "string/๋จ์ถํ  URL"
      }
      ```

- Response

    - Status Line

        ```bash
        200 OK
        400 Bad Request         // ์๋ชป๋ ํ์์ URL์ธ ๊ฒฝ์ฐ
        ```

    - Body

      ```json
      {
          "originalUrl"   : "string/๊ธฐ์กด URL",
          "shortenedUrl"  : "string/๋จ์ถ๋ URL", 
          "redirectCount" : "int/๋ฆฌ๋ค์ด๋ ํธ ํ์" 
      }
      ```

<br>

### `GET` /{path}

```
โ๏ธ ๊ธฐ์กด URL๋ก ๋ฆฌ๋ค์ด๋ ํธํ๋ค.
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
        404 Not Found         // ์กด์ฌํ์ง ์๋ URL์ผ ๊ฒฝ์ฐ
        ```

<br>

## ๐จ Result

<img src="https://user-images.githubusercontent.com/33328991/140698465-4f6e5022-df6d-4561-9402-08554cf2b672.gif">

<br>

<details>

<summary>1์ฐจ Version</summary>

### # ์ฒซ ์คํ

- Nothing

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140486570-7c74e276-e94c-4aa2-93a3-56563410241e.png">

### # URL ๋จ์ถ ์์ฒญ

- URL ์๋ ฅ >> Shorten ๋ฒํผ ํด๋ฆญ

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140486583-90a6b58a-fa16-4d67-96ae-e9262f43d08e.png">

- ๋จ์ถ๋ URL ํ์ธ

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140487248-d6755f9f-0234-4fa8-8504-d1c16bd0de6b.png">

- Copy ๋ฒํผ ํด๋ฆญ >> ๋จ์ถ๋ URL ํด๋ฆฝ๋ณด๋์ ๋ณต์ฌ

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140487268-7e3bbbf7-dd2c-449e-9307-409cf72c5056.png">
  
### # ์๋ชป๋ URL๋ก ๋จ์ถ ์์ฒญ

- ์๋ชป๋ URL ์๋ ฅ >> "์ ํจํ์ง ์๋ URL ์๋๋ค." ์๋ฆผ

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140488304-349738cf-cc7f-4b09-8490-dc304dd90e9a.png">

- ์๋ฌํธ ์ฐฝ ํ์ธ ๋ฒํผ >> ํ์คํธ ์๋ ฅ ์์ ์ด๊ธฐํ

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140488321-bfc46152-8f18-4231-8d92-bbe69b5952ae.png">

</details>

<details>

<summary>2์ฐจ Version</summary>

> ๋ณ๊ฒฝ๋ ์ฌํญ : UI ๋ณ๊ฒฝ, clear ๊ธฐ๋ฅ ์ถ๊ฐ

### # ์ฒซ ์คํ

- Nothing

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140643232-c6f0964a-a350-46c7-9e8a-54da999bcfa1.png">

### # URL ๋จ์ถ ์์ฒญ

- URL ์๋ ฅ >> Shorten ๋ฒํผ ํด๋ฆญ >> ๋จ์ถ๋ URL ํ์ธ

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140643237-0ab253c4-6173-48a2-83ba-d01d5703295d.png">

- Copy ๋ฒํผ ํด๋ฆญ >> ๋จ์ถ๋ URL ํด๋ฆฝ๋ณด๋์ ๋ณต์ฌ

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140643239-019e078e-e483-40e4-af28-a3eaac6e20ce.png">

### # ์๋ชป๋ URL๋ก ๋จ์ถ ์์ฒญ

- ์๋ชป๋ URL ์๋ ฅ >> "์ ํจํ์ง ์๋ URL ์๋๋ค." ์๋ฆผ

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140643245-d32be208-e4b5-4f12-a4e8-792e27a10ae6.png">

- ์๋ฌํธ ์ฐฝ ํ์ธ ๋ฒํผ >> ํ์คํธ ์๋ ฅ ์์ ์ด๊ธฐํ

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140643252-5a700ce5-e43c-4024-9cc6-5cda31364201.png">

### # ๋จ์ถ๋ URL๋ก ๋ฆฌ๋ค์ด๋ ํธ ์์ฒญ

- ๋ธ๋ผ์ฐ์  ์ฃผ์์ฐฝ์ ๋จ์ถ๋ URL ์๋ ฅ

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140644133-a7abf2de-ec03-4fcc-9b52-fa10435088c1.png">

- ๊ธฐ์กด URL๋ก ๋ฆฌ๋ค์ด๋ ํธ

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140644149-9d657403-49f5-44ca-9c12-fa71f008722a.png">

### # ์๋ ฅ ์ด๊ธฐํ

- URL ์๋ ฅ ํ ๋จ์ถ๋ ์ํ

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140643831-5f9d9149-f25b-478a-b56c-2e1c72a400e0.png">

- Clear ๋ฒํผ ํด๋ฆญ >> ํ์คํธ ์๋ ฅ ์์ ๋ชจ๋ ์ด๊ธฐํ

    <img width="90%" src="https://user-images.githubusercontent.com/33328991/140643258-f5b2221f-9411-4e59-9572-555f0d05a4be.png">

</details>
