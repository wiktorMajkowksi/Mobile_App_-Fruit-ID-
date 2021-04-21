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

public class loginFragment extends Fragment implements View.OnClickListener{
    myDbAdapter helper;
    EditText delete, email, password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_login, container, false);

        Button login_button = (Button) layout.findViewById(R.id.btn_login);
        login_button.setOnClickListener(this);

        return layout;
    }
    public void viewData() {
        helper = new myDbAdapter(getContext());
        Button button_view_data = getActivity().findViewById(R.id.view_data);
        button_view_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = helper.getData();
                Message.message(getContext(), data);
            }
        });
    }
    public void delete()
    {
        delete = getActivity().findViewById(R.id.et_email);
        helper = new myDbAdapter(getContext());
        Button delete_button = getActivity().findViewById(R.id.btn_delete);
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = delete.getText().toString();

                if(uname.isEmpty())
                {
                    Message.message(getActivity(),"Enter Data");
                }
                else{
                    int a= helper.delete(uname);
                    if(a<=0)
                    {
                        Message.message(getActivity(),"Unsuccessful");
                        delete.setText("");
                    }
                    else
                    {
                        Message.message(getContext(), "DELETED");
                        delete.setText("");
                    }
                }
            }
        });
    }


    @Override
    public void onClick(View view) {
        viewData();
        delete();
    }
}

