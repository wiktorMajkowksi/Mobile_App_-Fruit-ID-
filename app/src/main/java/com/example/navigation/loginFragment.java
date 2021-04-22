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

import com.example.navigation.ui.database.Message;
import com.example.navigation.ui.database.myDbAdapter;

import java.util.ArrayList;

public class loginFragment extends Fragment implements View.OnClickListener{
    myDbAdapter helper;
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

    public void authenticate(){
        email = getActivity().findViewById(R.id.et_email);
        password = getActivity().findViewById(R.id.et_password);
        helper = new myDbAdapter(getContext());
        Button login_button = getActivity().findViewById(R.id.btn_login);
        login_button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                String a = email.getText().toString();
                String b = password.getText().toString();
                String entry = a+" "+b;

                if(a.isEmpty()){
                    Message.message(getActivity(),"Enter Email");
                } if(b.isEmpty()){
                    Message.message(getActivity(),"Enter Password");
                } else {
                    ArrayList data = helper.getAuth();
                    if(getAuthentication(entry,data)){
                        Message.message(getActivity(),"Login Successful");
                    }
                    else {
                        Message.message(getActivity(),"Incorrect details entered");
                    }
                }
            }
        });
    }
    public static boolean getAuthentication(String a, ArrayList b){
        if(b.contains(a)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void onClick(View view) {
        authenticate();
    }
}

