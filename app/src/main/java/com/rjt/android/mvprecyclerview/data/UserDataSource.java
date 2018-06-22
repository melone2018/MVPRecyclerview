package com.rjt.android.mvprecyclerview.data;

import android.content.Context;

import java.util.List;

public interface UserDataSource {
    void onRequestRemoteUserData(Context context, String url);
    interface DataListerner {
        void onSuccess(List<User> users);
        void onFailure(Throwable t);
    }
}
