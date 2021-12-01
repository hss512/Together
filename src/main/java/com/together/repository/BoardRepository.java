package com.together.repository;

import com.together.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Board findByIdAndMemberId(Long id, Long memberId);
}
