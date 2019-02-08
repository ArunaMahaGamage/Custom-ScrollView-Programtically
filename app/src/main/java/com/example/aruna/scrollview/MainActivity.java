package com.example.aruna.scrollview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context;
    Integer index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getBaseContext();

        LinearLayout ll = (LinearLayout) findViewById(R.id.llscrol);

        for (int i = 0; i < 20; i++) {

            View v = LayoutInflater.from(context).inflate(R.layout.custom_lay, ll, false);

            v.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            final LinearLayout carlay = (LinearLayout) v.findViewById(R.id.ll_items);
            carlay.setTag(i);

            carlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    index = Integer.parseInt(v.getTag().toString());

                    Toast.makeText(context, "Icon Number : " + String.valueOf(index),
                            Toast.LENGTH_LONG).show();
                }
            });

            ll.addView(v);

            ll.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        }

    }
}
