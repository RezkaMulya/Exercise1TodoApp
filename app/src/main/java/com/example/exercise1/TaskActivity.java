package com.example.exercise1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TaskActivity extends AppCompatActivity {
    TextView accTask, accWaktu, accJenis;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        accTask = findViewById(R.id.edtampiltask);
        accJenis = findViewById(R.id.edtampiljenis);
        accWaktu = findViewById(R.id.edtampilwaktu);
        Bundle bundle = getIntent().getExtras();
        String accTask1 = bundle.getString("data5");
        String accJenis1 = bundle.getString("data6");
        String accWaktu1 = bundle.getString("data7");
        accTask.setText(accTask1);
        accJenis.setText(accJenis1);
        accWaktu.setText(accWaktu1);


    }
}
