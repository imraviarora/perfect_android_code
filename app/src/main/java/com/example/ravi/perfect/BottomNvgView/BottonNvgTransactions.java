package com.example.ravi.perfect.BottomNvgView;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ravi.perfect.R;


public class BottonNvgTransactions extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getContext(), "Transactions Selected", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.frag_bntransactions,container,false);
    }
}
