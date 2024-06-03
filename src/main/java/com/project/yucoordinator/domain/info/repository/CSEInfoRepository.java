package com.project.yucoordinator.domain.info.repository;

import com.project.yucoordinator.domain.info.entity.CSEInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CSEInfoRepository extends JpaRepository<CSEInfoEntity, Long> {
    Optional<CSEInfoEntity> findByTitle(String title);
}
