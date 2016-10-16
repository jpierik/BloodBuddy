package edu.oakland.fives.bloodbuddy.model;

import android.support.annotation.Nullable;

import java.io.Serializable;

/**
 * Created by Serar on 9/25/2016.
 */

public class DataModel implements Serializable {
    private String testName;
    private String testUnits;
    private String analysis;
    private int range;
    private double value;
    private boolean userInput;

    public DataModel() {
    }

    public DataModel(String name, String units, double val) {
        this.testName = name;
        this.testUnits = units;
        this.value = val;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String name) {
        this.testName = name;
    }

    public String getTestUnits() {
        return testUnits;
    }

    public void setTestUnits(String units) {
        this.testUnits = units;
    }


    public double getValue() {
        return value;
    }

    public void setValue(double val) {
        this.value = val;
    }

    public void setAnalysis(String analysis) { this.analysis = analysis; }
    public String getAnalysis() { return this.analysis; }

    public void setRange(int range) { this.range = range; }
    public int getRange() { return this.range; }

    public void setUserInput(boolean userInput) { this.userInput = userInput; }
    public boolean getUserInput() { return this.userInput; }
}
