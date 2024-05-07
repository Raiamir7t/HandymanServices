package com.example.handyman;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link scheduleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class scheduleFragment extends Fragment {

    private RecyclerView recyclerView;
    private CustomAdapter adapter;

    List<DataModel> dataList;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public scheduleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment scheduleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static scheduleFragment newInstance(String param1, String param2) {
        scheduleFragment fragment = new scheduleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);


        int w=0;

        recyclerView = view.findViewById(R.id.recyclerViewFS);
        w=0;
        // Initialize RecyclerView adapter with your data
        dataList = new ArrayList<>();
        dataList.add(new DataModel("Service A", "2024-04-20", "9AM-5PM"));
        dataList.add(new DataModel("Service B", "2024-04-21", "10AM-6PM"));
        dataList.add(new DataModel("Service C", "2024-04-22", "11AM-7PM"));


        w=0;
        // Populate this list with your data
        adapter = new CustomAdapter(dataList);
        w=0;
        // Set the RecyclerView adapter
        recyclerView.setAdapter(adapter);
        w=0;
        // Optionally, set the layout manager for the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        return view;
    }

}