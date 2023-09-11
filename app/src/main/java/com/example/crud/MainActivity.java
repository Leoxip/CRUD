package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.crud.db.DbHelper;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCrear = findViewById(R.id.btnCrear);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DbHelper dbHelper = new DbHelper(MainActivity.this);
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    if (db != null) {
                        Toast.makeText(MainActivity.this, "Base de Datos Creada", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Error al crear la base de datos", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error al abrir la base de datos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menuNuevo:
                nuevoRegistro();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void nuevoRegistro() {
        Intent intent = new Intent(this, NuevoActivity.class);
        startActivity(intent);
    }
}