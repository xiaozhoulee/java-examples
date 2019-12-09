package com.xiaozhoubg.domain;

import java.io.Serializable;

public class User implements Serializable {
    private String uuname;
    private String age;

    public String getUuname() {
        return uuname;
    }

    public void setUuname(String uuname) {
        this.uuname = uuname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuname='" + uuname + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
