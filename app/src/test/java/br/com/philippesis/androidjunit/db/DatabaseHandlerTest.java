package br.com.philippesis.androidjunit.db;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, sdk = 21)
public class DatabaseHandlerTest {

    private DatabaseHandler databaseHandler = null;
    private String databaseName = null;
    private int databaseVersion = -1;

    @Before
    public void init() {
        Context context = ApplicationProvider.getApplicationContext();
        databaseHandler = new DatabaseHandler(context);
        databaseName = DatabaseHandler.DATABASE_NAME;
        databaseVersion = DatabaseHandler.VERSION;
    }

    @Test
    public void createdDatabaseTest() {
        assertNotNull(databaseHandler);
    }

    @Test
    public void databaseExistsTest() {
        assertNotNull(databaseHandler.getReadableDatabase());
    }

    @Test
    public void databaseNameExistsTest() {
        assertNotNull(databaseHandler.getDatabaseName());
    }

    @Test
    public void databaseNameAssertTest() {
        assertEquals(databaseHandler.getDatabaseName(), databaseName);
    }

    @Test
    public void databaseVersionAssertTest() {
        assertEquals(databaseHandler.getReadableDatabase().getVersion(), databaseVersion);
    }

}