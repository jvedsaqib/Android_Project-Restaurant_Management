package com.example.restaurantmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NewOrderGridViewAdapter extends ArrayAdapter<NewOrderGridView> {


    public NewOrderGridViewAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View gridItemView = convertView;

        if(gridItemView == null)
            gridItemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item_list, parent, false);

        NewOrderGridView dataModal = getItem(position);

        TextView item_name = gridItemView.findViewById(R.id.item_name);
        TextView item_price = gridItemView.findViewById(R.id.item_price);
        TextView item_pieces_or_qty = gridItemView.findViewById(R.id.item_pieces_or_qty);


        item_name.setText(dataModal.getItemName());
        item_price.setText(dataModal.getItemPrice());
        item_pieces_or_qty.setText(dataModal.getItemPiecesOrQty());

        gridItemView.setOnClickListener(v -> {
            // here I will add a small pop up like fragment for qty and adding the order
        });


        return gridItemView;
    }
}
