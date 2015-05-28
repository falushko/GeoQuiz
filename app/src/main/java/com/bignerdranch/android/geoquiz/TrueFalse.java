package com.bignerdranch.android.geoquiz;

public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;
    private boolean mIsCheater;

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean mTrueQuestion) {
        this.mTrueQuestion = mTrueQuestion;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public boolean isIsCheater() { return mIsCheater; }

    public void setIsCheater(boolean mIsCheater) { this.mIsCheater = mIsCheater; }


    public TrueFalse(int question, boolean trueQuestion) {
        mQuestion = question;
        mTrueQuestion = trueQuestion;
        mIsCheater = false;
    }
}
