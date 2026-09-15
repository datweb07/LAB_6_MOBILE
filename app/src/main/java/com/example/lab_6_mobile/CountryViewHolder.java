package com.example.lab_6_mobile;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private MyAdapter myAdapter;
    public TextView txtId;
    public TextView txtCountry;

    public CountryViewHolder(View item, MyAdapter adapter) {
        super(item);
        this.myAdapter = adapter;
        this.txtId = item.findViewById(R.id.txtId);
        this.txtCountry  = item.findViewById(R.id.txtCountry);
        item.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String msg = txtId.getText() + " | " + txtCountry.getText();
        Toast.makeText(view.getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
