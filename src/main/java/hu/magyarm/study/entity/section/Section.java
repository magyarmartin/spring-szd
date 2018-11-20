package hu.magyarm.study.entity.section;

import hu.magyarm.study.entity.course.Course;
import hu.magyarm.study.entity.lesson.Lesson;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Section {

    private static final long serialVersionUID = -371066170686399849L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column( name = "name", length = 30 )
    private String name;

    @Column( name = "description", length = 500 )
    private String description;

    @ManyToOne
    @JoinColumn( name = "course_id" )
    private Course course;

    @Column( name = "creation_date" )
    private Date creationDate;

    @OneToMany( fetch = FetchType.LAZY, mappedBy = "baseSection" )
    private List<Lesson> lessons;


}
