package io.mini.jejoTrip.service;

import io.mini.jejoTrip.domain.dto.UsersDTO;
import io.mini.jejoTrip.domain.entity.Role;
import io.mini.jejoTrip.domain.entity.Users;
import io.mini.jejoTrip.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SignupService implements UserDetailsService {
    private UserRepository userRepository;

    @Transactional
    public Long joinUser(UsersDTO usersDTO) {
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        usersDTO.setPassword(passwordEncoder.encode(usersDTO.getPassword()));

        return userRepository.save(usersDTO.toEntity()).getUno();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> usersWrapper = userRepository.findByUsername(username);
        Users users = usersWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin@example.com").equals(username)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(users.getUsername(), users.getPassword(), authorities);
    }

}