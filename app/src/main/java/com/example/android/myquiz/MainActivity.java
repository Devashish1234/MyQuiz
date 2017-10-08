package com.example.android.myquiz;

import android.content.Context;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score_Keeper = 0 ;
    // score_Keeper is the variable which holds score of the user
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // this method is called when submit button is clicked
    public void checker(View view){
        String result_Message = " your score is ";
        // result_Message variable holds the data to update score
        EditText nameField =  (EditText) findViewById(R.id.Name);
        String store_Name = nameField.getText().toString();
        option_Checker();//this function will check checkboxes
        result_Message = store_Name + result_Message + score_Keeper;
        Context context = getApplicationContext();
        CharSequence text = result_Message;
        int duration = Toast.LENGTH_SHORT;
        // toast is added
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        displayMessage(result_Message);
    }
    public void option_Checker(){
        // this whole function takes boolean values from ques 1 and updates the score variable
        CheckBox Que1_Opt1 = (CheckBox) findViewById(R.id.Q1_18);
        Boolean Opt1_1 = Que1_Opt1.isChecked();
        CheckBox Que1_Opt2 = (CheckBox) findViewById(R.id.Q1_16);
        Boolean Opt2_1 = Que1_Opt2.isChecked();
        CheckBox Que1_Opt3 = (CheckBox) findViewById(R.id.Q1_20);
        Boolean Opt3_1 = Que1_Opt3.isChecked();
        CheckBox Que1_Opt4 = (CheckBox) findViewById(R.id.Q1_22);
        Boolean Opt4_1 = Que1_Opt4.isChecked();
        if (Opt1_1 && Opt3_1 && Opt4_1){
                score_Keeper = score_Keeper + 1;
        }
        if (Opt2_1) {
            score_Keeper = score_Keeper - 1;
        }
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_Lee_Haney:
                if (checked) {
                    // True Answer
                    score_Keeper += 1;
                    break;
                }
            case R.id.radio_arnold:
                if (checked)
                    // Wrong Answer
                    break;
            case R.id.radio_Phil_Heath:
                if (checked)
                    // Wrong Answer
                    break;
            case R.id.radio_Ronnie_Coleman:
                if (checked)
                    // Wrong Answer
                    break;
        }
    }
    public void onRadioButtonClicked2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio2_Sergi_Constance:
                if (checked) {
                    // Wrong Answer
                    break;
                }
            case R.id.radio2_Jeff_Saeid:
                if (checked)
                    // Wrong Answer
                    break;
            case R.id.radio2_Dorian_Yates:
                if (checked)
                    // True Answer
                    score_Keeper += 1;
                    break;
            case R.id.radio2_Ronnie_Coleman:
                if (checked)
                    // Wrong Answer
                    break;
        }
    }
    private void displayMessage(String message) {
        TextView resultTextView = (TextView) findViewById(R.id.Result_show);
        resultTextView.setText(message);
    }
}
