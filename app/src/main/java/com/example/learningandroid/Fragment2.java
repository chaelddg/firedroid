package com.example.learningandroid;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment2 extends Fragment{

    String tag = "Fragment 2";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2, container, false);
    }

    @Override
    public void onStart() {
        Log.d(tag, "Event : onStart");

        super.onStart();

        Button btnGetText = (Button) getActivity().findViewById(R.id.btnGetText);

        btnGetText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                TextView lbl = (TextView) getActivity().findViewById(R.id.lblfragment1);
                Toast.makeText(getActivity(), lbl.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
