package hu.magyarm.study.entity.user;

import hu.magyarm.study.entity.comment.Comment;
import hu.magyarm.study.entity.course.Course;
import hu.magyarm.study.entity.rating.Rating;
import hu.magyarm.study.entity.section.Section;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @Column( length = 1000, nullable = true)
    private String about;
    private boolean instructor;
    private Date registrationDate;

    @OneToMany( fetch = FetchType.LAZY, mappedBy = "creator" )
    private List<Course> ownCourses;

    @OneToMany( fetch = FetchType.LAZY, mappedBy = "owner" )
    private List<Comment> comments;

    @OneToMany( fetch = FetchType.LAZY, mappedBy = "owner" )
    private List<Rating> ratings;

    @OneToMany( fetch = FetchType.LAZY )
    @JoinTable( name = "PROGRESS", joinColumns = @JoinColumn( name = "user_id", referencedColumnName = "id" ),
            inverseJoinColumns = @JoinColumn( name = "lesson_id", referencedColumnName = "id" ) )
    private List<Section> startedLessons;

    @OneToMany( fetch = FetchType.LAZY )
    @JoinTable( name = "PROGRESS", joinColumns = @JoinColumn( name = "user_id", referencedColumnName = "id" ),
            inverseJoinColumns = @JoinColumn( name = "section_id", referencedColumnName = "id" ) )
    private List<Comment> startedSections;

    @OneToMany( fetch = FetchType.LAZY )
    @JoinTable( name = "PROGRESS", joinColumns = @JoinColumn( name = "user_id", referencedColumnName = "id" ),
            inverseJoinColumns = @JoinColumn( name = "course_id", referencedColumnName = "id" ) )
    private List<Course> startedCourses;

}