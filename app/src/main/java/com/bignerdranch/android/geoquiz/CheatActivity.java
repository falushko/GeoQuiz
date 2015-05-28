package com.bignerdranch.android.geoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CheatActivity extends AppCompatActivity {

    public static final String EXTRA_ANSWER_IS_TRUE =
            "com.bignerdranch.android.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN =
            "com.bignerdranch.android.geoquiz.answer_shown";
    public static final String KEY_INDEX = "index";

    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswer;

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    private void fixingLandscapeCheating(){
        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);
        if (mAnswerIsTrue) mAnswerTextView.setText(R.string.true_button);
        else mAnswerTextView.setText(R.string.false_button);
        setAnswerShownResult(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        setAnswerShownResult(false);
        if(savedInstanceState != null) {
            mAnswerIsTrue = savedInstanceState.getBoolean(KEY_INDEX);
            fixingLandscapeCheating();
        }
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mShowAnswer = (Button)findViewById(R.id.show_answer_button);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mAnswerIsTrue = true;
                fixingLandscapeCheating();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(KEY_INDEX, mAnswerIsTrue);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cheat, menu);
        return true;
    }

}
