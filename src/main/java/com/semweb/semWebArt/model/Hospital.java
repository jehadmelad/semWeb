package com.semweb.semWebArt.model;

public class Hospital {

    private String name;
    private String people;
    private String sex;
    private String birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                ", people='" + people + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                '}';
    }
}
