package com.project.yucoordinator.domain.info.repository;

import com.project.yucoordinator.domain.info.entity.CSEInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CSEInfoRepository extends JpaRepository<CSEInfoEntity, Long> {
    Optional<CSEInfoEntity> findByTitle(String title);

    @Modifying
    @Transactional
    @Query(value = "ALTER TABLE cse_info AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
