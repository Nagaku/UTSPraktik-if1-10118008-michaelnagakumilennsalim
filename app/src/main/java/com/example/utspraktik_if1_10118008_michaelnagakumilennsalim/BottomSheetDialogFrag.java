package com.example.utspraktik_if1_10118008_michaelnagakumilennsalim;

/*

    10118008
    Michael Nagaku Milenn Salim
    IF-1

 */


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.example.utspraktik_if1_10118008_michaelnagakumilennsalim.HasilActivity;

import org.w3c.dom.Text;


public class BottomSheetDialogFrag extends BottomSheetDialogFragment {

    public Context context;

    public BottomSheetDialogFrag(Context context) {
        this.context = context;
    }

    @Override
        public View onCreateView(LayoutInflater inflater, @Nullable
                ViewGroup container, @Nullable Bundle savedInstanceState)
        {
            View v = inflater.inflate(R.layout.bottom_sheet_layout,
                    container, false);

            TextView ok = v.findViewById(R.id.ok);

            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                Intent i = new Intent(context, MainActivity.class);
                startActivity(i);
                }
            });
            return v;
        }


}
