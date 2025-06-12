package com.example.studbottomnavui;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    //MyDBHelper 도우미와 SQLiteDatabase 객체를 저장하기 위한 멤버필드 추가
    MyDBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //MyDBHelper 객체를 생성하여 멤버필드에 저장
        dbHelper = new MyDBHelper(this);

        //데이타베이스 read/write 가능 모드로 오픈하여 멤버필드에 저장
        try {
            sqLiteDatabase = dbHelper.getWritableDatabase();
        } catch (SQLException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            sqLiteDatabase = dbHelper.getReadableDatabase();
        }

        //앱을 실행하면 [HomeFragment]를 로드하는 것이 기본 상태임
        loadFragment(new HomeFragment());

        //BottomNavigationView 객체를 인식하고 OnItemSelectedListener를
        //설정하고 메뉴를 선택하면 적정한 프래그먼트를 로드
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setLabelVisibilityMode(NavigationBarView.LABEL_VISIBILITY_AUTO);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Fragment fragment = null;
                if (id == R.id.nav_home) {
                    fragment = new HomeFragment();
                }
                else if (id == R.id.nav_insert) {
                //    fragment = new InsertFragment(sqLiteDatabase);
                }
                else if (id == R.id.nav_search) {
                //    fragment = new SearchFragment(sqLiteDatabase);
                }
                else if (id == R.id.nav_list) {
                    fragment = new StudentFragment(sqLiteDatabase);
                }
                return loadFragment(fragment);
            }
        });

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        else
            return false;
    }
}