package com.test.demoquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button showPopupBtn, closePopupBtn;
    PopupWindow popupWindow;
    ConstraintLayout quiz;
    TextView quizText,option1,option2,option3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showPopupBtn = (Button) findViewById(R.id.showPopupBtn);
        quiz = (ConstraintLayout) findViewById(R.id.quizLayout);


        showPopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connection con= new connection();
                if(con.getConnection(MainActivity.this))
                showQuiz();
            }
        });


    }

    public void showQuiz(){

        //instantiate the whichquiz.xml layout file
        LayoutInflater layoutInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = layoutInflater.inflate(R.layout.whichquiz,null);

        closePopupBtn = (Button) customView.findViewById(R.id.closePopupBtn);

        //instantiate popup window
        popupWindow = new PopupWindow(customView, ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);

        //display the popup window
        popupWindow.showAtLocation(customView, Gravity.CENTER, 0, 0);
        option1=(TextView)findViewById(R.id.aText);
        option2=(TextView)findViewById(R.id.bText);
        option3=(TextView)findViewById(R.id.cText);
        quizText = findViewById(R.id.textView);
        loadQuiz quiz= new loadQuiz();
        System.out.println(quiz.getQuiz(MainActivity.this,"https://api.plos.org/search?q=title:DNA"));





        //close the popup window on button click
        closePopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

    }
}