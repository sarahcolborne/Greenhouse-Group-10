package school.ben.greenhousebackup;

/**
 * Created by Sarah on 2017-06-01.
 */

public class Humidity {
    Double currHumidity;
    Double lowerBound;
    Double upperBound;


    public Humidity(){

    }

    public void setCurrHumidity(Double humidity){
        currHumidity = humidity;
    }

    public void setLowerBound(Double lBound){
        lowerBound = lBound;
    }

    public void setUpperBound(Double uBound){
        upperBound = uBound;
    }

    public Double getCurrHumidity(){
        return currHumidity;
    }

    public Double getLowerBound(){
        return lowerBound;
    }

    public Double getUpperBound(){
        return upperBound;
    }

    //this method handles the value checking for the new range, sets values if okay
    public void changeHumidityRange(Double lower, Double upper){
        if (lower >= upper){
            //ERROR WITH RANGE, handle this with UI
        }
        else {
            setLowerBound(lower);
            setUpperBound(upper);
            //need to show in UI that this was success
        }

    }


    //this method checks if the current humidity is within the acceptable range
    public Boolean checkCurrHumidityInRange(){
        if (currHumidity < lowerBound || currHumidity > upperBound){
            return false;
        }

        return true;

    }

}
