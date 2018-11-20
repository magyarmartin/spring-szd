package hu.magyarm.study.entity.lesson;

import hu.magyarm.study.entity.comment.Comment;
import hu.magyarm.study.entity.section.Section;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column( name = "name", length = 30 )
    private String name;

    @Column( name = "content_text", length = 5000 )
    private String contentText;

    @Column( name = "video_location", length = 30 )
    private String videoLocation;

    @OneToOne
    @JoinColumn( name = "next_lesson" )
    private Lesson next;

    @ManyToOne
    @JoinColumn( name = "section_id" )
    private Section baseSection;

    @Column( name = "creation_date" )
    private Date creationDate;

    @OneToMany( fetch = FetchType.LAZY, mappedBy = "target" )
    private List<Comment> comments;

}
