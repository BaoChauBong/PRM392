package com.example.demorecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Chapter> list = new ArrayList<>();
        Chapter c1 = new Chapter("Chapter One", "Overview android architextureOverview android architexturOverview android architextureOverview android architexturee", R.drawable.android_image_1);
        Chapter c2 = new Chapter("Chapter Two", "Android Layout", R.drawable.android_image_2);
        Chapter c3 = new Chapter("Chapter Three", "Android Intent", R.drawable.android_image_3);
        Chapter c4 = new Chapter("Chapter Four", "Android Activity", R.drawable.android_image_4);
        Chapter c5 = new Chapter("Chapter Five", "Android Recycler View", R.drawable.android_image_5);

        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);

        ChapterAdapter adapter = new ChapterAdapter(list);
        RecyclerView rec = findViewById(R.id.rec_chapters);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);
        rec.setLayoutManager(layout);
        rec.setAdapter(adapter);
    }
}