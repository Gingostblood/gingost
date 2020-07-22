package cn.gingost.jpa.repository;

import cn.gingost.jpa.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Lezzy
 * @description
 * @data 2020/7/21 23:46
 **/
public interface CourseRepository extends JpaRepository<Course,Integer>, JpaSpecificationExecutor<Course> {
}
