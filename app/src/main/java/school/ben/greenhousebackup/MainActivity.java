package school.ben.greenhousebackup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*Need the following methods, should be added to the appropriate class:
    1) getHexiTemp, getHexiHumidity, getHexiLight
        these methods should return the actual values that the hexi sensor is currently reading

    2) getTempLowerBound, getHumidityLowerBound, getLightLowerBound
    3) getTempUpperBound, getHumidityUpperBound, getLightUpperBound
        these methods should return the currently STORED in our database

    4) getCurrentGraphContext
        returns "Current" or "Historic" depending on the current state of the graph
    5) set



     */

}
