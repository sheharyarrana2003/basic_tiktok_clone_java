package com.example.tiktokclone;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tiktokclone.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<model> arrayList=new ArrayList<>();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.getTheme().applyStyle(R.style.FullScreen,false);
        arrayList.add(new model("android.resource://" + getPackageName() + "/" + R.raw.a, R.drawable.profile, "sheharyar"));
        arrayList.add(new model("android.resource://" + getPackageName() + "/" + R.raw.b, R.drawable.profile, "ali"));
        arrayList.add(new model("android.resource://" + getPackageName() + "/" + R.raw.c, R.drawable.profile, "hammad"));
        arrayList.add(new model("android.resource://" + getPackageName() + "/" + R.raw.d, R.drawable.profile, "jawad"));
        arrayList.add(new model("android.resource://" + getPackageName() + "/" + R.raw.e, R.drawable.profile, "shariq"));
        adapter=new Adapter(MainActivity.this,arrayList);
        binding.videoPager.setAdapter(adapter);
    }
}