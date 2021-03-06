# final_project(달달하조)
1. 음식의 레시피를 추천해주는 시스템 
2. 오늘 뭐 먹지 같은 식단 추천 관리 시스템

### 기획 의도 : 요리에 관심이 있는 사람들이 실시간으로 요리를 찾아 볼 수 있으며 한 끼 식사의 칼로리, 조리시간, 조리법 소개 공유해주는 웹사이트입니다


### 기능 
1. 쉐프 & 레시피 리스트 게시
2. 상세 검색이 가능한 검색
3. SMTP를 이용한 이메일 인증 가능
4. Ajax를 사용하여 비-동기식 댓글 구현
5. 방문자 조회수 제어 (새로고침 방지)
6. AWS 인프라 구축
7. 구글, 네이버 로그인  API 활용

### 개발환경
1. 프론트엔드
   - HTML5, CSS,  jQuery, Bootstrap
2. 백엔드
   - JAVA, JSP, Spring MVC
   - Python, OracleDB
3. 개발 통합 환경
   - Eclipse( STS3)
4. 형상 관리 툴
   - GitHub
5. Server
   - AWS(ec2), Apache/Tomcat

<img width="347" alt="스크린샷 2020-11-22 오후 5 14 42" src="https://user-images.githubusercontent.com/22065725/99898618-3b10f780-2ce6-11eb-9f67-79baa060fe7e.png">

### 요구사항 정의

- 사용자는 네이버와 구글 그리고 일반 로그인을 통해서 로그인을 진행할 수 있다. 

- 사용자는 회원가입을 거칠 때 이메일 인증을 통해서 회원가입 인증을 할 수 있다.

- 상세 검색(재료, 레시피 이름, 작성자, 전체)을 통해서 원하는 레시피를 찾을 수 있다.

- 사용자는 쉐프 페이지, 레시피 페이지에 접근하여 이전에 등록된 사용자와의
   소통이 가능하다.

- 사용자는 덧글을 통해서 각 레시피가 어떤 영향을 미치고 있는지 알 수 있다.

- 사용자는 레시피 상세 페이지에 접근하여 만들고자 하는 요리의 칼로리 등을 볼 수 있다.


### 기능 소개 
 - 로그인
   - 네이버와 구글 그리고 일반 로그인을 통해서 로그인을 진행할 수 있다.
   <img width="559" alt="스크린샷 2020-11-22 오후 5 16 08" src="https://user-images.githubusercontent.com/22065725/99898647-6dbaf000-2ce6-11eb-9d01-336561c6ef3e.png">
   
 - 회원가입 
   - 사용자의 정보를 등록하여 회원가입을 진행할 수 있다.
   - 회원가입 중에 중복 아이디를 체크할 수 있다.
   <img width="558" alt="스크린샷 2020-11-22 오후 5 17 40" src="https://user-images.githubusercontent.com/22065725/99898671-a5299c80-2ce6-11eb-83ba-9a8202c63921.png">
   
 - 레시피 소개
   - 각 사용자가 등록한 레시피를 살펴볼 수 있다.
   <img width="657" alt="스크린샷 2020-11-22 오후 5 20 30" src="https://user-images.githubusercontent.com/22065725/99898724-0baeba80-2ce7-11eb-866d-f8c899befd4e.png">
   
 - 셰프 소개 
   - 각 사용자의 레시피 좋아요 개수를 살펴볼 수 있다.
   <img width="691" alt="스크린샷 2020-11-22 오후 5 21 25" src="https://user-images.githubusercontent.com/22065725/99898754-4dd7fc00-2ce7-11eb-9f66-9d3bc4b8e366.png">
 
