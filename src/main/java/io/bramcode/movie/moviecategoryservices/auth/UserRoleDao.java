package io.bramcode.movie.moviecategoryservices.auth;

import java.util.Set;

public interface UserRoleDao {
    Set<UserRole> selectActiveUserRole();
}
