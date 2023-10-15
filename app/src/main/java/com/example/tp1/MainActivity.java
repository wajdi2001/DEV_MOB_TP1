package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText vm;
    private SeekBar sbAge;
    private TextView res;
    private Button btn;
    private RadioGroup rbGrp;
    private TextView votreAge;
    private boolean Jéuner = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        votreAge = findViewById(R.id.votreAge);
        vm = findViewById(R.id.vm);
        sbAge = findViewById(R.id.sbAge);
        res = findViewById(R.id.res);
        rbGrp = findViewById(R.id.rbGrp);
        btn = findViewById(R.id.btn);

        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Update the TextView with the current progress value
                votreAge.setText("Votre Age: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Stop Tracking Touch", Toast.LENGTH_SHORT).show();
            }
        });

        rbGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton = findViewById(checkedId);
                String selectedValue = selectedRadioButton.getText().toString();
                 if (selectedValue.equals("Oui")) { Jéuner=true; }else {Jéuner=false;
                 }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int age = sbAge.getProgress();
                double valeurM = Double.parseDouble(vm.getText().toString());

                if (Jéuner) {
                    if (age >= 13 && (valeurM >= 5.0 && valeurM <= 7.2)) {
                        res.setText("niveau de glycémie est normale 1");
                    } else if (age >= 6 && (valeurM >= 5.0 && valeurM <= 10.0)) {
                        res.setText("niveau de glycémie est normale 2");
                    } else if (valeurM >= 5.5 && valeurM <= 10.0) {
                        res.setText("niveau de glycémie est normale 3");
                    } else {
                        res.setText("niveau de glycémie est trop bas  ou niveau de glycémie est trop élevée 1");
                    }
                } else {
                    if (age >= 13 && valeurM < 10.5) {
                        res.setText("niveau de glycémie est normale");
                    } else {
                        res.setText("niveau de glycémie est trop bas  ou niveau de glycémie est trop élevée 2 ");
                    }
                }
                vm.setText("");
                sbAge.setProgress(0);


            }
        });
    }
}
