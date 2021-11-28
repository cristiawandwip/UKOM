package com.cristiawan.goparty.ui.history;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cristiawan.goparty.Adapter.BarangAdapter;
import com.cristiawan.goparty.Adapter.HistoryAdapter;
import com.cristiawan.goparty.Item;
import com.cristiawan.goparty.Adapter.ItemAdapter;
import com.cristiawan.goparty.Model.Barang;
import com.cristiawan.goparty.Model.GetBarang;
import com.cristiawan.goparty.Model.GetHistory;
import com.cristiawan.goparty.Model.History;
import com.cristiawan.goparty.R;
import com.cristiawan.goparty.Rest.ApiClient;
import com.cristiawan.goparty.Rest.ApiInterface;
import com.cristiawan.goparty.databinding.FragmentHistoryBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryFragment extends Fragment {

    View root;
    RecyclerView recyclerView;
    HistoryAdapter adapter;
    List<History> historyList;
    ApiInterface apiInterface;

    private HistoryViewModel historyViewModel;
private FragmentHistoryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        historyViewModel =
                new ViewModelProvider(this).get(HistoryViewModel.class);

    binding = FragmentHistoryBinding.inflate(inflater, container, false);
    root = binding.getRoot();

//        final TextView textView = binding;
        historyViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar appbar = view.findViewById(R.id.customToolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(appbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView tvTitle = view.findViewById(R.id.tvToolbar);
        tvTitle.setText("History");

        ImageView ivBack = view.findViewById(R.id.btnBack);

        load();
        isiData();

    }

    public void load(){
        recyclerView = root.findViewById(R.id.recTrans);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public void isiData(){
        Call<GetHistory> historyCall = apiInterface.gethistory();
        Log.d("url",historyCall.request().url().toString());
        historyCall.enqueue(new Callback<GetHistory>() {
            @Override
            public void onResponse(Call<GetHistory> call, Response<GetHistory> response) {
//                Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();             historyList = response.body().getData();

                adapter = new HistoryAdapter(getActivity(),response.body().getData());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GetHistory> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}