package com.bkb.userbase.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author bkb
 * @since 2018-07-18
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String passpord;
    private Integer age;
    private String sex;
    private Integer score;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasspord() {
        return passpord;
    }

    public void setPasspord(String passpord) {
        this.passpord = passpord;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
        ", id=" + id +
        ", name=" + name +
        ", passpord=" + passpord +
        ", age=" + age +
        ", sex=" + sex +
        ", score=" + score +
        "}";
    }
}
