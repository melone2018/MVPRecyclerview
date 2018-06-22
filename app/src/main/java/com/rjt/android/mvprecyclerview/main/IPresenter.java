package com.rjt.android.mvprecyclerview.main;

import android.content.Context;

public interface IPresenter {
    void onRequestUserData(String MyURL, Context context);
    void setView(Context context);
}
