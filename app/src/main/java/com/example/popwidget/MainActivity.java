package com.example.popwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CustomPopuWindow mPopuWindow,mPopWindows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.scrollIndicatorDown).setOnClickListener(view -> startPopItemn());
        findViewById(R.id.scrollIndicatorDownSingle).setOnClickListener(view -> startPopItemn2());
    }

    private void startPopItemn(){
        List<ResPopItem> popList = new ArrayList<>();

        popList.add(new ResPopItem("项目", 1));
        popList.add(new ResPopItem("审核", 1));
        popList.add(new ResPopItem("审核2", 1));
        popList.add(new ResPopItem("审核3", 1));
        popList.add(new ResPopItem("审核4", 1));
        popList.add(new ResPopItem("审核5", 1,true,false));
        popList.add(new ResPopItem("审核6", 1));
        popList.add(new ResPopItem("审核7", 1));
        popList.add(new ResPopItem("审核8", 1));
        popList.add(new ResPopItem("审核9", 1));
        popList.add(new ResPopItem("审核10", 1));
        popList.add(new ResPopItem("审核11", 1,true,false));
        popList.add(new ResPopItem("审核12", 1));
        popList.add(new ResPopItem("审核13", 1));
        popList.add(new ResPopItem("审核14", 1));
        popList.add(new ResPopItem("审核15", 1));
        popList.add(new ResPopItem("审核16", 1));
        popList.add(new ResPopItem("审核17", 1));
        popList.add(new ResPopItem("审核18", 1));
        popList.add(new ResPopItem("审核19", 1));
        popList.add(new ResPopItem("审核20", 1));

        if(mPopuWindow == null) {
            mPopuWindow = ActionSheetUtils.initTitleBottomPop(this, "地地道道地地道道多多多多多多多多多多多多多多多多多多多多多多", popList, () -> {
                Log.i("LOG", "dddd");
                Log.i("LOG", "dddd");
            });

        }
        mPopuWindow.showAtLocation(mPopuWindow.getContentView(), Gravity.BOTTOM, 0, 0);
    }

    private void startPopItemn2(){
        List<ResPopItem> popList = new ArrayList<>();

        popList.add(new ResPopItem("项目", 1,true));
        popList.add(new ResPopItem("审核", 1,true,false,true));
        popList.add(new ResPopItem("审核2", 1,true,false,false));


        if(mPopWindows == null) {
            mPopWindows = ActionSheetUtils.initTitleBottomPopMutiple(this, "地地道道地地道道多多多多多多多多多多多多多多多多多多多多多多", popList, () -> {
                Log.i("LOG", "dddd");
                Log.i("LOG", "dddd");
            });
        }
        mPopWindows.showAtLocation(mPopWindows.getContentView(), Gravity.BOTTOM, 0, 0);
    }
}
