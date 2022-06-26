package io.mini.jejoTrip.domain.dto;

import io.mini.jejoTrip.domain.entity.Reviews;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Data
@Getter
@Setter
public class ReviewsDTO {
    private UsersDTO usersDTO;

    private Long rno;
    private String rev_title;
    private String tag;
    private String content;
    private String username;
    private String place;

    public Reviews toEntity() {
        Reviews reviews = Reviews.builder()
                .rev_title(rev_title)
                .tag(tag)
                .content(content)
                .place(place)
                .build();
        return reviews;
    }
}