package com.example.navigation;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.navigation.ui.database.Logger;
import com.example.navigation.ui.database.Database_Handler;

import java.util.ArrayList;

public class loginFragment extends Fragment implements View.OnClickListener{
    Database_Handler helper;
    EditText  email, password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_login, container, false);

        Button login_button = (Button) layout.findViewById(R.id.btn_login);
        login_button.setOnClickListener(this);

        return layout;
    }
    @Override
    public void onClick(View view) {
        authenticate();
    }

    public void authenticate(){
        email = getActivity().findViewById(R.id.et_email);
        password = getActivity().findViewById(R.id.et_password);
        helper = new Database_Handler(getContext());
        Button login_button = getActivity().findViewById(R.id.btn_login);
        login_button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                String a = email.getText().toString();
                String b = password.getText().toString();
                String entry = a+" "+b;

                if(a.isEmpty()){
                    Logger.message(getActivity(),"Enter Email");
                } if(b.isEmpty()){
                    Logger.message(getActivity(),"Enter Password");
                } else {
                    ArrayList data = helper.getAuth();
                    if(getAuthentication(entry,data)){
                        Logger.message(getActivity(),"Login Successful");
                    }
                    else {
                        Logger.message(getActivity(),"Incorrect details entered");
                    }
                }
            }
        });
    }
    public static boolean getAuthentication(String a, ArrayList b){                                 //checks if database contains details provided and returns boolean
        if(b.contains(a)){
            return true;
        }else{
            return false;
        }
    }
}

