package com.example.sintrabel.activitiy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.sintrabel.R;
import com.example.sintrabel.activitiy.BookmarkFolderActivity;
import com.example.sintrabel.activitiy.SearchActivity;

public class MainActivity extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);
    }

    public void clickSearch(View v){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public void clickBookmarkFolder(View v){
        Intent intent = new Intent(this,
                BookmarkFolderActivity.class);
        startActivity(intent);
    }

}