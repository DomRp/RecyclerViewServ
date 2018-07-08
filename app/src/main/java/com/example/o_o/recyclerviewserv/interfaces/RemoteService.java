package com.example.o_o.recyclerviewserv.interfaces;

import com.example.o_o.recyclerviewserv.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface RemoteService {

    @Headers({"Accept: application/vnd.github.v3.full+json"})
    @GET("users")
    Call<List<User>> getUsers();
}
