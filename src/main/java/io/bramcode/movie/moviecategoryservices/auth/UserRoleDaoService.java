package io.bramcode.movie.moviecategoryservices.auth;

import io.bramcode.movie.moviecategoryservices.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserRoleDaoService implements UserRoleDao {

    private final UserRoleRepository userRoleRepository;

    public UserRoleDaoService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public Set<UserRole> selectActiveUserRole() {
        return userRoleRepository.findAll().stream()
                .filter(
                        userRole1 ->
                                Boolean.TRUE.equals(userRole1.isRoleEnabled())
                ).collect(Collectors.toSet());
    }
}
