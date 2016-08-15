package com.twiceyuan.cocoatoast.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.twiceyuan.cocoatoast.library.CocoaToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CocoaToast.init(getApplicationContext());
    }

    public void toast(View view) {
        CocoaToast.show("提交成功");
    }

    public void toastOnlyIcon(View view) {
        CocoaToast.showIconOnly(R.drawable.better_toast_ic_done_white);
    }

    public void toastOnlyText(View view) {
        CocoaToast.showTextOnly("提交成功");
    }
}
