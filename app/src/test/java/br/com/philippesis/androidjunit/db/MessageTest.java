package br.com.philippesis.androidjunit.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, sdk = 21)
public class MessageTest {

    private Message messageMock = Mockito.mock(Message.class);

    @Test
    public void toStringTst() {
        Mockito.doCallRealMethod().when(messageMock).toString();
        messageMock.toString();
    }

    @Test
    public void isValid() {
        Mockito.doCallRealMethod().when(messageMock).isValid();
        messageMock.isValid();
    }

    @Test
    public void setGetTest() {
        int id = 1;
        String msg = "Any";
        int status = 1;
        Message message = new Message();
        message.setId(id);
        message.setMessage(msg);
        message.setStatus(status);
        assertThat(message.getId(), is(status));
        assertThat(message.getMessage(), is(msg));
        assertThat(message.getStatus(), is(status));

    }

}
