package pro.kapok.coach.course.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pro.kapok.coach.course.model.Course;
import pro.kapok.coach.course.service.CourseService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * @author Will WM. Zhang
 * @since 2020-04-29 16:43
 */
@Controller
@RequestMapping("/course")
public class CourseEndpoint {

    private CourseService courseService;

    @Autowired
    public CourseEndpoint(CourseService courseService) {
        this.courseService = courseService;
    }


    /**
     * 创建
     *
     * @param course course
     * @return Course
     */
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Course create(@RequestBody Course course) {
        return this.courseService.create(course);
    }

    /**
     * 获取
     *
     * @param id id
     * @return Course
     */
    @GetMapping("/{id}")
    @ResponseBody
    public Course retrieve(@PathVariable("id") Long id) {
        return this.courseService.retrieve(id);
    }

    /**
     * 更新
     *
     * @param id     id
     * @param values values
     * @return Course
     */
    @PutMapping("/{id}")
    @ResponseBody
    public Course update(@PathVariable("id") Long id, @RequestBody Map<String, Object> values)
        throws InvocationTargetException, IllegalAccessException {
        return this.courseService.update(id, values);
    }

    /**
     * 删除
     *
     * @param id id
     * @return String
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        return this.courseService.delete(id);
    }

    /**
     * 回收
     *
     * @param id id
     * @return String
     */
    @PutMapping(value = "/{id}", headers = {"Action=recycle"})
    public String recycle(@PathVariable("id") Long id) {
        return this.courseService.recycle(id);
    }

    /**
     * 搜索
     *
     * @return List<Course>
     */
    @GetMapping
    @ResponseBody
    public List<Course> search() {
        return this.courseService.search();
    }

}
