package io.mini.jejoTrip.domain.dto;

import io.mini.jejoTrip.domain.entity.Users;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;
import javax.persistence.*;

@Data
@Getter
@Setter
public class UsersDTO {

    private Long uno;

    private String username; //사용자 e-mail

    private String password;

    private String realname; //실명

    private String nickname; //별명

    private String gender;

    private int age;



    /*DTO -> Entity*/
    public Users toEntity() {
        Users users = Users.builder()
                .username(username)
                .password(password)
                .realname(realname)
                .nickname(nickname)
                .gender(gender)
                .age(age)
                .build();
        return  users;
    }

}
