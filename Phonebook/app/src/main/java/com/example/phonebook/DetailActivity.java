package com.example.phonebook;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("contact")) {
            Contact contact = (Contact) intent.getSerializableExtra("contact");
            // Hiển thị thông tin chi tiết
        }
    }
}

