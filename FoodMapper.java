package com.yohaeng.gwangju.mapper;

import com.yohaeng.gwangju.model.FoodDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FoodMapper {

    List<FoodDTO> foodlist(@Param("title") String title,
                           @Param("sigunguCode") String sigunguCode,
                           @Param("addr1") String addr1,
                           @Param("addr2") String addr2,
                           @Param("cat1") String cat1,
                           @Param("reviewCnt") Integer reviewCnt,
                           @Param("rating") Double rating,
                           @Param("sortType") String sortType,  // 정렬 기준 추가
                           @Param("offset") int offset,
                           @Param("size") int size);

    int countFoodList(@Param("title") String title,
                      @Param("sigunguCode") String sigunguCode,
                      @Param("addr1") String addr1,
                      @Param("addr2") String addr2,
                      @Param("cat1") String cat1,
                      @Param("reviewCnt") Integer reviewCnt,
                      @Param("rating") Double rating);

    FoodDTO getFoodDetail(@Param("id") int id);

    // 검색 키워드와 시군구 코드를 기반으로 장소 정보 조회
    List<FoodDTO> searchByKeywordAndSigungu(@Param("keyword") String keyword, @Param("sigunguCode") String sigunguCode);
}
