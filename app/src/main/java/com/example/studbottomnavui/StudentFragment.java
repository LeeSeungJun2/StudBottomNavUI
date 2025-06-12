package com.example.studbottomnavui;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentFragment extends Fragment {
    /*************************설계*********************************************/
    //DB 객체 저장을 위한 멤버필드 추가
    SQLiteDatabase sqLiteDatabase;
     //학생 목록 출력을 위한 ListView 멤버 필드 추가
    ListView listView;
     //질의 결과 저장을 위한 cursor 멤버필드 추가
     Cursor cursor;
     //ListView를 위한 adapter 멤버필드 추가
    SimpleCursorAdapter adapter;
     /**************************************************************************/
     // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StudentFragment() {
        // Required empty public constructor
    }

    public StudentFragment(SQLiteDatabase db) {
        sqLiteDatabase = db;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StudentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudentFragment newInstance(String param1, String param2) {
        StudentFragment fragment = new StudentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    //필요한 SQL 문
    // 모든 학생들의 정보로 검색하는 sql문
    //    sqlStatement = "SELECT * FROM STUDENT";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //StudentFragment의 레이아웃을 팽창하여 뷰를 생성
        String[] from = {"SNO", "SNAME", "YEAR", "DEPT"};
        int[] to = {R.id.tvSno, R.id.tvName, R.id.tvYear, R.id.tvDept};

        View view = inflater.inflate(R.layout.fragment_student, container, false);


        //학생 목록 출력을 위한 Listview를 인식하여 studListView 멤버필드에 저장
        listView = view.findViewById(R.id.studListView);
        //검색 SQL문을 작성하고 이 검색문을 실행하고 결과를 cursor에 저장
        String sqlStatement = "SELECT * FROM STUDENT";
        cursor = sqLiteDatabase.rawQuery(sqlStatement, null);
        //cursor를 이용하여 SimpleCursorAdapter를 생성하고 이를 studListView의  adapter로 설정
        adapter = new SimpleCursorAdapter(getContext(), R.layout.list_item, cursor, from, to, 0);
        listView.setAdapter(adapter);
        //studListView에 컨텍스트 메뉴를 등록 : 삭제/수정 기능 구현 – registerForContextMenu()
        registerForContextMenu(listView);
        return view;
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = new MenuInflater(v.getContext());
        inflater.inflate(R.menu.contextmenu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int menuId = item.getItemId();
        return super.onContextItemSelected(item);
    }
}










