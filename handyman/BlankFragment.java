package com.example.handyman;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    private RecyclerView recyclerViewHandyman;
    private UserAdapter handymanAdapter;
    private List<Service> ServiceList;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
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
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        recyclerViewHandyman = view.findViewById(R.id.recyclerViewUsers);

        // Create sample user data
        ServiceList = new ArrayList<>();

        ServiceList.add(new Service("Service 1", R.drawable.ic_launcher_background));
        ServiceList.add(new Service("Service 2", R.drawable.ic_launcher_background));
        ServiceList.add(new Service("Service 3", R.drawable.ic_launcher_background));
        ServiceList.add(new Service("Service 4", R.drawable.ic_launcher_background));
        ServiceList.add(new Service("Service 5", R.drawable.ic_launcher_background));
        ServiceList.add(new Service("Service 6", R.drawable.ic_launcher_background));
        ServiceList.add(new Service("Service 7", R.drawable.ic_launcher_background));
        ServiceList.add(new Service("Service 8", R.drawable.ic_launcher_background));
        ServiceList.add(new Service("Service 9", R.drawable.ic_launcher_background));

        // Add more Services as needed

        // Create and set up the adapter
        handymanAdapter = new UserAdapter(getActivity(), ServiceList);
        recyclerViewHandyman.setAdapter(handymanAdapter);

        // Set layout manager
        recyclerViewHandyman.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        return view;
    }

}