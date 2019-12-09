package com.xiaozhoubg.domain;

import java.io.Serializable;

public class User2 implements Serializable {
    private String uuname2;
    private String age;

    public String getUuname2() {
        return uuname2;
    }

    public void setUuname2(String uuname2) {
        this.uuname2 = uuname2;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User2{" +
                "uuname2='" + uuname2 + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
