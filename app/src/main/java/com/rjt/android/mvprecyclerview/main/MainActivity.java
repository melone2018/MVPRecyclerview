package com.rjt.android.mvprecyclerview.main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rjt.android.mvprecyclerview.MyAdapter;
import com.rjt.android.mvprecyclerview.R;
import com.rjt.android.mvprecyclerview.data.User;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView{
    public final static String MYURL = "http://microblogging.wingnity.com/JSONParsingTutorial/jsonActors";
    private RecyclerView mRecyclerView;
    private PresenterImpl mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new PresenterImpl();
        mPresenter.setView(this);
        mPresenter.onRequestUserData(MYURL, this);
    }

    @Override
    public void setPresenter(Context context) {

    }

    @Override
    public void loadUsers(List<User> users) {
        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(users, this);
        mRecyclerView.setAdapter(adapter);
    }
}
