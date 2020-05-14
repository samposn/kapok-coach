package pro.kapok.coach.course.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pro.kapok.coach.course.model.Course;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Will WM. Zhang
 * @since 2020-04-30 16:56
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @Test
    public void testCreate() {
        Course course = new Course();

        courseService.create(course);

        Assertions.assertEquals(6L, course.getId());
    }

    @Test
    public void testRetrieve() {
        Course course = courseService.retrieve(1L);

        Assertions.assertEquals("title1", course.getTitle());
        Assertions.assertEquals("content1", course.getContent());
        Assertions.assertEquals("normal", course.getStatus());
    }

    @Test
    public void testUpdate() throws InvocationTargetException, IllegalAccessException {
        Map<String, Object> values = new HashMap<>();
        values.put("title", "title updated");
        values.put("content", "content updated");
        values.put("status", "deleted");

        Course course = courseService.update(2L, values);

        Assertions.assertEquals("title updated", course.getTitle());
        Assertions.assertEquals("content updated", course.getContent());
        Assertions.assertEquals("deleted", course.getStatus());
    }

    @Test
    public void testDelete() {
        courseService.delete(3L);

        Course course = courseService.retrieve(3L);

        Assertions.assertNull(course);
    }

    @Test
    public void testRecycle() {
        courseService.recycle(4L);

        Course course = courseService.retrieve(4L);

        Assertions.assertEquals("deleted", course.getStatus());
    }

    @Test
    public void testSearch() {
        List<Course> courses = courseService.search();

        Assertions.assertEquals(5, courses.size());
    }
}
