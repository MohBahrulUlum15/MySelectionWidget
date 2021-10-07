package com.rememberdev.myselectionwidget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProgrammingLanguageAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<com.rememberdev.myselectionwidget.ProgrammingLanguange> progLang = new ArrayList<>();

    //setter hasil generate
    public void setHeroes(ArrayList<com.rememberdev.myselectionwidget.ProgrammingLanguange> heroes){
        this.progLang = heroes;
    }

    public ProgrammingLanguageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return progLang.size();
    }

    @Override
    public Object getItem(int position) {
        return progLang.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_programming_language, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        com.rememberdev.myselectionwidget.ProgrammingLanguange proLanguage = (com.rememberdev.myselectionwidget.ProgrammingLanguange) getItem(position);
        viewHolder.bind(proLanguage);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private CircleImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(ProgrammingLanguange programmingLanguange) {
            txtName.setText(programmingLanguange.getName());
            txtDescription.setText(programmingLanguange.getDescription());
            imgPhoto.setImageResource(programmingLanguange.getPhoto());
        }
    }
}
