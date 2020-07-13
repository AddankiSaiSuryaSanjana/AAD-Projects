package com.sanjana.roomdatabase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    List<StudentEntity> list;

    public MyAdapter(Context context, List<StudentEntity> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_design, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.n.setText(list.get(position).getName());
        holder.r.setText(list.get(position).getRollNumber());
        holder.d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //MainActivity.database.studentDAO().deleteData(list.get(position));
                MainActivity.viewModel.delete(list.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView n, r, e, d;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            n = itemView.findViewById(R.id.row_name);
            r = itemView.findViewById(R.id.row_rollno);
            e = itemView.findViewById(R.id.row_edit);
            d = itemView.findViewById(R.id.row_delete);
            e.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String nn = n.getText().toString();
                    String rr = r.getText().toString();
                    Intent intent = new Intent(context, UpdateActivity.class);
                    intent.putExtra("name", nn);
                    intent.putExtra("roll", rr);
                    context.startActivity(intent);
                }
            });

        }
    }
}
