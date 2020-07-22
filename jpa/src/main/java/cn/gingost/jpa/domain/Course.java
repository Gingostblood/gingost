package cn.gingost.jpa.domain;

import cn.gingost.jpa.common.BaseEntity;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Lezzy
 * @description
 * @data 2020/7/21 22:58
 **/

@Data
@Entity
@Table(name = "course")
@Where(clause = "is_del=0")
public class Course extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToMany(mappedBy = "courses")
    @ToString.Exclude
    private Set<Student> students;
}
