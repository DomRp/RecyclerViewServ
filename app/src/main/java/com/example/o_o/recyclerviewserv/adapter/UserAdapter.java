package com.example.o_o.recyclerviewserv.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.o_o.recyclerviewserv.R;
import com.example.o_o.recyclerviewserv.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);

        holder.tvUserName.setText(user.getName());
        holder.tvPhone.setText(user.getPhone());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        public TextView tvUserName;
        public TextView tvPhone;

        public UserViewHolder (View view){
            super(view);

            tvUserName = view.findViewById(R.id.tvUserName);
            tvPhone = view.findViewById(R.id.tvPhone);
        }
    }

    public UserAdapter(List<User> userList){
        this.userList = userList;
    }

}
