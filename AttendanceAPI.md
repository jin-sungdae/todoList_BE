# LMS-Backend

**월간 통계 (attendance)**
----
  <_Attendence API "UserId"의 월간 출석률._>

* **URL**

  <_The URL Structure (path = "/attendence")_>

* **Method:**
  
  <_The request type_>

  `GET` | `POST` | `DELETE` | `PUT`
  
*  **URL Params**

   <_URL Params 존재 x._> 

   **Required:**
 
   `attendanceStatus=[int]` 
   `goalAchievementRate=[Double]`
   `totalAttendance=[Double]`
   `attendanceScore=[Double]`
   `aojiTime=[double]`

   **Optional:**
 
* **Data Params**

  <_id = encoding 된 id값 출력 (useerId x),
  attendanceStatus = 오늘 하루 출석 현황,
  goalAchievementRate = 월간 목표 달성치,
  totalAttendance = 월간 출석률,
  attendanceScore = 월간 출석 점수,
  aojiTime = 아오지 시간._>

* **Success Response:**
  
  <_What should the status code be on success and is there any returned data? This is useful when people need to to know what their callbacks should expect!_>

  * **Code:** 200 <br />
    **Content:** [ `{ error : null }`,
      `{ id : 2c9f85827e8b34a4017e904145b00000 }`,
      `{ attendanceStatus : 0}`,     
      `{goalAchievementRate": 0.0}`,
      `{totalAttendance": 0.0}`,
      `{attendanceSocre": 0.0}`,
      `{aojiTime": 0.0}` ]
 
* **Error Response:**

  <_Most endpoints will have many ways they can fail. From unauthorized access, to wrongful parameters etc. All of those should be liste d here. It might seem repetitive, but it helps prevent assumptions from being made where they should be._>

  * **Code:** 404 UNAUTHORIZED <br />
    **Content:** `{ error : "Not Found" }`


* **Sample Call:**


* **Notes:**
  <_현재 attendence API는 데이터 저장 수정 불러오기 삭제 말고 다른 기능 구현 안되어있음._>
