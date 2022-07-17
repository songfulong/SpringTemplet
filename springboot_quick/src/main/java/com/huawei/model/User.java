package com.huawei.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class User {
    private String name = null;
    private Integer age = null;
    private List<String> friends = new ArrayList<>();
    private List<Date> dates = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName()) && Objects.equals(getAge(), user.getAge()) && Objects.equals(getFriends(), user.getFriends()) && Objects.equals(getDates(), user.getDates());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getFriends(), getDates());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friends=" + friends +
                ", dates=" + dates +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }
}
