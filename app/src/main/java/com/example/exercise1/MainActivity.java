package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;

    EditText ednama,edpassword;

    String nama, password;

    TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menghubungkan variabel btnLogin dengan componen button pada Layout
        btnLogin=findViewById(R.id.buttonSignin);

        //menghubungkan variabel edemail dengan componen button pada Layout
        ednama=findViewById(R.id.edNamaLog);

        //menghubungkan variabel edpasssword dengan componen button pada Layout
        edpassword=findViewById(R.id.edPasswordLog);

        register=findViewById(R.id.register1);

        final EditText edCB = (EditText) findViewById(R.id.edPasswordLog);
        CheckBox c = (CheckBox) findViewById(R.id.checkBox);

        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked) {
                    edCB.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else{
                    edCB.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //membuat object untuk pindah halaman
                Intent i = new Intent (MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        //membuat fungsi onclick pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //menyimpan input user edittext email kedalam variabel nama
                nama = ednama.getText().toString();

                //menyimpan input user edittext email kedalam variabel nama
                password = edpassword.getText().toString();

                if (nama.equals("rezka") && password.equals("rezka12")) {
                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();

                    Bundle bundle = new Bundle();
                    //key parsing data dimasukkan kedalam bundle
                    bundle.putString("data1", nama);

                    //membuat object untuk pindah halaman
                    Intent i = new Intent (MainActivity.this, IsiTaskActivity.class);
                    i.putExtras(bundle);
                    startActivity(i);
                } else if (ednama.getText().toString().isEmpty()) {
                    ednama.setError("Nama Tidak boleh kosong");
                } else if (nama.equals(nama) && password.equals("rezka12")) {
                    Toast.makeText(MainActivity.this, "Nama yang anda masukkan salah", Toast.LENGTH_SHORT).show();
                } else if (nama.equals("rezka") && password.equals(password)) {
                    Toast.makeText(MainActivity.this, "Password salah", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Nama dan Password salah", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}