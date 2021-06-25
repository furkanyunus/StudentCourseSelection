package com.example.hafta7odev1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/*
Açılır Menu ile ögernci isimleri listelensin
Ders listesi checkbox lar ile listelensin
Seçilen ögrenci ve dersler textview de yazdırırlsın
 */

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    String tx,tx2,str;
    Button btn;
    TextView txt;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String []Ogrenci={"seciniz...","Dorukhan","Ahmet","Mehmet","Ali","Ayşe","Fatma"};
        spinner=(Spinner)findViewById(R.id.spinner);
        txt=(TextView)findViewById(R.id.textView);
        btn=(Button)findViewById(R.id.button);

        linearLayout=(LinearLayout)findViewById(R.id.linearLayout);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_checked, android.R.id.text1, Ogrenci);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                tx="";
                if (pos!=0){
                    str = spinner.getSelectedItem().toString();
                    Toast.makeText(getApplicationContext(),"Secilen Oge="+Ogrenci[pos],Toast.LENGTH_LONG).show();
                }
                txt.setText(str);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tx="";
                for(int i = 0; i < linearLayout.getChildCount(); i++){
                    if( ((CheckBox)linearLayout.getChildAt(i)).isChecked()){
                        tx2 = ((CheckBox)linearLayout.getChildAt(i)).getText().toString();
                        tx=tx+tx2+",";
                    }
                }
                tx=tx+" sayıları seçildi";
                txt.setText(tx);
            }
        });
    }
}
