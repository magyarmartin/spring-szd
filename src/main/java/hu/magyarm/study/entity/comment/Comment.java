package hu.magyarm.study.entity.comment;

import hu.magyarm.study.entity.lesson.Lesson;
import hu.magyarm.study.entity.user.ApplicationUser;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Comment {

    private static final long serialVersionUID = 3985878900892878877L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column( name = "content", length = 500 )
    private String content;

    @Column( name = "creation_date" )
    private Date creationDate;

    @ManyToOne
    @JoinColumn( name = "user_id" )
    private ApplicationUser owner;

    @ManyToOne
    @JoinColumn( name = "target" )
    private Lesson target;

}
