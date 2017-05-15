package com.zuodong.androiddesignpatterns.ChapterThirteen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongdong on 2017/3/15.
 *
 * 负责管理memoto对象
 */

public class NoteCaretaker {

    private static final int MAX = 30;
    List<Memoto> mMemotos = new ArrayList<>(MAX);
    int mIndex = 0;

    /**
     * 保存备忘录到记录列表中
     * @param memoto
     */
    public void saveMemoto(Memoto memoto){
        if(mMemotos.size() > MAX){
            mMemotos.remove(0);
        }
        mMemotos.add(memoto);
        mIndex = mMemotos.size() - 1;
    }

    /**
     * 获取上一个存档信息，相当于撤销功能
     * @return
     */
    public Memoto getPrevMemoto(){
        mIndex = mIndex > 0 ? --mIndex : mIndex;
        return mMemotos.get(mIndex);
    }

    /**
     * 获取下一个存档信息，相当于重做功能
     * @return
     */
    public Memoto getNextMemoto(){
        mIndex = mIndex < mMemotos.size() -1 ? ++mIndex : mIndex;
        return mMemotos.get(mIndex);
    }
}
