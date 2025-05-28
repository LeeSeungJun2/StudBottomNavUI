package com.example.studbottomnavui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SearchFragment extends Fragment {

    public SearchFragment() {
        // Required empty public constructor
    }


    //필요한 SQL 문
    // 1. 학과 정보로 검색하는 sql문
    //    sqlStatement = "SELECT * FROM STUDENT where DEPT = '" + dept + "'";
    // 2. 이름 정보로 검색하는 sql문
    //    sqlStatement = "SELECT * FROM STUDENT where SNAME = '" + name + "'";
    // 3. 이름과 학과 정보로 검색하는 SQL문
    //    sqlStatement = "SELECT * FROM STUDENT where SNAME = '" + name + "' AND DEPT = '" + dept + "'";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }
}