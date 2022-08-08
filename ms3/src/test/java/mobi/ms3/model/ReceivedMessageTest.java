package mobi.ms3.model;

import mobi.ms3.enums.Ms;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.springframework.test.util.AssertionErrors.assertEquals;

class ReceivedMessageTest {

    @Test
    void testConstructer_setProperly() throws NoSuchFieldException, IllegalAccessException{
        final ReceivedMessage message = new ReceivedMessage("1", "hello", Ms.MS1, Ms.MS2);

        final Field fieldId = message.getClass().getDeclaredField("id");
        final Field fieldReachingMsg = message.getClass().getDeclaredField("reachingMsg");
        final Field fieldSource = message.getClass().getDeclaredField("source");
        final Field fieldDestination = message.getClass().getDeclaredField("dst");

        fieldId.setAccessible(true);
        fieldReachingMsg.setAccessible(true);
        fieldSource.setAccessible(true);
        fieldDestination.setAccessible(true);


        assertEquals("Fields didn't match", fieldId.get(message), "1");
        assertEquals("Fields didn't match", fieldReachingMsg.get(message), "hello");
        assertEquals("Fields didn't match", fieldSource.get(message), Ms.MS1);
        assertEquals("Fields didn't match", fieldDestination.get(message), Ms.MS2);

    }

    @Test
    void testSetters_setsProperly() throws NoSuchFieldException, IllegalAccessException {
        //given
        final ReceivedMessage message = new ReceivedMessage();

        //when
        message.setId("1");
        message.setReachingMsg("hello");
        message.setSource(Ms.MS2);
        message.setDst(Ms.MS3);

        //then
        final Field fieldId = message.getClass().getDeclaredField("id");
        final Field fieldReachingMsg = message.getClass().getDeclaredField("reachingMsg");
        final Field fieldSource = message.getClass().getDeclaredField("source");
        final Field fieldDestination = message.getClass().getDeclaredField("dst");


        fieldId.setAccessible(true);
        fieldReachingMsg.setAccessible(true);
        fieldSource.setAccessible(true);
        fieldDestination.setAccessible(true);

        assertEquals("Fields didn't match", fieldId.get(message), "1");
        assertEquals("Fields didn't match", fieldReachingMsg.get(message), "hello");
        assertEquals("Fields didn't match", fieldSource.get(message), Ms.MS2);
        assertEquals("Fields didn't match", fieldDestination.get(message), Ms.MS3);
    }

    @Test
    void testGetters_getsValue() throws NoSuchFieldException, IllegalAccessException {
        //given
        final ReceivedMessage message = new ReceivedMessage();

        final Field fieldId = message.getClass().getDeclaredField("id");
        final Field fieldReachingMsg = message.getClass().getDeclaredField("reachingMsg");
        final Field fieldSource = message.getClass().getDeclaredField("source");
        final Field fieldDestination = message.getClass().getDeclaredField("dst");

        fieldId.setAccessible(true);
        fieldReachingMsg.setAccessible(true);
        fieldSource.setAccessible(true);
        fieldDestination.setAccessible(true);

        fieldId.set(message, "1");
        fieldReachingMsg.set(message, "Hello");
        fieldSource.set(message, Ms.MS1);
        fieldDestination.set(message, Ms.MS2);

        //when
        final String gettingId = message.getId();
        final String gettingReachingMsg = message.getReachingMsg();
        final Ms gettingSource = message.getSource();
        final Ms gettingDestination = message.getDst();


        //then
        assertEquals("field wasn't retrieved properly", gettingId, "1");
        assertEquals("field wasn't retrieved properly", gettingReachingMsg, "Hello");
        assertEquals("field wasn't retrieved properly", gettingSource, Ms.MS1);
        assertEquals("field wasn't retrieved properly", gettingDestination, Ms.MS2);
    }
}
