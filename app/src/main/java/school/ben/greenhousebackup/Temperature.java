package school.ben.greenhousebackup;

/**
 * Created by Sarah on 2017-06-01.
 */

public class Temperature {
    Double currTemp;
    Double lowerBound;
    Double upperBound;

    public Temperature(){

    }


    //SET METHODS
    public void setCurrTemp(Double temp){
        currTemp = temp;
    }

    public void setLowerBound(Double lBound){
        lowerBound = lBound;
    }

    public void setUpperBound(Double uBound){
        upperBound = uBound;
    }


    //GET METHODS
    public Double getCurrTemp(){
        return currTemp;
    }

    public Double getLowerBound(){
        return lowerBound;
    }

    public Double getUpperBound(){
        return upperBound;
    }


    //this method handles the value checking for the new range, sets values if okay
    public void changeTempRange(Double lower, Double upper){
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
    public Boolean checkCurrTempInRange(){
        if (currTemp < lowerBound || currTemp > upperBound){
            return false;
        }

        return true;

    }



}
