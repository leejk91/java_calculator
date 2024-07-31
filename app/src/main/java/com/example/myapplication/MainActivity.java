package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTextNum1;
    EditText editTextNum2;
    TextView textViewRs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextNum1 = findViewById(R.id.activity_main__editTextNum1);
        editTextNum2 = findViewById(R.id.activity_main__editTextNum2);
        textViewRs = findViewById(R.id.activity_main__textViewRs);

    }

    public void btnAddClicked(View view) {
        if(!CheckNumberInputs()){
            return;
        }

        int num1 = Integer.parseInt(editTextNum1.getText().toString());
        int num2 = Integer.parseInt(editTextNum2.getText().toString());
        int rs = num1 + num2;
        toastMsg("결과 : " + rs);
        textViewRs.setText("결과 : " + rs);
    }

    public void btnMinusClicked(View view) {
        if(!CheckNumberInputs()){
            return;
        }

        int num1 = Integer.parseInt(editTextNum1.getText().toString());
        int num2 = Integer.parseInt(editTextNum2.getText().toString());
        int rs = num1 - num2;
        toastMsg("결과 : " + rs);
        textViewRs.setText("결과 : " + rs);
    }

    public boolean CheckNumberInputs() {
        editTextNum1.setText(editTextNum1.getText().toString().trim());

        if (editTextNum1.getText().toString().length() == 0) {
            toastMsg("숫자1을 입력해주세요");
            editTextNum1.requestFocus();
            return false;
        }

        editTextNum2.setText(editTextNum2.getText().toString().trim());

        if (editTextNum2.getText().toString().length() == 0) {
            toastMsg("숫자2 입력해주세요");
            editTextNum2.requestFocus();
            return false;
        }

        return true;
    }

    public void btnClearClicked(View view) {
        editTextNum1.setText("");
        editTextNum2.setText("");
        textViewRs.setText("결과 : ");

    }

    void toastMsg(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

}