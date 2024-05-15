package com.example.tp1;

import static java.lang.Integer.parseInt;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText  montant;
    RadioGroup  radioGroup;
    TextView textView;
    Button convert;
    String selectedButtonText;




    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        montant = findViewById(R.id.editTextText);
        radioGroup= findViewById(R.id.radioGroup);
        textView=findViewById(R.id.textView3);
        convert=findViewById(R.id.button);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton= findViewById(checkedId);
                if(radioButton!=null){
                    selectedButtonText = radioButton.getText().toString();

                }
            }
        });
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(montant.getText().toString().isEmpty()){
                    textView.setText("Montant invalide");
                }else{
                    if(selectedButtonText.equals("Euro -> Dinar")){
                        double inputValue = Double.parseDouble(montant.getText().toString());
                        double result = inputValue * 3.4;
                        textView.setText(String.valueOf(result));
                    } else if (selectedButtonText.equals("Dinar -> Euro")) {
                        double inputValue = Double.parseDouble(montant.getText().toString());
                        double result = inputValue / 3.4;
                        textView.setText(String.valueOf(result));

                    }

                }
            }
        });
    }
}
