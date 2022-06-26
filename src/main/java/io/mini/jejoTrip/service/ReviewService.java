package io.mini.jejoTrip.service;

import io.mini.jejoTrip.domain.dto.ReviewsDTO;
import io.mini.jejoTrip.domain.dto.UsersDTO;
import io.mini.jejoTrip.domain.entity.Reviews;
import io.mini.jejoTrip.domain.entity.Role;
import io.mini.jejoTrip.domain.entity.Users;
import io.mini.jejoTrip.repository.ReviewRepository;
import io.mini.jejoTrip.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewService {

    private ReviewRepository reviewRepository;

    @Transactional
    public Long regiReview(ReviewsDTO reviewsDTO) {

        return reviewRepository.save(reviewsDTO.toEntity()).getRno();
    }



}
