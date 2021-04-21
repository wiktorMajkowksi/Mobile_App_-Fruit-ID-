package com.example.navigation.ui.database;

import android.content.Context;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class Message {
    public static void message(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void message2(Context context, ArrayList message) {
        String messageS = String.join("\t", message);
        Toast.makeText(context, messageS, Toast.LENGTH_LONG).show();
    }
}