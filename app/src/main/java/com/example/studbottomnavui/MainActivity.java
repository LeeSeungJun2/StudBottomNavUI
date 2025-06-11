package com.example.studbottomnavui;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //MyDBHelper 도우미와 SQLiteDatabase 객체를 저장하기 위한 멤버필드 추가

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

        //데이타베이스 read/write 가능 모드로 오픈하여 멤버필드에 저장

        //앱을 실행하면 [HomeFragment]를 로드하는 것이 기본 상태임

        //BottomNavigationView 객체를 인식하고 OnItemSelectedListener를
        //설정하고 메뉴를 선택하면 적정한 프래그먼트를 로드

    }
}