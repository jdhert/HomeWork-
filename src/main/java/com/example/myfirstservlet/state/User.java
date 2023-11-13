package com.example.myfirstservlet.state;

public class User {
    String name;
    String city;
    int count;


    @Override
    public String toString() {
        return "이름='" + name + '\'' +
                ", 도시='" + city + '\'' +
                ", 방문횟수=" + count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
