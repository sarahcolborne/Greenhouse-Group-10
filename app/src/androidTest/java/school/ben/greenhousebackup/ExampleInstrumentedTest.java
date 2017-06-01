package school.ben.greenhousebackup;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("school.ben.greenhousebackup", appContext.getPackageName());
    }

    @Test
    public void UIHomeTemperature() throws Exception {
        //need to get the actual value from the sensor
        //getHexiLight is some method to obtain current data...

        onView(withId(R.id.valueCurrTemp)).check(matches(withText(getHexiTemp)));

    }

    @Test
    public void UIHomeHumidity() throws Exception {
        //need to get the actual value from the sensor
        //getHexiLight is some method to obtain current data...

        onView(withId(R.id.valueCurrHumidity)).check(matches(withText(getHexiHumidity)));

    }

    @Test
    public void UIHomeLight() throws Exception {
        //need to get the actual value from the sensor
        //getHexiLight is some method to obtain current data...

        onView(withId(R.id.valueCurrLight)).check(matches(withText(getHexiTemp())));

    }

    @Test
    public void UITempRange() throws Exception {
        //FIRST: Test that current displayed values match the current stored temp range data
        //need a method to return the lower range value for temp (getTempLowerBoundMethod)
        //need text that displays temp lower range (currTempRangeLower)
        onView(withId(R.id.currTempRangeLower)).check(matches(withText(getTempLowerBoundMethod())));
        //need a method to return the upper range value for temp
        onView(withId(R.id.currTempRangeUpper)).check(matches(withText(getTempUpperBoundMethod())));


        //SECOND: Change the range and retest the stored and displayed values
        //need fields for new lower and upper values
        onView(withId(R.id.enterTempLowerBound)).perform(typeText("5"));
        onView(withId(R.id.enterTempUpperBound)).perform(typeText("20"));
        onView(withId(R.id.submitTempBounds)).perform(click());

        //check field values with stored values
        onView(withId(R.id.enterTempLowerBound)).check(matches(withText(getTempLowerBoundMethod())));
        onView(withId(R.id.enterTempUpperBound)).check(matches(withText(getTempUpperBoundMethod())));

        //check stored values with displayed values
        onView(withId(R.id.currTempRangeLower)).check(matches(withText(getTempLowerBoundMethod())));
        onView(withId(R.id.currTempRangeUpper)).check(matches(withText(getTempUpperBoundMethod())));

        //maybe we want to have a text notification to say it was updated?
        onView(withId(R.id.resultTempRangeText)).check(matches(withText("Temperature range updated successfully")));

    }

    @Test
    public void UIHumidityRange() throws Exception {
        //FIRST: Test that current displayed values match the current stored humidity range data
        //need a method to return the lower range value for humidity (getHumidityLowerBoundMethod)
        //need text that displays humidity lower range (currHumidityRangeLower)
        onView(withId(R.id.currHumidityRangeLower)).check(matches(withText(getHumidityLowerBoundMethod())));
        //need a method to return the upper range value for temp
        onView(withId(R.id.currTempRangeUpper)).check(matches(withText(getTempUpperBoundMethod())));


        //SECOND: Change the range and retest the stored and displayed values
        //need fields for new lower and upper values
        onView(withId(R.id.enterHumidityLowerBound)).perform(typeText("5"));
        onView(withId(R.id.enterHumidityUpperBound)).perform(typeText("20"));
        onView(withId(R.id.submitHumidityBounds)).perform(click());

        //check field values with stored values
        onView(withId(R.id.enterHumidityLowerBound)).check(matches(withText(getTempHumidityBoundMethod())));
        onView(withId(R.id.enterHumidityUpperBound)).check(matches(withText(getTempHumidityBoundMethod())));

        //check stored values with displayed values
        onView(withId(R.id.currHumidityRangeLower)).check(matches(withText(getHumidityLowerBoundMethod())));
        onView(withId(R.id.currHumidityRangeUpper)).check(matches(withText(getHumidityUpperBoundMethod())));

        //maybe we want to have a text notification to say it was updated?
        onView(withId(R.id.resultHumidityRangeText)).check(matches(withText("Humidity range updated successfully")));

    }

    @Test
    public void UILightRange() throws Exception {
        //FIRST: Test that current displayed values match the current stored light range data
        //need a method to return the lower range value for light (getLightLowerBoundMethod)
        //need text that displays temp lower range (currLightRangeLower)
        onView(withId(R.id.currLightRangeLower)).check(matches(withText(getLightLowerBoundMethod())));
        //need a method to return the upper range value for light
        onView(withId(R.id.currLightRangeUpper)).check(matches(withText(getLightUpperBoundMethod())));


        //SECOND: Change the range and retest the stored and displayed values
        //need fields for new lower and upper values
        onView(withId(R.id.enterLightLowerBound)).perform(typeText("5"));
        onView(withId(R.id.enterLightUpperBound)).perform(typeText("20"));
        onView(withId(R.id.submitLightBounds)).perform(click());

        //check field values with stored values
        onView(withId(R.id.enterLightLowerBound)).check(matches(withText(getLightLowerBoundMethod())));
        onView(withId(R.id.enterLightUpperBound)).check(matches(withText(getLightUpperBoundMethod())));

        //check stored values with displayed values
        onView(withId(R.id.currLightRangeLower)).check(matches(withText(getLightLowerBoundMethod())));
        onView(withId(R.id.currLightRangeUpper)).check(matches(withText(getLightUpperBoundMethod())));

        //maybe we want to have a text notification to say it was updated?
        onView(withId(R.id.resultLightRangeText)).check(matches(withText("Light level range updated successfully")));

    }



    @Test
    public void graphContextSwitch() throws Exception {
        //press Current context button to initalize in this state
        onView(withId(R.id.graphContextGraphCurrent)).perform(click());

        //some method to get the current context of the graph that returns "Current" or "Historic"
        assertEquals(getCurrentGraphContext(), "Current");

        //Now switch the context to Historic and check
        onView(withId(R.id.graphContextHistoric)).perform(click());
        assertEquals(getCurrentGraphContext(), "Historic");

    }


}
