package com.project.yucoordinator.domain.info.repository;

import com.project.yucoordinator.domain.info.entity.YUInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface YUInfoRepository extends JpaRepository<YUInfoEntity, Long> {
    Optional<YUInfoEntity> findByTitle(String title);
}
