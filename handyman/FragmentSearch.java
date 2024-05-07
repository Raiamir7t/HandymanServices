package com.example.handyman;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSearch#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSearch extends Fragment {

    private Spinner spinnerCity;
    private Spinner spinnerSearch;
    private Button buttonSearch;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentSearch() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentSearch.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSearch newInstance(String param1, String param2) {
        FragmentSearch fragment = new FragmentSearch();
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
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        // Initialize views
        spinnerCity = view.findViewById(R.id.spinnerCity);
        spinnerSearch = view.findViewById(R.id.spinnerSearch);
        buttonSearch = view.findViewById(R.id.buttonSearch);

        // Populate the city spinner with items
        List<String> cities = new ArrayList<>();
        cities.add("Rawalpindi");
        cities.add("Islamabad");
        cities.add("Lahore");

        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, cities);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(cityAdapter);

        // Populate the search options spinner with items
        List<String> searchOptions = new ArrayList<>();
        searchOptions.add("Floaring");
        searchOptions.add("Plumbering");
        searchOptions.add("Welding");

        ArrayAdapter<String> searchAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, searchOptions);
        searchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSearch.setAdapter(searchAdapter);

        // Set up your button click listener here
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            // call api function here






                ArrayList<HandyMan> handyManList = new ArrayList<>();

                // Add sample records
                handyManList.add(new HandyMan("John", 20.0, 4, 40.7128, -74.0060));
                handyManList.add(new HandyMan("Alice", 25.0, 5, 34.0522, -118.2437));
                handyManList.add(new HandyMan("Bob", 30.0, 3, 41.8781, -87.6298));



                FragmentShowAllUsers newFragment = new FragmentShowAllUsers();

// Create a bundle to pass data to the new fragment
                Bundle args = new Bundle();
                args.putSerializable("handymanList", handyManList);
                newFragment.setArguments(args);

// Get the fragment manager
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

// Begin a transaction to replace the current fragment with the new one
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.mainFragement, newFragment); // Replace R.id.fragment_container with the ID of your container layout
                transaction.addToBackStack(null); // Optionally, add the transaction to the back stack
                transaction.commit();



            }
        });

        return view;
    }
}
