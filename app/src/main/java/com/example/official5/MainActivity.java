package com.example.official5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    private static final String[] TOPICS = {"What are you?","Where are we?","Wait... What?"};
    //private static final String[] QUESTIONS = {"Are you a human being or a beetle?", "Are we in College Station or Ankh-Morpork?","What is the meaning of life?"};
    private static final int REQ_CODE_ANS = 2468;
    private static final String[] ANSWERS = {"Human","College Station","49"};
    private static final Integer[] POINTS = {10,10,10,0};
    private TextView tv_score;
    Integer score;
    private Integer ResetValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView1 = (ListView) findViewById(R.id.listView1);
        final Intent forwardIntent = new Intent(this,QuizDisp.class);
        ArrayAdapter <String> myadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,TOPICS);

        tv_score = (TextView) findViewById(R.id.tv_score);

        score = 0;
        tv_score.setText(score+"");

        listView1.setAdapter(myadapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String word = parent.getItemAtPosition(position).toString();
                forwardIntent.putExtra("animal",word);

                startActivityForResult(forwardIntent,REQ_CODE_ANS);
            }
        });
    }

    //backIntent
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if(requestCode == REQ_CODE_ANS) {
            String ret_ans = intent.getStringExtra("family");

            if(ret_ans.equals(ANSWERS[0])){
                Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                score = score + POINTS[0];
                tv_score.setText(score+"");
            }
            if(ret_ans.equals(ANSWERS[1])){
                Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                score = score + POINTS[1];
                tv_score.setText(score+"");
            }
            if(ret_ans.equals(ANSWERS[2])){
                Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                score = score + POINTS[2];
                tv_score.setText(score+"");
            }
            if(!ret_ans.equals(ANSWERS[0]) && !ret_ans.equals(ANSWERS[1]) && !ret_ans.equals(ANSWERS[2])){
                Toast.makeText(MainActivity.this, "Nope! Try Again!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void newclick (View view) {
        tv_score.setText("0");
    }

}
