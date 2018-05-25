package com.example.trang.settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.Locale;

public class ManHinhLanguage extends AppCompatActivity {
    ImageView imgvietnam, imganh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_language);

        imgvietnam=(ImageView)findViewById(R.id.imgvietnam);
        imganh=(ImageView)findViewById(R.id.imganh);

        imgvietnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLanguage("vi");
            }
        });
        imganh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLanguage("en");
            }
        });


    }


    public void showLanguage(String language){
        Locale locale = new Locale(language); //truyền vào ngôn ngữ
        Locale.setDefault(locale);
        Configuration config= new Configuration();//cấu tạo hệ thống
        config.locale=locale; //cấu hình lại ngôn ngữ
        getBaseContext().getResources().updateConfiguration(
                config,
                getBaseContext().getResources().getDisplayMetrics()
        );//cập nhập lại result (cập nhập 2 string)

        SharedPreferences sp = getSharedPreferences("data",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("key_language", language);
        editor.commit();
        Intent intent = new Intent(ManHinhLanguage.this, MainActivity.class);
        startActivity(intent);//load lại view;

    }

    }

