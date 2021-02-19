package com.recipesapp.recipes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class ShowRecipe extends AppCompatActivity {

    TextView ingText, methodText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_recipe);

        setTitle("How to make");

        ingText = findViewById(R.id.ing_show);
        methodText = findViewById(R.id.method_show);

        int ing = getIntent().getIntExtra("ing", 0);
        int method = getIntent().getIntExtra("method", 0);

        if (ing == 0 || method == 0){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            return;
        }
        ingText.setText(getStringFromRawRes(ing));
        methodText.setText(getStringFromRawRes(method));

    }

    @Nullable
    private String getStringFromRawRes(int rawRes) {

        InputStream inputStream;
        try {
            inputStream = getResources().openRawResource(rawRes);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            return null;
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        try {
            while ((length = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                inputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String resultString;
        try {
            resultString = byteArrayOutputStream.toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

        return resultString;
    }

}