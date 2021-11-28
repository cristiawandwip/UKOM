package com.cristiawan.goparty.ui.home;

import android.app.ProgressDialog;
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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.appcompat.app.AppCompatActivity;

import com.cristiawan.goparty.Adapter.BarangAdapter;
import com.cristiawan.goparty.Item;
import com.cristiawan.goparty.Adapter.ItemAdapter;
import com.cristiawan.goparty.Login;
import com.cristiawan.goparty.Model.Barang;
import com.cristiawan.goparty.Model.GetBarang;
import com.cristiawan.goparty.R;
import com.cristiawan.goparty.Rest.ApiClient;
import com.cristiawan.goparty.Rest.ApiInterface;
import com.cristiawan.goparty.databinding.FragmentHomeBinding;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    List<Barang> barangList;
    View root;
    ApiInterface apiInterface;
    BarangAdapter adapter;


    TextView tv5,tv6,tv7;
    ProgressDialog dialog;

    private HomeViewModel homeViewModel;
private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

    binding = FragmentHomeBinding.inflate(inflater, container, false);
    root = binding.getRoot();

       // final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);

                load();
                isiData();

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
        tvTitle.setText("Home");

        ImageView ivBack = view.findViewById(R.id.btnBack);
        ivBack.setOnClickListener(v -> new Login());


//        load();
//        isiData();
    }

//    public void load(){
//        recyclerView = root.findViewById(R.id.recHome);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//    }
//
//    public void isiData(){
//        itemList = new ArrayList<Item>();
//        itemList.add(new Item("Terop 25X25", "Rp.500000","Gedangan, Sidoarjo"));
//        itemList.add(new Item("Terop 25X25", "Rp.500000","Gedangan, Sidoarjo"));
//        itemList.add(new Item("Terop 25X25", "Rp.500000","Gedangan, Sidoarjo"));
//        itemList.add(new Item("Terop 25X25", "Rp.500000","Gedangan, Sidoarjo"));
//        itemList.add(new Item("Terop 25X25", "Rp.500000","Gedangan, Sidoarjo"));
//        itemList.add(new Item("Terop 25X25", "Rp.500000","Gedangan, Sidoarjo"));
//        itemList.add(new Item("Terop 25X25", "Rp.500000","Gedangan, Sidoarjo"));
//        itemList.add(new Item("Terop 25X25", "Rp.500000","Gedangan, Sidoarjo"));
//        itemList.add(new Item("Terop 25X25", "Rp.500000","Gedangan, Sidoarjo"));
//        itemList.add(new Item("Terop 25X25", "Rp.500000","Gedangan, Sidoarjo"));
//        itemList.add(new Item("Terop 25X25", "Rp.500000","Gedangan, Sidoarjo"));
//        adapter = new ItemAdapter(getActivity(),itemList);
//        recyclerView.setAdapter(adapter);
//    }

    public void load(){
        recyclerView = root.findViewById(R.id.recHome);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public void isiData(){
        Call<GetBarang> barangCall = apiInterface.getBarang(

        );
        Log.d("url",barangCall.request().url().toString());
        barangCall.enqueue(new Callback<GetBarang>() {
            @Override
            public void onResponse(Call<GetBarang> call, Response<GetBarang> response) {
//                Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                barangList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(barangList.size()));
               adapter = new BarangAdapter(getActivity(),barangList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GetBarang> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

}