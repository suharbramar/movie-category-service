package io.bramcode.movie.moviecategoryservices.auth;

import java.util.Optional;

public interface ApplicationUserDao { //using DAO because it will easy implemtation when change database

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
