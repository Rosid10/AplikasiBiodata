package com.rosid.tugas;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    private EditText inputNama, inputEmail, inputPassword,inputAlamat, inputTempat, inputTanggal;
    RadioGroup RGJK;
    RadioButton RBJK;
    private String nama, email, password, tanggal, alamat, tempat, jk;
    Intent in;


    private DatePicker datePicker;
    private Calendar calendar;
    private EditText dateView;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateView = (EditText) findViewById(R.id.inputTanggal);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "calendar",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

        

    public void kirim(View v) {
        inputNama = (EditText) findViewById(R.id.inputNama);
        inputEmail = (EditText) findViewById(R.id.inputEmail);
        inputPassword = (EditText) findViewById(R.id.inputPasword);
        inputAlamat = (EditText) findViewById(R.id.inputAlamat);
        inputTempat = (EditText) findViewById(R.id.inputTempat);
        inputTanggal = (EditText) findViewById(R.id.inputTanggal);
        RGJK = (RadioGroup) findViewById(R.id.jk);
        RBJK = (RadioButton) findViewById(RGJK.getCheckedRadioButtonId());
        in = new Intent(this,projeck1.class);
                nama = inputNama.getText().toString();
                email = inputEmail.getText().toString();
                password = inputPassword.getText().toString();
                alamat = inputAlamat.getText().toString();
                tempat = inputTempat.getText().toString();
                tanggal = inputTanggal.getText().toString();
                jk = RBJK.getText().toString();

                in.putExtra("nama",nama);
                in.putExtra("email",email);
                in.putExtra("password",password);
                in.putExtra("alamat", alamat);
                in.putExtra("tempat", tempat);
                in.putExtra("tanggal",tanggal);
                in.putExtra("jenisK",jk);

                startActivity(in);

    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            AlertDialog.Builder alert = new AlertDialog.Builder( MainActivity.this);
            alert.setTitle(getString(R.string.app_name));
            alert.setMessage("Yakin Kamu Ingin Keluar ?");
            alert.setPositiveButton("Ya",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            finish();

                        }
                    });
            alert.setNegativeButton("Tidak",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            alert.show();

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
