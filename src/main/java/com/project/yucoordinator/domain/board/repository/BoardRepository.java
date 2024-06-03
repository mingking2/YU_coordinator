package com.project.yucoordinator.domain.board.repository;

import com.project.yucoordinator.domain.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    List<BoardEntity> findByUserEntityUsername(String username);
}
