# LMS-Backend



**오늘 할 일(Todo)**
----
  <_Todo API "UserId"의 하루 할 일._>

* **URL**

  <_The URL Structure (path = "/todo")_>

* **Method:**
  
  <_The request type_>

  `GET` | `POST` | `DELETE` | `PUT`
  
*  **URL Params**

   <_URL Params 존재 x._> 

   **Required:**
 
   `title=[String]`
   `todoCheck=[boolean]`

   **Optional:**
 
* **Data Params**

  <_id = encoding 된 id값 출력 (useerId x),
   title = "오늘 할 일",
   boolean = "할 일 체크"_>

* **Success Response:**
  
  <_What should the status code be on success and is there any returned data? This is useful when people need to to know what their callbacks should expect!_>

  * **Code:** 200 <br />
    **Content:** [ `{ error : null }`,
      `{ id : 2c9f85827e8b34a4017e904145b00000 }`,
      `{ title : null}`,
      `{ todoCheck : false }`]
 
* **Error Response:**

  <_Most endpoints will have many ways they can fail. From unauthorized access, to wrongful parameters etc. All of those should be liste d here. It might seem repetitive, but it helps prevent assumptions from being made where they should be._>

  * **Code:** 404 UNAUTHORIZED <br />
    **Content:** `{ error : "Not Found" }`


* **Sample Call:**


* **Notes:**
  <_현재 todo API는 데이터 저장 수정 불러오기 삭제 말고 다른 기능 구현 안되어있음. List 형식으로 작성되어 있으나 개인 유저를 통해 접근은 할 수 없음_>
