package com.fizz.fizz_server.domain.challenge.service;
import com.fizz.fizz_server.domain.challenge.dto.request.CreateChallengeRequestDto;
import com.fizz.fizz_server.domain.challenge.dto.response.ChallengeInfoResponseDto;
import com.fizz.fizz_server.domain.challenge.dto.response.ChallengeSummaryResponseDto;
import com.fizz.fizz_server.domain.user.domain.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ChallengeService {
    //챌린지 생성
    public void createChallengeByCategoryId(Long userId , CreateChallengeRequestDto requestDto);

    //id 기반 챌린지 상세정보 조회
    public ChallengeInfoResponseDto getChallengeInfoByChallengeId( Long challengeId );

    //챌린지명 기반 챌린지 상세정보 조회
    public ChallengeInfoResponseDto getChallengeInfoByChallengeTitle( String challengeTitle );

    //키워드 기반 챌린지 상세정보 목록 조회
    public List<ChallengeInfoResponseDto> getChallengeInfos(String keyword );

    //챌린지를 잠든 상태로 전환
    public Integer changeStateToSleeping();

    //모든 잠든 챌린지 목록
    public List<ChallengeSummaryResponseDto> getSleepingChallengeList();

    //모든 활성화 상태 챌린지 목록
    public List<ChallengeSummaryResponseDto> getActiveChallengeList();

    //특정 카테고리의 활성화 상태 챌린지 목록
    public List<ChallengeSummaryResponseDto> getActiveChallengeListByCategoryId(Long categoryId);

    //특정 카테고리의 잠든 상태 챌린지 목록
    public List<ChallengeSummaryResponseDto> getSleepingChallengeListByCategoryId(Long categoryId);

    //해당 사용자가 생성한 활성화 상태 챌린지 목록
    public List<ChallengeSummaryResponseDto> getActiveChallengeListByUser( Long userId );

    //해당 사용자가 생성한 활성화 상태 챌린지 목록
    public List<ChallengeSummaryResponseDto> getSleepingChallengeListByUser( Long userId );

    //해당 사용자가 참여한 챌린지 목록
    public List<ChallengeSummaryResponseDto> getActiveChallengeListParticipatedByUser( Long userId );
}
