package io.bramcode.movie.moviecategoryservices.repository;

import io.bramcode.movie.moviecategoryservices.auth.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserApplicationRepository extends JpaRepository<ApplicationUser, Long> {
}
