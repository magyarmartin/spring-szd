package hu.magyarm.study.entity.rating;

import hu.magyarm.study.entity.course.Course;
import hu.magyarm.study.entity.lesson.Lesson;
import hu.magyarm.study.entity.section.Section;
import hu.magyarm.study.entity.user.ApplicationUser;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Data
public class Rating {

    private static final long serialVersionUID = 7563703512406751320L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Integer id;

    @Min( 1 )
    @Max( 5 )
    @Column( name = "score" )
    private int score;

    @Column( name = "description", length = 500 )
    private String description;

    @Column( name = "creation_date" )
    private Date creationDate;

    @ManyToOne
    @JoinColumn( name = "user_id" )
    private ApplicationUser owner;

    @ManyToOne
    @JoinColumn( name = "target_user" )
    private ApplicationUser targetUser;

    @ManyToOne
    @JoinColumn( name = "target_course" )
    private Course targetCourse;

    @ManyToOne
    @JoinColumn( name = "target_section" )
    private Section targetSection;

    @ManyToOne
    @JoinColumn( name = "target_lesson" )
    private Lesson targetLesson;

}
