package com.example.attendanceapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class sheetListActivity extends AppCompatActivity {
    private ListView sheetList;
    private ArrayAdapter adapter;
    private ArrayList<String> listItems=new ArrayList();
    private long cid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheet_list);

        cid=getIntent().getLongExtra("cid",-1);
        loadListItems();
        sheetList=findViewById(R.id.sheetList);
        adapter =new ArrayAdapter(this,R.layout.sheet_list,R.id.date_list_item,listItems);
        sheetList.setAdapter(adapter);

        sheetList.setOnItemClickListener((parent, view, position, id) -> openSheetActivity(position));
    }

    private void openSheetActivity(int position) {
        long[] idArray =getIntent().getLongArrayExtra("idArray");
        String[] nameArray = getIntent().getStringArrayExtra("nameArray");
        int[] rollArray=getIntent().getIntArrayExtra("rollArray");


        Intent intent=new Intent(this,sheetActivity.class);
        //intent.putExtra("cid",cid);
        intent.putExtra("idArray",idArray);
        intent.putExtra("rollArray",rollArray);
        intent.putExtra("nameArray",nameArray);
        intent.putExtra("month",listItems.get(position));

        startActivity(intent);
    }

    private void loadListItems() {
        Cursor cursor=new DbHelper(this).getDistinctMonths(cid);
        while (cursor.moveToNext()){
            String date=cursor.getString(cursor.getColumnIndex(DbHelper.DATE_KEY));
            listItems.add(date.substring(3));
        }
    }
}