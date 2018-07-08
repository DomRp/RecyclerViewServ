package com.example.o_o.recyclerviewserv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.o_o.recyclerviewserv.adapter.UserAdapter;
import com.example.o_o.recyclerviewserv.helper.InfoHelper;
import com.example.o_o.recyclerviewserv.interfaces.ClickListener;
import com.example.o_o.recyclerviewserv.listener.RecyclerTouchListener;
import com.example.o_o.recyclerviewserv.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<User> userList;
    private RecyclerView rvUser;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            final InfoHelper ih = new InfoHelper();


            rvUser = findViewById(R.id.rvUser);

            adapter = new UserAdapter(ih.getUsers());

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

            rvUser.setLayoutManager(layoutManager);
            rvUser.setItemAnimator(new DefaultItemAnimator());
            rvUser.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
            rvUser.setAdapter(adapter);

            rvUser.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), rvUser, new ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    User user = ih.getUsers().get(position);

                    Intent intent = new Intent(MainActivity.this, UserDetails.class);

                    intent.putExtra("USER_DETAILS", user);

                    startActivity(intent);
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));
    }
}
