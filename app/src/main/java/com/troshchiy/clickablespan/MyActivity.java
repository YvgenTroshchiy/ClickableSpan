package com.troshchiy.clickablespan;

import android.app.Activity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MyActivity extends Activity {

    private TextView textView;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        textView = (TextView) findViewById(R.id.textView);

        String text = "Some text [clickable] and [ttaralya]";
        int i1 = text.indexOf("[");
        int i2 = text.indexOf("]");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(text, TextView.BufferType.SPANNABLE);

        Spannable spannable = (Spannable) textView.getText();
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override public void onClick(View widget) {
                Toast.makeText(MyActivity.this, "Click", Toast.LENGTH_SHORT).show();
            }
        };
        spannable.setSpan(clickableSpan, i1, i2 + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
}