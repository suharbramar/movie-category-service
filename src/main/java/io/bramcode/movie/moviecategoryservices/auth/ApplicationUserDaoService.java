package io.bramcode.movie.moviecategoryservices.auth;

import com.google.common.collect.Lists;
import io.bramcode.movie.moviecategoryservices.repository.UserApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static io.bramcode.movie.moviecategoryservices.security.ApplicationUserRole.*;

@Repository("fake") //this means to tell spring that this class need to be initiate
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;
    private final UserApplicationRepository userApplicationRepository;

    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder, UserApplicationRepository userApplicationRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userApplicationRepository = userApplicationRepository;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {

        return getApplicationUser()
                .stream()
                .filter(applicationUser -> {
                    return username.equals(applicationUser.getUsername());
                })
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUser() {
        List<ApplicationUser> applicationUsers = userApplicationRepository.findAll();
//        List<ApplicationUser> applicationUsers = Lists.newArrayList(
//                new ApplicationUser(
//                        "Bramar",
//                        passwordEncoder.encode("password"),
//                        ADMIN.getGrantedAuthorities(),
//                        true,
//                        true,
//                        true,
//                        true
//                ),
//                new ApplicationUser(
//                        "Budi",
//                        passwordEncoder.encode("staff123"),
//                        ADMIN_TRAINEE.getGrantedAuthorities(),
//                        true,
//                        true,
//                        true,
//                        true
//                ),
//                new ApplicationUser(
//                        "Dudi",
//                        passwordEncoder.encode("staff321"),
//                        STAFF.getGrantedAuthorities(),
//                        true,
//                        true,
//                        true,
//                        true
//                )
//        );

        return applicationUsers;
    }
}
