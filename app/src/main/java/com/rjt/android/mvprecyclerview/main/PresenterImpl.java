package com.rjt.android.mvprecyclerview.main;

import android.content.Context;
import android.util.Log;

import com.rjt.android.mvprecyclerview.data.DataManager;
import com.rjt.android.mvprecyclerview.data.User;
import com.rjt.android.mvprecyclerview.data.UserDataSource;

import java.util.List;

public class PresenterImpl implements IPresenter, UserDataSource.DataListerner {
    private DataManager mDataManager;
    private MainActivity mainRef;
    public PresenterImpl(){
        mDataManager = new DataManager(this);
    }
    @Override
    public void onRequestUserData(String MyURL, Context context) {
        mDataManager.onRequestRemoteUserData(context, MyURL);

    }

    @Override
    public void setView(Context context) {
        mainRef = (MainActivity)context;
    }

    @Override
    public void onSuccess(List<User> users) {
        Log.i("presenterIm", "Presenter implementation onSuccess " + users.size());
        mainRef.loadUsers(users);
    }

    @Override
    public void onFailure(Throwable t) {

    }
}
