package com.example.android.myquiz;

import android.content.Context;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.myquiz.R.id.radio2_Dorian_Yates;
import static com.example.android.myquiz.R.id.radio_Lee_Haney;

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
        String Ques4Answer = "Hany Rambod";

        // result_Message variable holds the data to update score
        EditText nameField =  (EditText) findViewById(R.id.Name);
        String store_Name = nameField.getText().toString();
        EditText nameFieldOfQ4 = (EditText) findViewById(R.id.Ques4);
        String Ques4Field = nameFieldOfQ4.getText().toString();
                option_Checker();//this function will check checkboxes
        if (checkQuestion2()){
            score_Keeper++ ;
        }
        if (checkQuestion3()){
            score_Keeper++ ;
        }
                if (Ques4Field.equals(Ques4Answer)) {
                    score_Keeper = score_Keeper + 1;//this compare the ques 4 amswer with true one which is stored in Ques4Answer
                }
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
    private boolean checkQuestion2() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_2_radio_group);

        if( rg.getCheckedRadioButtonId() == radio_Lee_Haney ) {
            return true;
        }

        return false;
    }
    private boolean checkQuestion3() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_3_Radio_Group);

        if( rg.getCheckedRadioButtonId() == radio2_Dorian_Yates ) {
            return true;
        }

        return false;
    }
    private void displayMessage(String message) {
        TextView resultTextView = (TextView) findViewById(R.id.Result_show);
        resultTextView.setText(message);
        score_Keeper = 0 ;
    }
}
