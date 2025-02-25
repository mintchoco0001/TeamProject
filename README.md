<div align="center">
  <a href="README_JP.md">日本語</a>
</div>
  

# TeamProject - 음식점 조회 및 상세 정보 시스템

  

이 프로젝트는 음식점 리스트와 상세 정보를 제공하는 **웹 애플리케이션**입니다. 사용자가 음식점을 조회하고 상세 정보를 확인하며, Google Maps API를 통해 위치 정보를 시각화합니다. 이 애플리케이션은 팀 프로젝트의 일환으로 개발되었습니다.

  

-  **팀장 프로젝트 GitHub 레포지토리 (전체코드 열람):** [JuYoungJun / TeamProject](https://github.com/JuYoungJun/TeamProject)

  

---

  

## 목차

  

- [프로젝트 개요](#프로젝트-개요)

- [기여한 부분](#기여한-부분)

- [기능](#기능)

- [기술 스택](#기술-스택)

- [프로젝트 구조](#프로젝트-구조)

- [데이터베이스 테이블](#데이터베이스-테이블)

- [실행 방법](#실행-방법)

- [환경 변수](#환경-변수)

- [스크린샷](#스크린샷)


  

---

  

## 프로젝트 개요

  

이 프로젝트의 목표는 사용자가 음식점을 **구와 키워드**로 검색하고, **리뷰 수와 별점**을 기준으로 정렬된 결과를 제공하는 시스템입니다. 사용자는 상세 페이지를 통해 음식점의 세부 정보를 확인하고, 해당 위치를 Google Maps에서 시각적으로 확인할 수 있습니다.

  

---

  

## 기여한 부분

  

본인은 다음과 같은 주요 기능 및 코드 구현에 기여하였습니다.

  

1.  **`FoodListController.java`**

- 음식점 목록과 상세 정보 제공을 위한 컨트롤러 구현

-  `GET /foodlist` 요청을 처리하여 검색된 음식점 데이터를 반환

- 특정 음식점의 상세 정보를 조회하는 엔드포인트 구현

  

2.  **`FoodService.java`**

- 음식점 관련 비즈니스 로직 구현

- 목록과 상세 정보를 조회하는 서비스 메서드 제공

  

3.  **`FoodMapper.java` 및 `foodMapper.xml`**

- MyBatis 매퍼 인터페이스와 SQL 쿼리 작성

- 음식점 목록과 상세 정보 조회, 정렬을 위한 SQL 쿼리 구현

  

4.  **`foodList.html`**

- Bootstrap을 사용한 UI 구현으로 음식점 목록 페이지 작성

- 구 선택과 키워드 검색, 정렬 및 페이지네이션 기능 제공

  

5.  **`foodDetail.html`**

- 상세 정보 페이지 구현, Google Maps API를 사용해 위치 정보 시각화

  

---

  

## 기능

  

-  **음식점 목록 조회:** 사용자가 선택한 구와 키워드로 음식점 리스트를 검색합니다.

-  **정렬 기능:** 리뷰 수와 별점 순으로 음식점을 정렬합니다.

-  **음식점 상세 정보 조회:** 상세 페이지에서 음식점의 세부 정보와 위치를 확인할 수 있습니다.

-  **페이지네이션:** 검색 결과를 페이지별로 나눠서 표시합니다.

  

---

  

## 기술 스택

  

-  **Backend:** Java, Spring Boot, MyBatis

-  **Frontend:** Thymeleaf, HTML5, CSS3, Bootstrap 4.5, jQuery

-  **Database:** MySQL

-  **API:** Google Maps API

  

---

  

## 프로젝트 구조

  

```bash

src/

├──  main/

│  ├──  java/

│  │  └──  yohaeng/

│  │  └──  gwangju/

│  │  ├──  controller/

│  │  │  └──  FoodListController.java  # 음식점 목록 및 상세 정보 제공

│  │  ├──  service/

│  │  │  └──  FoodService.java  # 음식점 관련 비즈니스 로직

│  │  ├──  mapper/

│  │  │  └──  FoodMapper.java  # MyBatis 매퍼 인터페이스

│  ├──  resources/

│  ├──  mybatis/

│  │  └──  foodMapper.xml  # 음식점 관련 SQL 쿼리

│  └──  templates/

│  ├──  foodList.html  # 음식점 목록 페이지

│  └──  foodDetail.html  # 음식점 상세 페이지

```

  

---

  

## 데이터베이스 테이블

  

### `food` 테이블 구조

  

```sql

CREATE  TABLE `food` (

`id`  INT  PRIMARY KEY  NOT NULL AUTO_INCREMENT, -- 게시물 넘버

`title`  VARCHAR(100) NOT NULL, -- 음식점 이름

`addr1`  VARCHAR(100) DEFAULT  NULL, -- 주소

`addr2`  VARCHAR(10) DEFAULT  NULL, -- 행정동

`image`  VARCHAR(1000) DEFAULT  NULL, -- 음식점 이미지

`tel`  VARCHAR(30) DEFAULT  NULL, -- 전화번호

`rating` DOUBLE DEFAULT  NULL, -- 평점

`review_cnt`  INT  DEFAULT  NULL, -- 리뷰 수

`cat1`  VARCHAR(30) DEFAULT  NULL, -- 대분류 카테고리 코드

`cat2`  VARCHAR(30) DEFAULT  NULL, -- 중분류 카테고리 코드

`cat3`  VARCHAR(30) DEFAULT  NULL, -- 상세분류 카테고리 코드

`mapx` DOUBLE DEFAULT  NULL, -- 지도상의 X좌표

`mapy` DOUBLE DEFAULT  NULL, -- 지도상의 Y좌표

`sigungucode`  INT  DEFAULT  NULL, -- 구 코드 (예: 광산구: 1)

`category`  INT  DEFAULT  NULL  -- 게시물 유형 (예: 12는 관광지)

);

```

  

**참고:**  `cat1`, `cat2`, `cat3` 칼럼은 대분류, 중분류, 상세분류를 위해 설계되었으나, 시간적 제한으로 인해 **대분류(cat1)**만 사용하게 되었습니다.

  

---

  

## 실행 방법

  

1.  **의존성 설치:**

Gradle 명령어를 사용하여 프로젝트 의존성을 설치합니다.

  

```bash

./gradlew build

```

  

2.  **애플리케이션 실행:**

프로젝트를 실행합니다.

  

```bash

./gradlew bootRun

```

  

3.  **접속:**

브라우저에서 [http://localhost:8080/foodlist](http://localhost:8080/foodlist)에 접속합니다.

  

---

  

## 환경 변수

  

-  **Google Maps API Key:**

`application.properties` 파일에 다음과 같이 API 키를 설정해야 합니다.

  

```

google.maps.api.key=YOUR_API_KEY

```

  

---

  

## 스크린샷

  

### 음식점 목록 페이지

![음식점 리스트](./foodlist.png)

  

### 음식점 상세 정보 페이지

![음식점 상세](./fooddetail.png)

  

---






  

