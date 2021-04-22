package com.example.navigation.ui.home;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.navigation.R;

public class HomeFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        TextView textView = root.findViewById(R.id.welcome_text);
        textView.setText("Welcome to FruitID");
        ImageView imageView = root.findViewById(R.id.app_logo);
        imageView.setImageBitmap(BitmapFactory.decodeFile("D:\\Year3\\AppDEV\\V1\\V1Complete\\app\\src\\main\\res\\mipmap-anydpi-v26"));

        return root;
    }
}

