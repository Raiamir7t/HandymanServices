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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentShowAllUsers#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentShowAllUsers extends Fragment {

    private RecyclerView recyclerViewHandyman;
    private HandyManAdapter handymanAdapter;
    private List<HandyMan> handymanList;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentShowAllUsers() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentShowAllUsers.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentShowAllUsers newInstance(String param1, String param2) {
        FragmentShowAllUsers fragment = new FragmentShowAllUsers();
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
        View view = inflater.inflate(R.layout.fragment_show_all_users, container, false);

        // Initialize the RecyclerView
        recyclerViewHandyman = view.findViewById(R.id.recyclerViewUsers2);
        boolean searchedDetails=false;
        Bundle args = getArguments();
             handymanList = (ArrayList<HandyMan>) args.getSerializable("handymanList");

        if(handymanList==null){
            handymanList = new ArrayList<>();
            handymanList.add(new HandyMan("HandyMan 1", 4.5f, 5, 28.7041, 77.1025));
            handymanList.add(new HandyMan("HandyMan 2", 4.0f, 3, 28.7041, 77.1025));
            handymanList.add(new HandyMan("HandyMan 3", 3.5f, 1, 28.7041, 77.1025));
            // Add more HandyMan objects as needed
        int w=0;
        }
            handymanAdapter = new HandyManAdapter(requireContext(), handymanList);
            recyclerViewHandyman.setAdapter(handymanAdapter);

            // Set layout manager
            recyclerViewHandyman.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Create sample HandyMan data
        int w=0;
        // Create and set up the adapter

        return view;
    }
}