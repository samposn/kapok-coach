package pro.kapok.coach.course.service;

import pro.kapok.coach.course.model.Course;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * @author Will WM. Zhang
 * @since 2020-04-29 16:41
 */
public interface CourseService {

    /**
     * 创建
     *
     * @param course course
     * @return Course
     */
    Course create(Course course);

    /**
     * 获取
     *
     * @param id id
     * @return Course
     */
    Course retrieve(Long id);

    /**
     * 更新
     *
     * @param id     id
     * @param values values
     * @return Course
     */
    Course update(Long id, Map<String, Object> values)
        throws InvocationTargetException, IllegalAccessException;

    /**
     * 删除
     *
     * @param id id
     * @return String
     */
    String delete(Long id);

    /**
     * 回收
     *
     * @param id id
     * @return String
     */
    String recycle(Long id);

    /**
     * 搜索
     *
     * @return List\<Course\>
     */
    List<Course> search();

}
