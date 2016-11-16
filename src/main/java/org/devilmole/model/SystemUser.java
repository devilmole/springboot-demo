package org.devilmole.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class SystemUser implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    private Long id;
    private String name;
    private int age;

    public SystemUser(){
        super();
    }
    public SystemUser(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
