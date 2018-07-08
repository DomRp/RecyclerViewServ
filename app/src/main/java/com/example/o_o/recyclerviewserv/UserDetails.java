package com.example.o_o.recyclerviewserv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.o_o.recyclerviewserv.model.User;

public class UserDetails extends AppCompatActivity {
    private TextView tvName;
    private EditText etPhone;
    private EditText etEmail;
    private TextView tvWebSide;

    private final String USER_DETAILS = "USER_DETAILS";
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        tvName = findViewById(R.id.tvName);
        etPhone = findViewById(R.id.tvPhone);
        etEmail = findViewById(R.id.etEmail);
        tvWebSide = findViewById(R.id.tvWebSide);

        if (getIntent() != null && getIntent().getExtras() != null){
            user = getIntent().getParcelableExtra(USER_DETAILS);

            if (user != null){
                tvName.setText(user.getName());
                etPhone.setText(user.getPhone());
                etEmail.setText(user.getEmail());
                tvWebSide.setText(user.getWebsite());
            }
        }
    }
}
