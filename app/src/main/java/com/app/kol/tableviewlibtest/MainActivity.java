package com.app.kol.tableviewlibtest;

import androidx.appcompat.app.AppCompatActivity;
import ir.androidexception.datatable.DataTable;
import ir.androidexception.datatable.model.DataTableHeader;
import ir.androidexception.datatable.model.DataTableRow;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private DataTable dataTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataTable = findViewById(R.id.data_table);
        setUpDataTable();
    }

    private void setUpDataTable() {
        DataTableHeader header = new DataTableHeader.Builder()
                .item("Id", 1)
                .item("Name", 3)
                .item("Gender", 2)
                .item("Birth Date", 3)
                .build();
        ArrayList<DataTableRow> rows = new ArrayList<>();
        // define 200 fake rows for table
        for(int i=0;i<200;i++) {
            Random r = new Random();
            int random = r.nextInt(i+1);
            int randomDiscount = r.nextInt(20);
            long date = new Date().getTime() + random * 200;
            DataTableRow row = new DataTableRow.Builder()
                    .value( String.valueOf(i))
                    .value("Product #" + random)
                    .value((random%2) == 0?"M":"F")
                    .value(new Date(date).toString())
                    .build();
            rows.add(row);
        }

        dataTable.setTypeface(Typeface.SANS_SERIF);
        dataTable.setHeader(header);
        dataTable.setRows(rows);
        dataTable.inflate(this);
    }
}