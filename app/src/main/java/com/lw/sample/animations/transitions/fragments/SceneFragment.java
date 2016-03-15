package com.lw.sample.animations.transitions.fragments;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lw.sample.R;
import com.lw.sample.utils.UIHelper;

/**
 * Created by yjwfn on 16-3-14.
 */
public class SceneFragment extends Fragment {


     ViewGroup   mSceneRoot;

     boolean mIsFirstScene;

     Scene   mFirstScene;

     Scene   mSecondScene;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_scene, container, false);
        return rootView;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if(!UIHelper.sdkCompare(19)) {
            return;
        }

        mSceneRoot = (ViewGroup) view.findViewById(R.id.scene_root);



        mSecondScene = Scene.getSceneForLayout(mSceneRoot, R.layout.scene_two, getActivity());
        mFirstScene = Scene.getSceneForLayout(mSceneRoot, R.layout.scene_one, getActivity());





        changeScene();

        View btn = view.findViewById(R.id.changeScene);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeScene();
            }
        });
    }

    private void changeScene(){




        if(mIsFirstScene){
            mFirstScene = new Scene(mSceneRoot,mSceneRoot.getChildAt(0));
            TransitionManager.go(mSecondScene);
            mIsFirstScene = false;
        }else{
            if(mSceneRoot.getChildCount() > 0){
                mSecondScene = new Scene(mSceneRoot,mSceneRoot.getChildAt(0));
            }

            TransitionManager.go(mFirstScene);
            mIsFirstScene = true;
        }

    }




}
