package com.example.utspraktik_if1_10118008_michaelnagakumilennsalim;

/*

    10118008
    Michael Nagaku Milenn Salim
    IF-1

 */

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static final String iNik = "com.example.utspraktik_if1_10118008_michaelnagakumilennsalim.nik";
    public static final String iNama = "com.example.utspraktik_if1_10118008_michaelnagakumilennsalim.nama";
    public static final String iTl = "com.example.utspraktik_if1_10118008_michaelnagakumilennsalim.tl";
    public static final String iJk = "com.example.utspraktik_if1_10118008_michaelnagakumilennsalim.jk";
    public static final String iHub = "com.example.utspraktik_if1_10118008_michaelnagakumilennsalim.hub";
    public static final String[] MONTHS = {"January","February","March","April","May","June","July",
            "August","September","October","November","December"};

    private DatePicker datePicker;
    private Calendar calendar;
    private EditText dateView;
    private int year, month, day;
    private RadioGroup hJk, hHub;
    private RadioButton sJk, sHub;
    private EditText hNik, hNama, hTl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateView = (EditText) findViewById(R.id.form_tanggal);
        dateView.setFocusable(false);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        hNik = findViewById(R.id.nik);
        hNama = findViewById(R.id.nama);
        hTl = findViewById(R.id.form_tanggal);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
        checkIfExist();
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
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
        dateView.setText(new StringBuilder().append(day).append(" ")
                .append(MONTHS[month-1]).append(" ").append(year));
    }

    public void selanjutnya(View view) {
        hJk = findViewById(R.id.radioJK);
        hHub = findViewById(R.id.radioHubungan);
        sJk = findViewById(hJk.getCheckedRadioButtonId());
        Log.d("ola", String.valueOf(hJk.getCheckedRadioButtonId()));
        sHub = findViewById(hHub.getCheckedRadioButtonId());
        if(!validate())
            Toast.makeText(getApplicationContext(),  "NIK atau Nama tidak boleh kosong", Toast.LENGTH_SHORT).show();
        else {
            Intent i = new Intent(MainActivity.this, HasilActivity.class);
            i.putExtra(iNik, hNik.getText().toString());
            i.putExtra(iNama, hNama.getText().toString());
            i.putExtra(iTl, hTl.getText().toString());
            i.putExtra(iJk, sJk.getText().toString());
            i.putExtra(iHub, sHub.getText().toString());
            startActivity(i);
        }
    }

    public boolean validate(){
        if (hNik.getText().toString().isEmpty())
            return false;
        else if ( hNama.getText().toString().isEmpty())
            return false;
        return true;
    }

    private void checkIfExist(){
        Bundle extras=getIntent().getExtras();
        if ( extras != null){
            Intent i = getIntent();
            if(!i.getStringExtra(iNik).isEmpty()){
                hNik.setText(i.getStringExtra(iNik));
            }
            if(!i.getStringExtra(iNama).isEmpty()){
                hNama.setText(i.getStringExtra(iNama));
            }
            if(!i.getStringExtra(iTl).isEmpty()){
                hTl.setText(i.getStringExtra(iTl));
            }

        }

    }
}