package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {
    Button BtnReg;
    EditText edtNama, edtEmail, edtPassword,edtrepass;
    String nama,email,password,repassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtNama = findViewById(R.id.edNamaReg);
        edtEmail = findViewById(R.id.edEmailReg);
        edtPassword = findViewById(R.id.edPasswordReg);
        edtrepass = findViewById(R.id.edrepass);

        BtnReg=findViewById(R.id.buttonReg);

        BtnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edtNama.getText().toString();
                email = edtEmail.getText().toString();
                password = edtPassword.getText().toString();
                repassword = edtrepass.getText().toString();

                if (edtNama.getText().toString().isEmpty()) {
                    //menampilkan seteror
                    edtNama.setError("Nama Tidak boleh kosong");
                } else if (edtEmail.getText().toString().isEmpty()) {
                    edtEmail.setError("Email Tidak boleh kosong");
                }else {
                    //membuat kondisi untuk mengecek apakah isi dari editText password dan repassword sama atau tidak
                    if (edtPassword.getText().toString().equals(edtrepass.getText().toString())) {
                        //menampilkan pesan notifikasi jika pendaftaran berhasil
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil...", Toast.LENGTH_SHORT).show();

                        //method untuk kembali ke activity main
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    } else {
                        //menampilkan pesan bahwa isi dari EditText password dan repassword tidak sama
                        Snackbar.make(view, "Password dan Repassword  harus sama!!", Snackbar.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }


}
