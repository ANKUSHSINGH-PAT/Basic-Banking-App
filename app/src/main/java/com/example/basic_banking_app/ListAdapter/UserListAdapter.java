package com.example.basic_banking_app.ListAdapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basic_banking_app.Data.User;
import com.example.basic_banking_app.R;
import com.example.basic_banking_app.UI.UserData;
import com.example.basic_banking_app.UI.UsersList;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {
    private ArrayList<User> userArrayList;
    public UserListAdapter(Context context, ArrayList<User> list) {
         userArrayList=list;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName, userAccountBalance;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName=itemView.findViewById(R.id.username);
            userAccountBalance=itemView.findViewById((R.id.amount));
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from (viewGroup.getContext()).inflate(R.layout.activity_user_list_item, viewGroup, false);
        return new ViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.ViewHolder viewHolder, int position) {
           viewHolder.itemView.setTag(userArrayList.get(position));
           viewHolder.userName.setText(userArrayList.get(position).getName());
           viewHolder.userAccountBalance.setText(String.format("%d",userArrayList.get(position).getBalance()));
           viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent=new Intent(v.getContext(), UserData.class);
                   intent.putExtra("ACCOUNT_NO",userArrayList.get(position).getAccountNumber());
                   intent.putExtra("NAME",userArrayList.get(position).getName());
                   intent.putExtra("MOBILE_NO",userArrayList.get(position).getPhoneNo());
                   intent.putExtra("EMAIL",userArrayList.get(position).getEmail());
                   intent.putExtra("IFSC",userArrayList.get(position).getIfsc());
                   intent.putExtra("BALANCE",String.valueOf(userArrayList.get(position).getBalance()));
                   v.getContext().startActivity(intent);
               }
           });
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }


}
