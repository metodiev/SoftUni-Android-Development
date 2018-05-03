package com.example.miroslav.practice_softuni;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends  RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<Users> usersListViewHolder;

    public UserAdapter(List<Users> usersListViewHolder) {
        this.usersListViewHolder = usersListViewHolder;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View userView = inflater.inflate(R.layout.item_users, parent, false);
        ViewHolder viewHolder = new ViewHolder(userView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
            Users users = usersListViewHolder.get(position);

            //set item views based ot your views and data model
        TextView textView = holder.textView;
        textView.setText(users.getUsername());
    }

    @Override
    public int getItemCount() {
        return usersListViewHolder.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView ;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.txt_item_users);
        }
        // Stores the itemView in a public final member variable that can be used
        // to access the context from any ViewHolder instance.


    }
}
