package com.example.navigation;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class registerFragmentTest {

    @Test
    public void isPasswordValid_lowercase() {
        assertTrue(registerFragment.isPasswordValid("password","password"));
    }
    @Test
    public void isPasswordValid_uppercase() {
        assertTrue(registerFragment.isPasswordValid("PASSWORD","PASSWORD"));
    }
    @Test
    public void isPasswordValid_password_no_match() {
        assertFalse(registerFragment.isPasswordValid("something","PASSWORD"));
    }
    @Test
    public void isPasswordValid_minimal_difference() {
        assertFalse(registerFragment.isPasswordValid("PASSsWORD","PASSWORD"));
    }
    @Test
    public void isPasswordValid_empty() {
        assertFalse(registerFragment.isPasswordValid("",""));
    }

}