package com.yjc.www.po;

public class Dragon {
    private Integer id;
    private String type;
    private String name;
    private String age;
    private String statue;
    private Integer exhibitionHallId;

    public Dragon(Integer id, String type, String name, String age, String statue, Integer exhibitionHallId) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.age = age;
        this.statue = statue;
        this.exhibitionHallId = exhibitionHallId;
    }

    public Dragon(Integer id, String type, String name, String age, String statue) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.age = age;
        this.statue = statue;
    }

    public Dragon(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public Integer getExhibitionHallId() {
        return exhibitionHallId;
    }

    public void setExhibitionHallId(Integer exhibitionHallId) {
        this.exhibitionHallId = exhibitionHallId;
    }

    @Override
    public String toString() {
        return "dragon{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", statue='" + statue + '\'' +
                ", exhibitionHallId=" + exhibitionHallId +
                '}';
    }
}
