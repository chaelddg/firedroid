package com.example.learningandroid;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {

    String tag = "Fragment 1";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(tag, " Event : onCreateView");
        return inflater.inflate(R.layout.fragment1, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        Log.d(tag, "Event : onAttach");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Event : onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d(tag, "Event : onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(tag, "Event : onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(tag, "Event : onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(tag, "Event : onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(tag, "Event : onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(tag, "Event : onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(tag, "Event : onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(tag, "Event : onDetach");
        super.onDetach();
    }
}
