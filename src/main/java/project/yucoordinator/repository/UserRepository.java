package project.yucoordinator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.yucoordinator.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
