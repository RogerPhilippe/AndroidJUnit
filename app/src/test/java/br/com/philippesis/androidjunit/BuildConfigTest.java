package br.com.philippesis.androidjunit;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class BuildConfigTest {

    @Test
    public void buildConfigExists() {
        Assert.assertNotNull(BuildConfig.class);
    }

    @Test
    public void isDebug() {
        Assert.assertThat(BuildConfig.DEBUG, Is.is(true));
    }

}
