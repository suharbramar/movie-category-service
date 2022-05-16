package io.bramcode.movie.moviecategoryservices.security;

import io.bramcode.movie.moviecategoryservices.auth.UserPermission;
import io.bramcode.movie.moviecategoryservices.auth.UserPermissionDaoService;
import io.bramcode.movie.moviecategoryservices.auth.UserRoleDaoService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ApplicationUserRole {

    private final UserPermissionDaoService userPermissionDaoService;
    private final UserRoleDaoService userRoleDaoService;

    public ApplicationUserRole(UserPermissionDaoService userPermissionDaoService, UserRoleDaoService userRoleDaoService) {
        this.userPermissionDaoService = userPermissionDaoService;
        this.userRoleDaoService = userRoleDaoService;
    }

    public Set<UserPermission> getPermissions() {
        return userPermissionDaoService.selectActiveUserPermission();
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(String roleName) {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermissionName()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + roleName));
        return permissions;
    }
}
