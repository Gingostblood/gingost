package cn.gingost.jpa.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Lezzy
 * @description
 * @data 2020/7/21 23:00
 **/

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "is_del")
    private Boolean idDel=false;

    @Column(name = "name")
    private String name;
}
