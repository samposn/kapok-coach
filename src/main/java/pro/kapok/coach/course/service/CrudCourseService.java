package pro.kapok.coach.course.service;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.kapok.coach.course.model.Course;
import pro.kapok.coach.course.repository.CourseRepository;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Will WM. Zhang
 * @since 2020-04-29 16:41
 */
@Service
@Transactional(readOnly = true)
public class CrudCourseService implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CrudCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public Course create(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    public Course retrieve(Long id) {
        return this.courseRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Course update(Long id, Map<String, Object> values)
        throws InvocationTargetException, IllegalAccessException {
        Optional<Course> opt = courseRepository.findById(id);
        if (opt.isPresent()) {
            Course course = opt.get();
            for (String key : values.keySet()) {
                BeanUtils.setProperty(course, key, values.get(key));
            }
            return course;
        }
        return null;
    }

    @Override
    @Transactional
    public String delete(Long id) {
        this.courseRepository.deleteById(id);
        return "{\"Status\":\"OK\"}";
    }

    @Override
    @Transactional
    public String recycle(Long id) {
        this.courseRepository.recycle(id);
        return "{\"Status\":\"OK\"}";
    }

    @Override
    public List<Course> search() {
        return this.courseRepository.findAll();
    }

}
