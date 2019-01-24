package com.capgemini.molveno.restaurant.Order;

import org.junit.Before;
import org.junit.Test;

public class OverviewTest {
    Overview overview;
    @Before
    public void before(){
        overview = new Overview();
    }
    @Test
    public void printEmptyOverview(){
        overview.printOverview();
    }
}
