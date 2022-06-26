package io.mini.jejoTrip.repository;

import io.mini.jejoTrip.domain.entity.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews, Long> {


    Optional<Reviews> findByTag(String tag);
    Optional<Reviews> findByPlace(String place);
}
