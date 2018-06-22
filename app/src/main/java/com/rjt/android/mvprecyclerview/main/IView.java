package com.rjt.android.mvprecyclerview.main;

import android.content.Context;

import com.rjt.android.mvprecyclerview.data.User;

import java.util.List;

public interface IView {
    void setPresenter(Context context);
    void loadUsers(List<User> users);
}
