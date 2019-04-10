package com.rosid.tugas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class projeck1 extends AppCompatActivity {
    private String nama, email, password, tanggal, alamat, tempat, jk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projeck1);

        Intent n = getIntent();
        nama = n.getStringExtra("nama");
         email = n.getStringExtra("email");
         password = n.getStringExtra("password");
         alamat = n.getStringExtra("alamat");
         tempat = n.getStringExtra("tempat");
         tanggal = n.getStringExtra("tanggal");
         jk = n.getStringExtra("jenisK");

        
        TextView r = (TextView) findViewById(R.id.lblNama);
        r.setText(nama);
        TextView e = (TextView) findViewById(R.id.lblEmail);
        e.setText(email);
        TextView p = (TextView) findViewById(R.id.lblPassword);
        p.setText(password);
        TextView a = (TextView) findViewById(R.id.lblAlamat);
        a.setText(alamat);
        TextView m = (TextView) findViewById(R.id.lblTempat);
        m.setText(tempat);
        TextView t = (TextView) findViewById(R.id.lblTanggal);
        t.setText(tanggal);
        TextView jK = (TextView) findViewById(R.id.lbljk);
        jK.setText(jk);
    }

}
