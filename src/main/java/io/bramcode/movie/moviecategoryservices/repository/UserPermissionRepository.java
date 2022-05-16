package io.bramcode.movie.moviecategoryservices.repository;

import io.bramcode.movie.moviecategoryservices.auth.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionRepository extends JpaRepository<UserPermission, String> {
}
