package com.example.crud.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbContactos extends DbHelper{

    Context context;
    public DbContactos(@Nullable Context context) {
        super(context);
        this.context = context;

    }
    public long insertarContacto(String nombre, String telefono, String correo_electronico){

        long id = 0;

        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("telefono", telefono);
            values.put("correo_electronico", correo_electronico);

            id = db.insert(DbHelper.getTableContactos(), null, values);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return id;
    }
}