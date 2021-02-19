package com.recipesapp.recipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.Toast;

import com.recipesapp.recipes.adapter.RecipesAdapter;
import com.recipesapp.recipes.model.RecipesModel;

import java.util.ArrayList;

public class RecipesList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes_list);
        loadData();
    }


    private void loadData(){

        ArrayList<RecipesModel> recipes = new ArrayList<>();
        RecipesModel recipe = new RecipesModel();
        recipe.setImage_id(R.drawable.rice_noodles);
        recipe.setName("One Pot Thai-Style Rice Noodles");
        recipe.setIngredients(R.raw.rice_noodles_ing);
        recipe.setMethod(R.raw.rice_noodles_method);

        RecipesModel recipe2 = new RecipesModel();
        recipe2.setImage_id(R.drawable.spatchcock_chicken);
        recipe2.setName("Spatchcock Chicken");
        recipe2.setIngredients(R.raw.spatchcock_chicken_ing);
        recipe2.setMethod(R.raw.spatchcock_chicken_method);


        RecipesModel recipe3 = new RecipesModel();
        recipe3.setImage_id(R.drawable.curry_chicken);
        recipe3.setName("Five-Ingredient Red Curry Chicken");
        recipe3.setIngredients(R.raw.curry_chicken_ing);
        recipe3.setMethod(R.raw.curry_chicken_method);

        RecipesModel recipe4 = new RecipesModel();
        recipe4.setImage_id(R.drawable.lasagna_flatbread);
        recipe4.setName("Lasagna Flatbread");
        recipe4.setIngredients(R.raw.lasagna_flatbread_ing);
        recipe4.setMethod(R.raw.lasagna_flatbread_method);

        RecipesModel recipe5 = new RecipesModel();
        recipe5.setImage_id(R.drawable.macroni_cheese);
        recipe5.setName("Simple Macaroni and Cheese");
        recipe5.setIngredients(R.raw.macroni_chees_ing);
        recipe5.setMethod(R.raw.macroni_cheese_method);

        RecipesModel recipe6 = new RecipesModel();
        recipe6.setImage_id(R.drawable.sugar_chicken_thighs);
        recipe6.setName("Garlic-Brown Sugar Chicken Thighs");
        recipe6.setIngredients(R.raw.chicken_thighs_ing);
        recipe6.setMethod(R.raw.chicken_thighs_method);

        RecipesModel recipe7 = new RecipesModel();
        recipe7.setImage_id(R.drawable.been_rice);
        recipe7.setName("Authentic New Orleans Red Beans and Rice");
        recipe7.setIngredients(R.raw.beans_rice_ing);
        recipe7.setMethod(R.raw.beans_rice_method);

        RecipesModel recipe8 = new RecipesModel();
        recipe8.setImage_id(R.drawable.salmon_patties);
        recipe8.setName("Potato Salmon Patties");
        recipe8.setIngredients(R.raw.salmon_patties_ing);
        recipe8.setMethod(R.raw.salmon_patties_method);


        RecipesModel recipe9 = new RecipesModel();
        recipe9.setImage_id(R.drawable.lentel_stew);
        recipe9.setName("Slow Cooker Mediterranean Lentil Stew");
        recipe9.setIngredients(R.raw.lental_stew_ing);
        recipe9.setMethod(R.raw.lental_stew_method);


        RecipesModel recipe10 = new RecipesModel();
        recipe10.setImage_id(R.drawable.fluffy_pancakes);
        recipe10.setName("Fluffy Flapjack Pancakes");
        recipe10.setIngredients(R.raw.fluffy_pancake_ing);
        recipe10.setMethod(R.raw.fluffy_pancake_method);


        RecipesModel recipe11 = new RecipesModel();
        recipe11.setImage_id(R.drawable.crumb_muffins);
        recipe11.setName("Banana Crumb Muffins");
        recipe11.setIngredients(R.raw.crumb_muffins_ing);
        recipe11.setMethod(R.raw.crumb_muffins_method);


        RecipesModel recipe12 = new RecipesModel();
        recipe12.setImage_id(R.drawable.pancackes);
        recipe12.setName("Good Old Fashioned Pancakes");
        recipe12.setIngredients(R.raw.old_pancake_ing);
        recipe12.setMethod(R.raw.old_pancake_method);


        recipes.add(recipe);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe4);
        recipes.add(recipe5);
        recipes.add(recipe6);
        recipes.add(recipe7);
        recipes.add(recipe8);
        recipes.add(recipe9);
        recipes.add(recipe10);
        recipes.add(recipe11);
        recipes.add(recipe12);

        RecyclerView RecipeRV  = findViewById(R.id.recipesRV);

        RecipesAdapter adapter = new RecipesAdapter(recipes);

        RecipeRV.setAdapter(adapter);
        RecipeRV.setLayoutManager(new GridLayoutManager(this, 2)); // the 2 is the number of grid layout
        RecipeRV.setHasFixedSize(true);

        adapter.setOnItemClickListener(new RecipesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(50);// the 50 is the time in millis for which viberation will play
                }


                Intent it = new Intent(RecipesList.this, ShowRecipe.class);
                it.putExtra("ing", recipes.get(position).getIngredients());
                it.putExtra("method", recipes.get(position).getMethod());
                startActivity(it);
            }
        });

    }
}