package com.zuodong.androiddesignpatterns.ChapterThirteen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zuodong.androiddesignpatterns.R;

public class MemotoActivity extends AppCompatActivity implements View.OnClickListener {

    private NoteEditText note_edit;
    private Button note_undo;
    private Button note_save;
    private Button note_redo;
    private LinearLayout activity_memoto;

    //note备忘录管理器
    NoteCaretaker caretaker = new NoteCaretaker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoto);
        initView();
    }

    private void initView() {
        note_edit = (NoteEditText) findViewById(R.id.note_edit);
        note_undo = (Button) findViewById(R.id.note_undo);
        note_save = (Button) findViewById(R.id.note_save);
        note_redo = (Button) findViewById(R.id.note_redo);
        activity_memoto = (LinearLayout) findViewById(R.id.activity_memoto);

        note_undo.setOnClickListener(this);
        note_save.setOnClickListener(this);
        note_redo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.note_undo:
                //恢复到上一个记录点
                note_edit.restore(caretaker.getPrevMemoto());
                break;
            case R.id.note_save:
                //保存笔记
                caretaker.saveMemoto(note_edit.createMemoto());
                break;
            case R.id.note_redo:
                //恢复到下一个记录点
                note_edit.restore(caretaker.getNextMemoto());
                break;
        }
    }

}
