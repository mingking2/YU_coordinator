package com.project.yucoordinator.domain.info.repository;

import com.project.yucoordinator.domain.info.entity.YUInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface YUInfoRepository extends JpaRepository<YUInfoEntity, Long> {
    Optional<YUInfoEntity> findByTitle(String title);

    @Modifying
    @Transactional
    @Query(value = "ALTER TABLE yu_info AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
