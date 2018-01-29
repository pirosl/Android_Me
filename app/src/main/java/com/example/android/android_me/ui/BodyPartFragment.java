package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * BodyPartFragment class
 *
 * @author lucian
 */
public class BodyPartFragment extends Fragment {

    public BodyPartFragment() {

    }

    /**
     * Inflates the fragment layout and sets image resources
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        // get refference to image view
        ImageView imageView = rootView.findViewById(R.id.body_part_image_view);

        //set image resource to display
        imageView.setImageResource(AndroidImageAssets.getHeads().get(0));

        // return rootView
        return rootView;
    }
}
