package com.example.official5;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class QuizDisp extends AppCompatActivity {

    private static final String[] TOPICS = {"What are you?","Where are we?","Wait... What?"};
    private static final String[] QUESTIONS = {"Are you a human being or a beetle?", "Are we in College Station or Houston?","What is the meaning of life?"};
    private static final String[] ANSWERS = {"Human","College Station","49"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_disp);

        Intent forwardIntent = getIntent();
        String extra = forwardIntent.getStringExtra("animal");
        TextView tv_quiz_question = (TextView) findViewById(R.id.tv_quiz_question);

        if (extra.equals(TOPICS[0])) {
            tv_quiz_question.setText(QUESTIONS[0]);
        }

        if (extra.equals(TOPICS[1])) {
            tv_quiz_question.setText(QUESTIONS[1]);
        }

        if (extra.equals(TOPICS[2])) {
            tv_quiz_question.setText(QUESTIONS[2]);
        }
    }

    public void myclick (View view){
        EditText anstxt = (EditText) findViewById(R.id.et_user_answer);
        String ans;

        Intent backIntent = new Intent();
        ans = anstxt.getText().toString();
        backIntent.putExtra("family",ans);
        setResult(RESULT_OK,backIntent);
        finish();
    }

}
