package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class IsiTaskActivity extends AppCompatActivity {
    TextView namaText, passwordText;
    EditText edtTask, edtJenisTask, edtTimeTask;
    FloatingActionButton fab;
    String task, jenistask, timetask;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //method untuk menampilkan menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        task = edtTask.getText().toString();
        jenistask = edtJenisTask.getText().toString();
        timetask = edtTimeTask.getText().toString();

        edtTask = findViewById(R.id.edTask);
        edtJenisTask = findViewById(R.id.edJenisTask);
        edtTimeTask = findViewById(R.id.edWaktuTask);

        if (item.getItemId() == R.id.mnSubmit) {


            if (edtTask.getText().toString().isEmpty()) {
                edtTask.setError("Nama Task");
            } else if (edtJenisTask.getText().toString().isEmpty()) {
                edtJenisTask.setError("Jenis Task");
            } else if (edtTimeTask.getText().toString().isEmpty()) {
                edtTimeTask.setError("Waktu Task");
            } else {

                Toast.makeText(getApplicationContext(), "Task Tersimpan...", Toast.LENGTH_SHORT).show();
                Bundle b = new Bundle();
                //key parsing data dimasukkan kedalam bundle
                b.putString("data5", task);
                b.putString("data7", timetask);
                b.putString("data6", jenistask);
                //method untuk kembali ke activity main
                Intent inten = new Intent(getApplicationContext(), TaskActivity.class);
                inten.putExtras(b);
                startActivity(inten);
            }
        }else if (item.getItemId() == R.id.mnLogOut) {
            //method untuk memanggil activity "DaftarActivity"
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isitask);

        namaText = findViewById(R.id.tf_nama);
        Bundle bundle = getIntent().getExtras();
        String nama = bundle.getString("data1");
        namaText.setText(nama);

        edtTask = findViewById(R.id.edTask);
        edtJenisTask = findViewById(R.id.edJenisTask);
        edtTimeTask = findViewById(R.id.edWaktuTask);

        fab = findViewById(R.id.fabSimpan);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task = edtTask.getText().toString();
                jenistask = edtJenisTask.getText().toString();
                timetask = edtTimeTask.getText().toString();

                if (edtTask.getText().toString().isEmpty()) {
                    edtTask.setError("Nama Task!");
                }else if (edtTimeTask.getText().toString().isEmpty()) {
                    edtTimeTask.setError("Waktu Task!");
                }else if (edtJenisTask.getText().toString().isEmpty()) {
                    edtJenisTask.setError("Jenis Task!");
                }else{
                    Snackbar.make(v, "Task Tersimpan", Snackbar.LENGTH_SHORT).show();

                    Bundle bundleTask = new Bundle();
                    //key parsing data dimasukkan kedalam bundle
                    bundleTask.putString("data5", task);
                    bundleTask.putString("data6", jenistask);
                    bundleTask.putString("data7", timetask);
                    //method untuk kembali ke activity main
                    Intent in = new Intent(getApplicationContext(), TaskActivity.class);
                    in.putExtras(bundleTask);
                    startActivity(in);
                }
            }
        });
    }
}


