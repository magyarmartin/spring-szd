package hu.magyarm.study.entity.course;

import hu.magyarm.study.entity.rating.Rating;
import hu.magyarm.study.entity.section.Section;
import hu.magyarm.study.entity.user.ApplicationUser;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private static final long serialVersionUID = -1591302474273896650L;

    @Column( name = "name", length = 30 )
    private String name;

    @Column( name = "description", length = 500 )
    private String description;

    @Column( name = "creation_date" )
    private Date creationDate;

    @ManyToOne
    @JoinColumn( name = "user_id" )
    private ApplicationUser creator;

    @OneToMany( fetch = FetchType.LAZY, mappedBy = "course" )
    private List<Section> sections;

    @OneToMany( fetch = FetchType.LAZY, mappedBy = "targetCourse" )
    private List<Rating> ratings;

}
