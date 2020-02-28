package com.wd.room;

import androidx.databinding.BaseObservable;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class User extends BaseObservable {

    @Ignore
    public User(){}

    public User(String name, int age, String sex, String desc) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.desc = desc;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public int age;
    public String sex;
    public String desc;
}
