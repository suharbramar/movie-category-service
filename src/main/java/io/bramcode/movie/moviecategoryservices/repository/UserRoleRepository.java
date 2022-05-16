package io.bramcode.movie.moviecategoryservices.repository;

import io.bramcode.movie.moviecategoryservices.auth.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
