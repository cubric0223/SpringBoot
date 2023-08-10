<img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/eclipse-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white"> <img src="https://img.shields.io/badge/OracleSQL-F80000?style=for-the-badge&logo=Oracle&logoColor=white">
<img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white">
<img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white">
<img src="https://img.shields.io/badge/JAVA Swing-007396?style=for-the-badge&logo=java&logoColor=white">
<br>
# 🚅 기차 통합 예약 시스템

오프라인에서 기차 예매시 매표직원을 거치지 않고 손쉽게 예매하기 위해 개발하였습니다. <br>
<br>

### 👩‍💻 개발자
+ 이종현, 권영준, 김수진, 박정준, 이희정

### 🛠 협업도구
+ Git


### 🖥 POS
+ Java (java17)
+ Eclipse
+ Java swing


### 💾 DB
+ Oracle SQL (oracle 11g, ojdbc6)

<br>
<hr>

### ✔ 목차
 ##

  [1. 기술 개요](#1-기술-개요) <br>
  [2. 기능 소개](#2-기능-소개) <br>
  [3. 참고 문헌](#3-참고-문헌) <br>

<hr>
<br>


## 1. 기술 개요
   ### 📌 프로그램 설명

  국토교통부 기차 정보 API를 사용하여 실제와 동일하게 예매 환경을 조성하고, <br>
  키오스크에서 출발지, 목적지, 열차 종류, 인원수, 좌석, 차내식을 선택하면 총 금액 확인 후 결제와 환불이 가능한 프로그램 <br>
  (회원 / 비회원 예매 및 환불 나눠서 진행) <br>
  
  <img src = "https://github.com/wsws115/TrainRevervSystem/assets/45970992/d63bd68c-81c2-4ecf-8aed-74a86280e903" width="700">
  
  <br>

  ##
  ### 📌 순서도
  
  <img src = "https://github.com/wsws115/TrainRevervSystem/assets/45970992/367b4e13-89d3-42cb-95bc-1d8b53c1accc">
  <img src = "https://github.com/wsws115/TrainRevervSystem/assets/45970992/e5371592-4958-48a8-81f8-48a564dad7a0">
  <img src = "https://github.com/wsws115/TrainRevervSystem/assets/45970992/92ac2ca6-4525-4362-8a85-3b5a2c75b44e">
  <img src = "https://github.com/wsws115/TrainRevervSystem/assets/45970992/f84f7b4b-9bb0-418a-aa06-860a8eec58f5">
  <img src = "https://github.com/wsws115/TrainRevervSystem/assets/45970992/225d40b0-6a2a-479f-ba7a-abb9b2b6a7ed">

<br>
<br>

## 2. 기능 소개

 ### ☑ 회원 로그인 / 회원가입 / 비회원 로그인 <br>
 
 ### 회원가입 - 로그인
 
 ![회원가입-로그인](https://github.com/wsws115/TrainRevervSystem/assets/132882336/52b21f55-3aad-443d-8cd7-8e8872eac1ff)
 
  ### 아이디 찾기 / 비밀번호 변경
 
 ![아이디,비밀번호찾기](https://github.com/wsws115/TrainRevervSystem/assets/132882336/aaed86a7-404a-4a5e-8f3d-63b9338b7b91)

  메뉴 | 주요 기능
  :---:|:---:|
  **로그인** | 데이터베이스에 있는 아이디와 비밀번호를 대조하여 로그인한다
 **아이디 찾기** | 데이터베이스에 있는 이름과 전화번호와 대조하여 아이디를 알려준다
 **비밀번호 재설정** | 데이터베이스에 있는 아이디,이름,전화번호와 대조하여 비밀번호를 재설정한다
 **회원가입** | 모든 입력칸을 형식에 맞게 채우고 회원가입을 하면 데이터베이스에 값이 들어간다
 **비회원 로그인**&nbsp;&nbsp; | 전화번호와 4자리 비밀번호를 입력하면 데이터베이스와 대조하여 로그인이 된다
     
     ※ 회원가입 유효성 판단 기준
     1. 아이디 - 기존 회원과 중복되지 않는 아이디
     2. 비밀번호 - 6자리 이상 (대소문자, 숫자, 특수문자 포함)
     3. 이름 - 2자리 이상 한글
     4. 생년월일 - YYYY-MM-DD
     5. 전화번호 - 010-0000-0000
     6. 이메일 - "\\w+@\\w+\\.\\w+(\\.\\w+)?"
 
 ##

 ### ☑ 기차예매
 
  ![기차예매](https://github.com/wsws115/TrainRevervSystem/assets/132882336/8db34358-6452-40a2-8a59-6675c8eb06d1)
  
  메뉴 | 주요 기능
  :---:|:---:|
  **출/도착지 조회** | 로그인 이후 첫 화면. 주요 KTX역과 모든 철도역들을 선택할 수 있다. <br> 또한 ㄱㄴㄷ순으로 패널을 구성했다.
  **날짜 선택** | 캘린더에서 오늘 날짜 이후에 달력을 보여주고, 원하는 날짜를 선택할 수 있다.
  **열차 종류 선택** | 전체, KTX, SRT, ITX, 무궁화, 새마을 등의 열차중 원하는 열차를 고를 수 있다.
  **인원 선택** | 회원으로 로그인 시 일반, 어린이, 경로의 인원 골라 선택할 수 있고, 우대사항을 인증하면 우대인원도 고를 수 있다. 비회원 로그인 시 어린이, 경로, 우대사항은 선택 불가.
  **스케줄 선택** | API에서 불러온 기차 정보 리스트를 JTable 형태로 불러와 해당 기차의 특실/ 일반실을 구분하여 선택 가능 <br> 현재시간을 기준으로 이후의 기차리스트만 보여준다 
  **좌석 선택** | 앞 패널에서 선택한 인원정보와 기차타입을 불러와 원하는 좌석을 선택
  **차내식 선택**&nbsp;&nbsp; | 앞 패널에서 좌석 정보를 불러와 좌석 별 차내식 주문 가능 (미선택도 가능)
 
 ##

 ### ☑ 조회 / 환불
 
 ![티켓조회(회원)](https://github.com/wsws115/TrainRevervSystem/assets/132882336/33d25e43-72c1-44e9-a4c9-88ba4f9700f6)
 
  메뉴 | 서브 메뉴 | 주요 기능
  :---:|:---:|:---:|  
  **회원 조회** |`회원 로그인`| 로그인을 한 이후 해당 계정의 예약내역을 확인할 수 있다.
  &nbsp; |`예매 티켓 조회`| 예매한 티켓의 정보 및 차내식 등을 확인할 수 있다.
  &nbsp; |`예매 티켓 환불`| 티켓·차내식을 환불요청할 수 있다.
  **비회원 조회** |`비회원 로그인` | 전화번호와 확인비밀번호(4자리)를 입력해 예약내역을 확인할 수 있다.
  &nbsp; |`예매 티켓 조회` |예매한 티켓의 정보 및 차내식 등을 확인할 수 있다.
  &nbsp;&nbsp;&nbsp; |`예매 티켓 환불`&nbsp;&nbsp; | 티켓·차내식을 환불요청할 수 있다.

 ##

 ### ☑ 관리자
 
 ![KakaoTalk_20230601_162439180](https://github.com/wsws115/TrainRevervSystem/assets/132882336/b93f91c0-fbfd-49bb-a9a6-246ad19229b9)
 
  메뉴 | 서브 메뉴 | 주요 기능 |
  |:---:|:---:|:---:|
  **회원 티켓 조회** |`회원 티켓 환불` | 가입한 전화번호로 회원 조회하여, 티켓 환불 가능 <br> 조회되는 회원 없을 시에 경고창 나옴
  &nbsp; |`회원 탈퇴` | 예매한 티켓이 없을 시에 회원 탈퇴 가능 <br> 예매한 티켓이 있을 시 경고창 나옴
  **비회원 티켓 조회** |`비회원 티켓 환불` | 티켓 구매 시 입력한 전화번호로 비회원을 조회하여, 티켓 환불 가능 <br> (단, 예약 티켓이 1장 남았을 시에 비회원 자동 삭제됨) <br> 조회되는 회원 없을 시 경고창 나옴
  **차내식 관리** |`전체 메뉴 조회` | 차내식 전체 메뉴를 JTable로 출력
  &nbsp; |`메뉴 수정` | 기존 DB와 비교하여 수정된 부분만 UPDATE <br> 없는 메뉴 수정 시 메세지창 <br> 이미지 수정 시, 기존 이미지 관리 폴더에서 기존 파일 삭제 및 새로운 파일 저장 가능
  &nbsp;&nbsp;&nbsp; |`메뉴 추가`&nbsp;&nbsp; | 기존 DB와 비교하여 이름이 겹칠시 경고창 나옴
  
     ※ 차내식 유효성 판단 기준
     1. 대분류 : 식사류 / 면류 / 간식류 / 음료 중 선택 (식사류 default)
     1. 음식명 : NOT NULL
     2. 가격 : NOT NULL, 숫자만 가능
     3. 이미지 : NOT NULL, jpg & png만 가능

 ##

## 3. 참고 문헌
📚 공공데이터 포털 기차API https://www.data.go.kr/data/15098552/openapi.do?recommendDataYn=Y <br>
    - 출발역에서 도착역까지의 기차 목록 API
