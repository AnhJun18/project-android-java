package com.example.caculator;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBSanPham extends SQLiteOpenHelper {

    public DBSanPham(@Nullable Context context) {
        super(context, "dbSanPham", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql= "create table tbSanPham(masp text, tensp text, soluong text)";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public  void ThemDL(SanPham sp){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        String sql= "insert into tbSanPham values(?,?,?)";
        sqLiteDatabase.execSQL(sql,new String[]{sp.getMaSP(),sp.getTenSP(),sp.getSoluong()});
        hienThiDuLieu();
    }

    public ArrayList<SanPham> hienThiDuLieu(){
        ArrayList<SanPham> data = new ArrayList<>();
        String sql= " select * from tbSanPham";
        SQLiteDatabase sqLiteDatabase= getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do {
                SanPham sp = new SanPham();
                sp.setMaSP(cursor.getString(0));
                sp.setTenSP(cursor.getString(1));
                sp.setSoluong(cursor.getString(2));
                data.add(sp);
             }
            while (cursor.moveToNext());
        }
        return data;
    }

    public  void XoaDL(SanPham sp){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql ="delete from tbSanPham where masp=?";
        sqLiteDatabase.execSQL(sql,new String[]{sp.getMaSP()});
    }

    public  void SuaDL(SanPham sp){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql ="update tbSanPham set tensp=? ,soluong=? where masp=?";
        sqLiteDatabase.execSQL(sql,new String[]{sp.getTenSP(),sp.getSoluong(),sp.getMaSP()});
    }

}
