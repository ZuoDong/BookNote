package com.zuodong.androiddesignpatterns.ChapterTentySix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zuodong.androiddesignpatterns.R;

public class MVPBaseActivity<V,T extends BasePresenter<V>> extends AppCompatActivity {

    protected T mPresenter;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpbase);
        mPresenter = creaePresenter();
        mPresenter.attachView((V)this);
    }

    private T creaePresenter() {
        return null;
    }
}
