package cn.gingost.jpa.domain;

import cn.gingost.jpa.common.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Lezzy
 * @description
 * @data 2020/7/21 22:58
 **/

@Data
@Table(name = "teacher")
@Entity
public class Teacher extends BaseEntity {

    @Column(name = "age")
    private Integer age;

    @OneToMany(mappedBy = "teacher",fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private Set<Student> students;

}
