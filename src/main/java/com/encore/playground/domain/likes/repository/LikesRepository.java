package com.encore.playground.domain.likes.repository;

import com.encore.playground.domain.feed.entity.Feed;
import com.encore.playground.domain.likes.entity.Likes;
import com.encore.playground.domain.member.entity.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    @Transactional
    void deleteByFeedAndMember(Feed feed, Member member);

    // Feed의 좋아요 수
    Integer countByFeed_Id(Long feedId);

    // 사용자가 좋아요한 feed
    Long countByMember(Member member);

    // 이미 좋아요를 누른 피드인지 검사
    Boolean existsByFeed_IdAndMember_Id(Long feedId, Long memberId);
}
