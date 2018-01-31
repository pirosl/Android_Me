package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.ArrayList;
import java.util.List;

/**
 * BodyPartFragment class
 *
 * @author lucian
 */
public class BodyPartFragment extends Fragment {

    // Tag for logging
    private  static final String TAG =  BodyPartFragment.class.getSimpleName();

    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";

    // variables to store list of image resources and the index of the image we want to display
    private List<Integer> mImageIds;
    private int mListIndex;

    public BodyPartFragment() {

    }

    /**
     * Inflates the fragment layout and sets image resources
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {

        if(savedInstance != null) {
            mImageIds =  savedInstance.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstance.getInt(LIST_INDEX);
        }

        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        // get refference to image view
        final ImageView imageView = rootView.findViewById(R.id.body_part_image_view);

        //set image resource to display
        if(mImageIds != null) {
            imageView.setImageResource(mImageIds.get(mListIndex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListIndex < mImageIds.size() - 1) {
                        mListIndex++;
                    } else {
                        mListIndex = 0;
                    }
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });
        } else {
            Log.v(TAG, "This fragment has a null list of image ids");
        }
        // return rootView
        return rootView;
    }

    /**
     * Set list of image ids.
     *
     * @param imageIds - list of image ids
     */
    public void setImageIds(List<Integer> imageIds) {
        mImageIds = imageIds;
    }

    /**
     * Set index of the image to be used.
     *
     * @param listIndex - index to be use
     */
    public void setListIndex(int listIndex) {
        mListIndex = listIndex;
    }

    /**
     * Save current state of the fragment.
     *
     * @param currentState - bundle where current state is saved
     */
    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);
    }

}
