package hu.magyarm.study.entity.progress;

import hu.magyarm.study.entity.course.Course;
import hu.magyarm.study.entity.user.ApplicationUser;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    Integer id;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "user_id" )
    private ApplicationUser owner;

    @OneToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "course_id" )
    private Course targetCourse;

    @OneToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "section_id" )
    private Course targetSection;

    @OneToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "lesson_id" )
    private Course targetLesson;

    @Column( name = "creation_date" )
    private Date creationDate;

    @Column( name = "completed" )
    private boolean completed;

}
