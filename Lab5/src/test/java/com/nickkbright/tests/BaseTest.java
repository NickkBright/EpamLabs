package com.nickkbright.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("Test is starting!");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("Test is ending!");

    }
}