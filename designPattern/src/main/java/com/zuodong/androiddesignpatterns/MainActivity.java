package com.zuodong.androiddesignpatterns;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zuodong.androiddesignpatterns.ChapterFive.ConcreteFactory;
import com.zuodong.androiddesignpatterns.ChapterFive.ConcreteProductB;
import com.zuodong.androiddesignpatterns.ChapterFive.Factory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textFactory();
    }

    private void textFactory() {
        //工厂模式，可以使用静态方法
        Factory factory = new ConcreteFactory();
        factory.createProduct(ConcreteProductB.class).method();
    }
}
