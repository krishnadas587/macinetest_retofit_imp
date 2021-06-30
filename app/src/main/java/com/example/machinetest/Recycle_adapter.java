package com.example.machinetest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Recycle_adapter extends RecyclerView.Adapter<Recycle_adapter.Viewholder> {
    List<model_user> datas;
    Context ctx;

    public Recycle_adapter(List<model_user> datas, Context ctx) {
        this.datas = datas;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public Recycle_adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(ctx,R.layout.recycle_view_design_user,null);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recycle_adapter.Viewholder holder, int position) {
        System.out.println(datas.get(position).getAvatar());
        holder.name.setText(datas.get(position).getFirst_name()+datas.get(position).getLast_name());
        holder.email.setText(datas.get(position).getEmail());
        Glide.with(ctx)
                .load(datas.get(position).getAvatar())
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name,email;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imageView);
            name=itemView.findViewById(R.id.name_hol);
            email=itemView.findViewById(R.id.email_hol);
        }
    }
}
