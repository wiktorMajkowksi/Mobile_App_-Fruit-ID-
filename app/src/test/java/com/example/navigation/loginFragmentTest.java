package com.example.navigation;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class loginFragmentTest {
    @Test
    public void isAuth(){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Login");
        arr.add("Login Pass");
        arr.add("L p  p s");
        arr.add("LoginPass");
        arr.add("Login  Pass");
        assertTrue(loginFragment.getAuthentication("Login Pass", arr));
    }
    @Test
    public void isNotAuth(){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Login");
        arr.add("Login Pass");
        arr.add("L p  p s");
        arr.add("LoginPass");
        arr.add("Login  Pass");
        assertFalse(loginFragment.getAuthentication("NOTLogin NOTPass", arr));
    }
}
