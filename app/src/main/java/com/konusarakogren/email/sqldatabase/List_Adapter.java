package com.konusarakogren.email.sqldatabase;




import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class List_Adapter extends RecyclerView.Adapter<List_Adapter.ViewHolder> {


    private Context cont;
    List<String> name;
    List<String> surname;
    List<String> like_count;

    public List_Adapter() {
    }

    @NonNull
    @Override
    public List_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.user_recycler_item, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull List_Adapter.ViewHolder holder, int position) {

        holder.like_count_txt.setText("Like: "+like_count.get(position));
        holder.name_txt.setText(name.get(position));
        holder.surname_txt.setText(surname.get(position));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public List_Adapter(Context cont, List<String> name, List<String> surname, List<String> like_count) {
        this.cont = cont;
        this.name = name;
        this.surname = surname;
        this.like_count = like_count;
    }


     class ViewHolder extends RecyclerView.ViewHolder {
        TextView name_txt, surname_txt, like_count_txt;
         ViewHolder(View itemView) {
            super(itemView);
            name_txt = itemView.findViewById(R.id.user_item_name_text);
            surname_txt = itemView.findViewById(R.id.user_item_surname_text);
            like_count_txt = itemView.findViewById(R.id.user_item_like_text);
        }


    }
}



