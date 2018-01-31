package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Fragment to display a grid of images
 */
public class MasterListFragment extends Fragment {

    public MasterListFragment() {

    }

    /**
     * Inflates fragment layout and set grid view adapter
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {

        View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        GridView imagesGridView = rootView.findViewById(R.id.images_grid_view);

        imagesGridView.setAdapter(new MasterListAdapter(rootView.getContext(), AndroidImageAssets.getAll()));

        return rootView;
    }
}
