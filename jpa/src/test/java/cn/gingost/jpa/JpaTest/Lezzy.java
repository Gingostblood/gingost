package cn.gingost.jpa.JpaTest;

import cn.gingost.jpa.Dto.TeacherRespDto;
import cn.gingost.jpa.domain.Teacher;
import cn.gingost.jpa.repository.CourseRepository;
import cn.gingost.jpa.repository.StudentRepository;
import cn.gingost.jpa.repository.TeacherRepository;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.query.spi.NativeQueryImplementor;
import org.hibernate.transform.Transformers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lezzy
 * @description
 * @data 2020/7/21 23:51
 **/

@SpringBootTest
public class Lezzy {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private EntityManager entityManager;

    @Test
    public void t1(){
        String likeName="党豪";
        StringBuilder sb=new StringBuilder();
        sb.append("select id teacherid,name teachername from teacher where ");
        //sb.append("  name like \"%"+likeName+"%\"");
        sb.append(" age=36");
        Query nativeQuery = entityManager.createNativeQuery(sb.toString());
        Query query = (Query)nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(TeacherRespDto.class));
        List resultList = query.getResultList();
        // List<Teacher> resultList = nativeQuery.getResultList();
//        for (Object[] obj:resultList){
//            System.out.println(Arrays.toString(obj));
//        }
        //System.out.println(resultList);
        System.out.println(resultList);
    }
}
