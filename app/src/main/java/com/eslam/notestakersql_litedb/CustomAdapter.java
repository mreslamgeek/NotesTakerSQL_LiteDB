package com.eslam.notestakersql_litedb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private final Context context;
    private final ArrayList note_id;
    private final ArrayList note_title;
    private final ArrayList note_description;

    public CustomAdapter(Context context,
                         ArrayList note_id,
                         ArrayList note_title,
                         ArrayList note_description) {
        this.context = context;
        this.note_id = note_id;
        this.note_title = note_title;
        this.note_description = note_description;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_note, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.note_id_txt.setText(String.valueOf(note_id.get(position)));
        holder.note_title_txt.setText(String.valueOf(note_title.get(position)));
        holder.note_description_txt.setText(String.valueOf(note_description.get(position)));

    }

    @Override
    public int getItemCount() {
        return note_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView note_id_txt, note_title_txt, note_description_txt;

        public MyViewHolder(@NonNull View view) {
            super(view);
            note_id_txt = view.findViewById(R.id.note_id_txt);
            note_title_txt = view.findViewById(R.id.note_tilte_txt);
            note_description_txt = view.findViewById(R.id.note_description_txt);
        }
    }
}
