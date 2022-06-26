package io.mini.jejoTrip.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "REVIEW_TBL")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @Column(nullable = false)
    private String rev_title;

    @Column(nullable = false)
    private String tag;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String place;

    @ManyToOne
    @JoinColumn(name = "username")
    private Users users;


}
