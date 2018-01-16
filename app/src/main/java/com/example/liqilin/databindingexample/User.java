package com.example.liqilin.databindingexample;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqilin on 2017/12/27.
 */

public class User extends BaseObservable {
    public String firstName;
    public String lastName;
    public int age;
    public String uri;

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    public static User getOneUser(Context context) {
        User user = new User();
        user.firstName = "Hello";
        user.lastName = "World";
        user.age = 20;
        user.uri = "android.resource://" + context.getPackageName() + "/" + R.drawable.award_icon_test_2;
        return user;
    }

    public static User getUser(String firstName, String lastName, int age) {
        User user = new User();
        user.firstName = firstName;
        user.lastName = lastName;
        user.age = age;
        return user;
    }

    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(getUser("Kevin", "Wang", 20));
        users.add(getUser("Charles", "Lee", 30));
        return users;
    }
}
