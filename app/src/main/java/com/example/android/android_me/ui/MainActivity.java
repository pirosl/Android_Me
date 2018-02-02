package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

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

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.android_me_linear_layout) != null) {
            mTwoPane = true;

            Button button = findViewById(R.id.show_next_button);
            button.setVisibility(View.GONE);

            GridView gridView = findViewById(R.id.images_grid_view);
            gridView.setNumColumns(2);

            // create also the body parts
            if(savedInstanceState == null) {
                // Create BodyPartFragment for all body parts and display them using FragmentManager
                BodyPartFragment headFragment = new BodyPartFragment();
                headFragment.setImageIds(AndroidImageAssets.getHeads());

                BodyPartFragment bodyFragment = new BodyPartFragment();
                bodyFragment.setImageIds(AndroidImageAssets.getBodies());

                BodyPartFragment legFragment = new BodyPartFragment();
                legFragment.setImageIds(AndroidImageAssets.getLegs());

                FragmentManager fragmentManager = getSupportFragmentManager();

                fragmentManager.beginTransaction()
                        .add(R.id.head_container, headFragment)
                        .add(R.id.body_container, bodyFragment)
                        .add(R.id.leg_container, legFragment)
                        .commit();
            }
        } else {
            mTwoPane = false;
        }
    }

    @Override
    public void onImageSelected(int position) {
        int group = position / 12;
        int index = position % 12;

        if(mTwoPane) {
            BodyPartFragment bodyPartFragment = new BodyPartFragment();
            bodyPartFragment.setListIndex(index);
            switch(group) {
                case 0:
                    bodyPartFragment.setImageIds(AndroidImageAssets.getHeads());
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.head_container, bodyPartFragment)
                            .commit();
                    break;
                case 1:
                    bodyPartFragment.setImageIds(AndroidImageAssets.getBodies());
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.body_container, bodyPartFragment)
                            .commit();
                    break;
                case 2:
                    bodyPartFragment.setImageIds(AndroidImageAssets.getLegs());
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.leg_container, bodyPartFragment)
                            .commit();
                    break;
            }


        } else {
            switch (group) {
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
}
