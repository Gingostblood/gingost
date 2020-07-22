package cn.gingost.jpa.domain;

import cn.gingost.jpa.common.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Lezzy
 * @description
 * @data 2020/7/21 22:57
 **/

@Data
@Table(name = "student")
@Entity
public class Student extends BaseEntity {

    @Column(name = "card")
    private String card;

    @Column(name = "age")
    private Integer age;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "t_id")
    @ToString.Include
    private Teacher teacher;

    @ManyToMany
    @JoinTable(name = "stu_course",joinColumns={@JoinColumn(name = "stu_id",referencedColumnName = "id")},inverseJoinColumns = {@JoinColumn(name = "c_id",referencedColumnName = "id")})
    private Set<Course> courses;
}
