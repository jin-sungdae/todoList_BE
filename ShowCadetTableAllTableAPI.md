# LMS-Backend


**Save Cadet todo table (ShowCadetTableAllTable)**
----
  <_ShowCadetTableAllTable API 모든 "UserId"의 하루 출석상황 및..._>

* **URL**

  <_The URL Structure (path = "/ShowCadetTableAllTable")_>

* **Method:**
  
  <_The request type_>

  `GET` | `POST` | `DELETE` | `PUT`
  
*  **URL Params**

   <_URL Params 존재 x._> 

   **Required:**
 
   `userName=[String]` 
   `nowStatus=[double]`
   `firstYear=[int]`
   `firstMonth=[int]`
   `firstDay=[int]`
   `role=[String]`
   `progress=[String]`
   `checkIn=[short]`
   `checkOut=[short]`

   **Optional:**
 
* **Data Params**

  <_id = encoding 된 id값 출력 (useerId x),
   userName = "사용자 이름",
   firstYear = 시작한 년도,
   firstMonth = 시작한 달,
   firtDay = 시작한 일,
   role = 역할,
   progress = 진척도,
   checkIn = 체크인,
   checkOut = 체크아웃_>

* **Success Response:**
  
  <_What should the status code be on success and is there any returned data? This is useful when people need to to know what their callbacks should expect!_>

  * **Code:** 200 <br />
    **Content:** [ `{ error : null }`,
      `{ id : 2c9f85827e8b34a4017e904145b00000 }`,
      `{ userName : "김 아무개"}`,     
      `{ nowStatus: 0.0}`,
      `{firstYear: 0}`,
      `{firstMonth: 0}`,
      `{firstDay: 0}`,
      `{role: null}`,
      `{progress: null}`,
      `{checkIn: 0}`,
      `{checkOut: 0}` ]
 
* **Error Response:**

  <_Most endpoints will have many ways they can fail. From unauthorized access, to wrongful parameters etc. All of those should be liste d here. It might seem repetitive, but it helps prevent assumptions from being made where they should be._>

  * **Code:** 404 UNAUTHORIZED <br />
    **Content:** `{ error : "Not Found" }`


* **Sample Call:**


* **Notes:**
  <_현재 ShowCadetTableAllTable API는 데이터 저장 수정 불러오기 삭제 말고 다른 기능 구현 안되어있음._>
