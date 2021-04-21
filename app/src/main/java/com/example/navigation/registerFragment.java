package com.example.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.navigation.ui.database.Message;
import com.example.navigation.ui.database.myDbAdapter;

public class registerFragment extends Fragment implements View.OnClickListener {

    EditText Name, Pass , Email, Re_Pass;
    myDbAdapter helper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_register, container, false);
        Button button = (Button) layout.findViewById(R.id.btn_register);
        button.setOnClickListener(this);
        return layout;
    }

    @Override
    public void onClick(View view) {
        register();
    }

    public void register()
    {
        Name = (EditText) getActivity().findViewById(R.id.et_name);
        Pass = (EditText) getActivity().findViewById(R.id.et_password);
        Re_Pass = (EditText) getActivity().findViewById(R.id.et_repassword);
        Email = (EditText) getActivity().findViewById(R.id.et_email);

        helper = new myDbAdapter(getContext());
        Button button = getActivity().findViewById(R.id.btn_register);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

        String t1 = Name.getText().toString();
        String t2 = Pass.getText().toString();
        String t3 = Re_Pass.getText().toString();
        String t4 = Email.getText().toString();

        if(t1.isEmpty() || t2.isEmpty() || t3.isEmpty() || t4.isEmpty()){
            Message.message(getActivity(), "Fill the form");
        }
        else
        {
            long id = helper.insertData(t1,t2,t3,t4);
            if(id<=0)
            {
                Message.message(getActivity(),"Insertion Unsuccessful");
                Name.setText("");
                Pass.setText("");
                Re_Pass.setText("");
                Email.setText("");
            } else
            {
                Message.message(getActivity(),"Insertion Successful");
                Name.setText("");
                Pass.setText("");
                Re_Pass.setText("");
                Email.setText("");
            }
        }
    }});
    }


}
