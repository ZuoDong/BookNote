package com.zuodong.androiddesignpatterns.ChapterThirteen;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by dongdong on 2017/3/15.
 *
 *
 */

public class NoteEditText extends EditText {

    public NoteEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 创建备忘录，并存储数据
     * @return
     */
    public Memoto createMemoto(){
        Memoto memoto = new Memoto();
        memoto.text = getText().toString();
        memoto.cursor = getSelectionStart();
        return memoto;
    }

    /**
     * 从备忘录中恢复数据
     * @param memoto
     */
    public void restore(Memoto memoto){
        setText(memoto.text);
        setSelection(memoto.cursor);
    }
}
