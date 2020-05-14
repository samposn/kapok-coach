package pro.kapok.coach.course.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Will WM. Zhang
 * @since 2020-04-27 17:56
 */
@Data
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String status;

}
