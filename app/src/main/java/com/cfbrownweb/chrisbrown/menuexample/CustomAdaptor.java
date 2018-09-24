package com.cfbrownweb.chrisbrown.menuexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdaptor extends ArrayAdapter<String> {
    public CustomAdaptor(Context context, String[] items) {
        super(context, R.layout.custom_list_item, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_list_item, parent, false);

        String item = getItem(position);
        TextView description = customView.findViewById(R.id.item_text);
        ImageView img = customView.findViewById(R.id.item_image);

        //Set menu item text and image
        description.setText(item);
        description.setId(View.generateViewId());
        img.setImageResource(R.drawable.something);

        return customView;
    }
}
