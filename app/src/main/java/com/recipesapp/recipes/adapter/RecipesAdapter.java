package com.recipesapp.recipes.adapter;

import android.content.ContentProviderClient;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recipesapp.recipes.R;
import com.recipesapp.recipes.model.RecipesModel;

import java.util.ArrayList;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipesViewHolder> {

    ArrayList<RecipesModel> list = new ArrayList<>();
    RecipesAdapter.OnItemClickListener listener;

    public RecipesAdapter(ArrayList<RecipesModel> list){
        this.list = list;
    }

    @NonNull
    @Override
    public RecipesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipes_layout, parent, false);
        return new RecipesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesViewHolder holder, int position) {
        RecipesModel model = list.get(position);
        holder.imageView.setImageResource(model.getImage_id());
        holder.name.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecipesViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView imageView;

        public RecipesViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.recipename);
            imageView = itemView.findViewById(R.id.recipeimg);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (position != -1 && listener != null) {

                        listener.onItemClick(position);

                    }
                }
            });
        }
    }
    public interface OnItemClickListener {
        void onItemClick(int position);

    }

    public void setOnItemClickListener(RecipesAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

}
