package com.example.index.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.index.Models.HistoryTrading.HistoryTrading_Responce;
import com.example.index.Models.Tools.Tools_Responce;
import com.example.index.Models.balance.Balance_Responce;
import com.example.index.R;
import com.example.index.repositories.DBLive;

public class MainFragment extends Fragment {

    private MainViewModel mainViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mainViewModel =
                ViewModelProviders.of(this).get(MainViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        mainViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        DBLive.getInstance().getBalance_responceMutableLiveData().observe(this, new Observer<Balance_Responce>() {
            @Override
            public void onChanged(@NonNull Balance_Responce balance_responce) {
                textView.setText(balance_responce.toString());
            }
        });
        DBLive.getInstance().getTools_responceMutableLiveData().observe(this, new Observer<Tools_Responce>() {
            @Override
            public void onChanged(Tools_Responce tools_responce) {
                textView.setText(tools_responce.toString());
            }
        });
        DBLive.getInstance().getHistoryTrading_responceMutableLiveData().observe(this, new Observer<HistoryTrading_Responce>() {
            @Override
            public void onChanged(HistoryTrading_Responce historyTrading_responce) {
                textView.setText(historyTrading_responce.toString());
            }
        });

        return root;
    }
}