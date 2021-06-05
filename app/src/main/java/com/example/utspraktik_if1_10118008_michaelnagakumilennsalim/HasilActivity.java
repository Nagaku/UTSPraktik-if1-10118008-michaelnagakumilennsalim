package com.example.utspraktik_if1_10118008_michaelnagakumilennsalim;

/*

    10118008
    Michael Nagaku Milenn Salim
    IF-1

 */


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class HasilActivity extends AppCompatActivity {

    private TextView nik, nama, tanggal, jk, hub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        nik = findViewById(R.id.hasil_3);
        nama = findViewById(R.id.hasil_5);
        tanggal = findViewById(R.id.form_tanggal);
        jk = findViewById(R.id.hasil_9);
        hub = findViewById(R.id.hasil_11);

        Intent intent = getIntent();
        nik.setText(intent.getStringExtra(MainActivity.iNik));
        nama.setText(intent.getStringExtra(MainActivity.iNama));
        tanggal.setText(intent.getStringExtra(MainActivity.iTl));
        jk.setText(intent.getStringExtra(MainActivity.iJk));
        hub.setText(intent.getStringExtra(MainActivity.iHub));
    }

    public void balik(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra(MainActivity.iNik, nik.getText().toString());
        i.putExtra(MainActivity.iNama, nama.getText().toString());
        i.putExtra(MainActivity.iTl, tanggal.getText().toString());
        i.putExtra(MainActivity.iJk, jk.getText().toString());
        i.putExtra(MainActivity.iHub, hub.getText().toString());
        startActivity(i);
    }

    public void lanjut(View view) {
        BottomSheetDialogFrag bottomSheet = new BottomSheetDialogFrag(getApplicationContext());
        bottomSheet.show(getSupportFragmentManager(), "ModalBottomSheet");
/*        bottomSheet.getView().findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HasilActivity.this, MainActivity.class);
                startActivity(i);
            }
        });*/
    }
}
