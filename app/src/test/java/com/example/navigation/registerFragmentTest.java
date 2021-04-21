package com.example.navigation;

import org.junit.Test;

import static org.junit.Assert.*;

public class registerFragmentTest {
    @Test
    public void isPasswordValid_lowercase() {
        assertTrue(registerFragment.isPasswordValid("password","password"));
    }
    @Test
    public void isPasswordValid_uppercase() {
        assertTrue(registerFragment.isPasswordValid("PASSWORD","PASSWORD"));
    }

}