package edu.oakland.fives.bloodbuddy.activity;

import java.util.ArrayList;

import edu.oakland.fives.bloodbuddy.model.DataModel;

public class TestValueAnalysis {

    ArrayList<DataModel> test;

    public TestValueAnalysis(ArrayList<DataModel> test) {
        this.test = test;
    }

    // this is just for testing
    public void printTestArray() {
        for (DataModel value : this.test) {
            System.out.println(value.getTestName());
            System.out.println(value.getValue());
            System.out.println(" -------- ");
        }
    }

}
