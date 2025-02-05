package com.duolingo.app.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.duolingo.app.R;
import com.duolingo.app.model.Language;
import com.duolingo.app.ui.perfil.PerfilFragment;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<Language> {

    public SpinnerAdapter (Context context, ArrayList<Language> arrayLanguages){
        super(context, 0, arrayLanguages);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.spinner_row, parent, false
            );
        }

        ImageView ivFlag = convertView.findViewById(R.id.ivFlag);
        TextView tvLangName = convertView.findViewById(R.id.tvLangName);

        Language currentItem = (Language) getItem(position);

        if (currentItem != null){
            ivFlag.setImageBitmap(PerfilFragment.arrayFlags.get(position));
            tvLangName.setText(currentItem.getCodeLanguage());
        }

        return convertView;

    }
}
