package com.example.album;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rdoDog,rdoCat,rdoRabbit;
    Button btnOk;
    ImageView imgPet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        chkAgree = (CheckBox) findViewById(R.id.ChkAgree);
        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoDog = (RadioButton) findViewById(R.id.RdoDog);
        rdoCat = (RadioButton) findViewById(R.id.RdoCat);
        rdoRabbit = (RadioButton) findViewById(R.id.RdoRabbit);
        btnOk = (Button) findViewById(R.id.BtnOk);
        imgPet = (ImageView) findViewById(R.id.ImgPet);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chkAgree.isChecked() == true){
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnOk.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                } else{
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnOk.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedRadio = rGroup1.getCheckedRadioButtonId();
                if(checkedRadio == R.id.RdoDog){
                    imgPet.setImageResource(R.drawable.dog);
                } else if (checkedRadio == R.id.RdoCat) {
                    imgPet.setImageResource(R.drawable.cat);
                } else if (checkedRadio == R.id.RdoRabbit) {
                    imgPet.setImageResource(R.drawable.rabbit);
                } else{
                    Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}