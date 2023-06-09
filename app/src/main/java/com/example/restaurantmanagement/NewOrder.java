
package com.example.restaurantmanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewOrder#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewOrder extends Fragment {

    View view;
    GridView gridView;
    ArrayList<NewOrderGridView> dataList;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewOrder() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewOrder.
     */
    // TODO: Rename and change types and number of parameters
    public static NewOrder newInstance(String param1, String param2) {
        NewOrder fragment = new NewOrder();
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

        //gridView = getActivity().findViewById(R.id.gridView);

        dataList = new ArrayList<>();

        loadDataInGridView();


    }

    private void loadDataInGridView() {

        FirebaseDatabase.getInstance().getReference("food-items").get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                String item_name = "";
                String item_price = "";
                String piecesorqty = "";

                for(DataSnapshot i : dataSnapshot.getChildren()){
                    item_name = i.getKey().toString();
                    Log.d("item_name", i.getKey().toString());

                    item_name = i.getKey().toString();
                    for(DataSnapshot iChild : i.getChildren()){
                       if(iChild.getKey().equals("piecesorqty")) {
                           piecesorqty = iChild.getValue().toString();
                           Log.d("piecesorqty", iChild.getKey().toString() + " " + iChild.getValue().toString());
                       }
                        if(iChild.getKey().equals("price")) {
                            item_price = iChild.getValue().toString();
                            Log.d("price", iChild.getKey().toString() + " " + iChild.getValue().toString());
                        }
                    }
                    Log.d("Datalist", item_name + " " + item_price + " " + piecesorqty);
                    dataList.add(new NewOrderGridView(item_name, item_price, piecesorqty, ""));
                }

                Log.d("getContext", getActivity().toString());
                Log.d("Datalist list", dataList.get(0).getItemName());
                NewOrderGridViewAdapter adapter = new NewOrderGridViewAdapter(getActivity(), dataList);
                Log.d("adapter", adapter.toString());
                gridView.setAdapter(adapter);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_order, container, false);
        gridView = view.findViewById(R.id.gridView);

        return view;
//        return inflater.inflate(R.layout.fragment_new_order, container, false);
    }
}