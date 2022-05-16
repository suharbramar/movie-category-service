package io.bramcode.movie.moviecategoryservices.auth;

import java.util.Set;

public interface UserPermissionDao {
    Set<UserPermission> selectActiveUserPermission();
}
