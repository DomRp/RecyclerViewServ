package com.example.o_o.recyclerviewserv.helper;

import android.os.AsyncTask;

import com.example.o_o.recyclerviewserv.interfaces.RemoteService;
import com.example.o_o.recyclerviewserv.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InfoHelper {

    private Retrofit retrofit;
    private RemoteService service;

    public InfoHelper() {

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .build();

        service = retrofit.create(RemoteService.class);
    }


    public List<User> getUsers(){
        List<User> userList = new ArrayList<>();

        try {
            RestAsync async = new RestAsync(service);

            userList = async.execute().get();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        catch (ExecutionException ex) {
            ex.printStackTrace();
        }

        return userList;
    }


    static class RestAsync extends AsyncTask<Void, Void, List<User>> {

        private RemoteService service;

        public RestAsync(RemoteService service) {
            this.service = service;
        }

        @Override
        protected List<User> doInBackground(Void... strings) {
            List<User> userList = new ArrayList<>();

            try {
                userList = service.getUsers().execute().body();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return userList;
        }
    }
}
