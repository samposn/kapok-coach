package pro.kapok.coach.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pro.kapok.coach.course.model.Course;

/**
 * @author Will WM. Zhang
 * @since 2020-04-27 17:57
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Modifying
    @Query("update Course c set c.status = 'deleted' where c.id = :id")
    void recycle(@Param("id") Long id);

}
