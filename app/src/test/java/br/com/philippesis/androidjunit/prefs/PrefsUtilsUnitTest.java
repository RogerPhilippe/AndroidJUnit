package br.com.philippesis.androidjunit.prefs;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, sdk = 21)
public class PrefsUtilsUnitTest {

    private Context context = InstrumentationRegistry.getInstrumentation().getContext();

    private PrefsUtils prefsUtils = new PrefsUtils();

    @Test
    public void mainPrefsName() {
        Assert.assertThat(prefsUtils.getMainPrefsName(), Is.is("main-prefs"));
    }

    @Test
    public void mainPrefsKeyTest() {
        Assert.assertThat(prefsUtils.getMainPrefsKey(), Is.is("any-str-value"));
    }

    @Test
    public void mainPrefsTest() {
        Assert.assertThat(prefsUtils.setMainPrefs(context, "Test"), Is.is(true));
    }

    @Test
    public void getMainPrefsTest() {
        Assert.assertThat(prefsUtils.getMainPrefs(context), Is.is(String.class));
    }

}
