package org.junit;

import java.security.InvalidParameterException;
import java.text.DecimalFormat;

public class BmiCalculator {
    private DecimalFormat decimalFormat;

    public BmiCalculator() {
        this.decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
    }


    public float calculate(float heightInMeters, float weightInKgs){
        if(heightInMeters>0&&weightInKgs>0) {
            float bmi = weightInKgs / (heightInMeters * heightInMeters);
            float formattedBMI = formatBMI(bmi);
            return bmi;
        }
        else {
            throw new InvalidParameterException("Height and Weight should be greater than zero");
        }
    }





    private float formatBMI(float bmi) {
        return new Float(decimalFormat.format(bmi)).floatValue();
    }
}
