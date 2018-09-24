package com.cfbrownweb.chrisbrown.menuexample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import android.support.test.espresso.accessibility.AccessibilityChecks;
//import static org.hamcrest.Matchers.anything;
//import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.*;

@RunWith(AndroidJUnit4.class)
public class ListViewUITest {

    @BeforeClass
    public static void enableAccessibilityChecks(){
        AccessibilityChecks.enable().setRunChecksFromRootView(true);
    }

    @Rule
    public ActivityTestRule<ListViewActivity> mActivityRule =
            new ActivityTestRule<>(ListViewActivity.class);

    @Test
    public void listItemClicksDisplayToast() {
        String[] items = {"Something", "Something else", "Another thing", "Why not another?"};

        for(int i = 0; i < items.length; i++){
            String item = items[i];
            onData(hasToString(item)).inAdapterView(withId(R.id.list_view)).perform(click());

//            if(i == 2){
//                item = "asdas"; //Causes this to fail for 'Another thing'
//            }
            onView(withText(item)).inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));
        }
    }
}
