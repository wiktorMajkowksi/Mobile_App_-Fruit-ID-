package com.example.navigation.ui.database;

import android.content.Context;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class Logger {
    /*
        displays message at the bottom section of scree (For String input)
    */
    public static void message(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    /*
        displays message at the bottom section of scree (For arrayList input)
        (It was used for debugging login authentication)
    */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void message2(Context context, ArrayList message) {
        String messageS = String.join("\t", message);
        Toast.makeText(context, messageS, Toast.LENGTH_LONG).show();
    }
}