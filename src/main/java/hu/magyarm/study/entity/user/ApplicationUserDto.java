package hu.magyarm.study.entity.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class ApplicationUserDto {

    private String email;
    private String firstName;
    private String lastName;
    private String about;
    private boolean instructor;
    private Date registrationDate;

}
