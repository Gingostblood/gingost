package cn.gingost.jpa.repository;

import cn.gingost.jpa.domain.Course;
import cn.gingost.jpa.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Lezzy
 * @description
 * @data 2020/7/21 23:46
 **/
public interface TeacherRepository extends JpaRepository<Teacher,Integer>, JpaSpecificationExecutor<Teacher> {
}
