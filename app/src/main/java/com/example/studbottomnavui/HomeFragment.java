package com.example.studbottomnavui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    //학생정보를 DB에 Insert하기 위한 SQL문
    // 1. String sno: 학번 저장
    // 2. String sname: 이름 저장
    // 3. int year: 학년 저장
    // 4. String dept: 학과 저장
    // String SQLStatement = "INSERT INTO STUDENT VALUES (null, '" + sno + "', '" + sname + "'," + year + ",'" + dept + "');";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}