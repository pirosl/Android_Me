package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

/**
 * Activity to display a list of images
 */
public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    public final static String HEAD_INDEX = "headIndex";
    public final static String BODY_INDEX = "bodyIndex";
    public final static String LEG_INDEX = "legIndex";

    // indexes of head, body and leg images
    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onImageSelected(int position) {
        int group = position / 12;
        int index = position % 12;

        switch(group) {
            case 0:
                headIndex = index;
                Toast.makeText(this, "Selected head", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                bodyIndex = index;
                Toast.makeText(this, "Selected body", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                legIndex = index;
                Toast.makeText(this, "Selected legs", Toast.LENGTH_SHORT).show();
                break;
        }

        Bundle bundle = new Bundle();
        bundle.putInt(HEAD_INDEX, headIndex);
        bundle.putInt(BODY_INDEX, bodyIndex);
        bundle.putInt(LEG_INDEX, legIndex);

        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(bundle);

        Button button = findViewById(R.id.show_next_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

    }
}
