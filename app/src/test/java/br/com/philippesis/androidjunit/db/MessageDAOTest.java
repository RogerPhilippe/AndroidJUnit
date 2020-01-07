package br.com.philippesis.androidjunit.db;

import android.content.Context;
import android.database.Cursor;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, sdk = 21)
public class MessageDAOTest {

    private Context context = ApplicationProvider.getApplicationContext();
    private Message messageMock = Mockito.mock(Message.class);
    private MessageDAO daoMock = Mockito.mock(MessageDAO.class);

    @Test
    public void messageDAOExists() {
        new MessageDAO();
    }

    @Test
    public void insertTest() {
       //Mockito.when(daoMock.insert(context, messageMock)).thenReturn(true);
        Mockito.doCallRealMethod().when(daoMock).insert(context, messageMock);
        daoMock.insert(context, messageMock);

    }

    @Test
    public void findAllTest() {
        //Mockito.when(daoMock.findAll(context)).thenReturn(new ArrayList<Message>());
        Mockito.doCallRealMethod().when(daoMock).findAll(context);
        daoMock.findAll(context);
    }

    @Test
    public void findById() {
        Mockito.doCallRealMethod().when(daoMock).findById(context, 1);
        daoMock.findById(context, 1);
    }

    @Test
    public void delete() {
        Mockito.doCallRealMethod().when(daoMock).delete(context, messageMock);
        daoMock.delete(context, messageMock);
    }

    @Test
    public void update() {
        Mockito.doCallRealMethod().when(daoMock).update(context, messageMock);
        daoMock.update(context, messageMock);
    }

    @Test
    public void handlerCursor() {
        Cursor cursorMock = Mockito.mock(Cursor.class);
        Mockito.doCallRealMethod().when(daoMock).handlerCursor(cursorMock);
        daoMock.handlerCursor(cursorMock);
    }

}
