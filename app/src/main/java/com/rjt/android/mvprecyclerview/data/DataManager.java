package com.rjt.android.mvprecyclerview.data;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.rjt.android.mvprecyclerview.main.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataManager implements UserDataSource{
    public List<User> getUsers() {

        return mUsers;
    }

    public DataManager(DataListerner presenter){
        this.mPresenter = presenter;
    }
    private DataListerner mPresenter;
    private List<User> mUsers;
    @Override
    public void onRequestRemoteUserData(Context context, String url) {
        Log.i("arr", "Making network Request");
        mUsers = new ArrayList<>();
        RequestQueue mRequestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest myJasonObjectReq = new JsonObjectRequest(Request.Method.GET, MainActivity.MYURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray users = response.getJSONArray("actors");
                    int arrLen = users.length();
                    for(int i = 0; i < arrLen; i++){
                        JSONObject user = (JSONObject) users.get(i);
                        String name = user.getString("name");
                        String imgUrl = user.getString("image");
                        Log.i("arr", name + " " + imgUrl);
                        mUsers.add(new User(name, imgUrl));
                    }
                    mPresenter.onSuccess(mUsers);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error1", error.getMessage());
            }
        });
        mRequestQueue.add(myJasonObjectReq);
    }
}
