package school.ben.greenhousebackup;

/**
 * Created by Sarah on 2017-06-01.
 */

public class LightLevel {
    Double currLight;
    Double lowerBound;
    Double upperBound;

    public LightLevel(){

    }


    public void setCurrLight(Double light){
        currLight = light;
    }

    public void setLowerBound(Double lBound){
        lowerBound = lBound;
    }

    public void setUpperBound(Double uBound){
        upperBound = uBound;
    }

    public Double getCurrLight(){
        return currLight;
    }

    public Double getLowerBound(){
        return lowerBound;
    }

    public Double getUpperBound(){
        return upperBound;
    }


    //this method handles the value checking for the new range, sets values if okay
    public void changeLightRange(Double lower, Double upper){
        if (lower >= upper){
            //ERROR WITH RANGE, handle this with UI
        }
        else {
            setLowerBound(lower);
            setUpperBound(upper);
            //need to show in UI that this was success
        }

    }


    //this method checks if the current temperature is within the acceptable range
    public Boolean checkCurrLightInRange(){
        if (currLight < lowerBound || currLight > upperBound){
            return false;
        }

        return true;

    }
}
