package com.example.studbottomnavui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SearchFragment extends Fragment {

    //DB 객체를 저장하기 위한 멤버필드 추가
    //DB 검색 결과 저장을 위한 Cursor 멤버 필드 추가

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

        //SearchFragment의 레이아웃을 팽창하여 뷰를 생성

        //view에서 이름과 학과를 입력하기 위한 EditText를 인식하여 저장
        //view에서 ListView를 인식하여 저장
        //각각 etSname, etDept, listView 참조변수에 저장

        //[검색하기-btnSearch] 버튼을 인식하고 OnClickListener 장착
        //[검색하기] 버튼을 클릭하면
        //이름 또는 학과 정보를 바탕으로 검색문을 작성하여 이를 실행하고 실행 결과를 cursor 멤버 필드에 저장

        //cursor를 이용하여 SimpleCursorAdapter를 생성하고
        //이 SimpleCursorAdapter를 listView의  adapter로 설정하면 검색결과 listView에 출력됨
    }
}