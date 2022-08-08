package mobi.ms3.model;

import mobi.ms3.enums.Ms;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.springframework.test.util.AssertionErrors.assertEquals;


class MessageTest {
    @Test
    void testConstructer_setProperly() throws NoSuchFieldException, IllegalAccessException{
        final Message message = new Message("1", "hello", Ms.MS1, Ms.MS2, 0);

        final Field fieldId = message.getClass().getDeclaredField("id");
        final Field fieldBody = message.getClass().getDeclaredField("body");
        final Field fieldSource = message.getClass().getDeclaredField("source");
        final Field fieldDestination = message.getClass().getDeclaredField("destination");
        final Field fieldCounter = message.getClass().getDeclaredField("counter");



        fieldId.setAccessible(true);
        fieldBody.setAccessible(true);
        fieldSource.setAccessible(true);
        fieldDestination.setAccessible(true);
        fieldCounter.setAccessible(true);


        assertEquals("Fields didn't match", fieldId.get(message), "1");
        assertEquals("Fields didn't match", fieldBody.get(message), "hello");
        assertEquals("Fields didn't match", fieldSource.get(message), Ms.MS1);
        assertEquals("Fields didn't match", fieldDestination.get(message), Ms.MS2);
        assertEquals("Fields didn't match", fieldCounter.get(message), 0);

    }

    @Test
    void testSetters_setsProperly() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Message message = new Message();

        //when
        message.setId("1");
        message.setBody("hello");
        message.setSource(Ms.MS2);
        message.setDestination(Ms.MS3);
        message.setCounter(10);

        //then
        final Field fieldId = message.getClass().getDeclaredField("id");
        final Field fieldBody = message.getClass().getDeclaredField("body");
        final Field fieldSource = message.getClass().getDeclaredField("source");
        final Field fieldDestination = message.getClass().getDeclaredField("destination");
        final Field fieldCounter = message.getClass().getDeclaredField("counter");


        fieldId.setAccessible(true);
        fieldBody.setAccessible(true);
        fieldSource.setAccessible(true);
        fieldDestination.setAccessible(true);
        fieldCounter.setAccessible(true);

        assertEquals("Fields didn't match", fieldId.get(message), "1");
        assertEquals("Fields didn't match", fieldBody.get(message), "hello");
        assertEquals("Fields didn't match", fieldSource.get(message), Ms.MS2);
        assertEquals("Fields didn't match", fieldDestination.get(message), Ms.MS3);
        assertEquals("Fields didn't match", fieldCounter.get(message), 10);
    }

    @Test
    void testGetters_getsValue() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Message message = new Message();

        final Field fieldId = message.getClass().getDeclaredField("id");
        final Field fieldBody = message.getClass().getDeclaredField("body");
        final Field fieldSource = message.getClass().getDeclaredField("source");
        final Field fieldDestination = message.getClass().getDeclaredField("destination");
        final Field fieldCounter = message.getClass().getDeclaredField("counter");

        fieldId.setAccessible(true);
        fieldBody.setAccessible(true);
        fieldSource.setAccessible(true);
        fieldDestination.setAccessible(true);
        fieldCounter.setAccessible(true);

        fieldId.set(message, "1");
        fieldBody.set(message, "Hello");
        fieldSource.set(message, Ms.MS1);
        fieldDestination.set(message, Ms.MS2);
        fieldCounter.set(message, 10);

        //when
        final String gettingId = message.getId();
        final String gettingBody = message.getBody();
        final Ms gettingSource = message.getSource();
        final Ms gettingDestination = message.getDestination();
        final int gettingCounter = message.getCounter();

        //then
        assertEquals("field wasn't retrieved properly", gettingId, "1");
        assertEquals("field wasn't retrieved properly", gettingBody, "Hello");
        assertEquals("field wasn't retrieved properly", gettingSource, Ms.MS1);
        assertEquals("field wasn't retrieved properly", gettingDestination, Ms.MS2);
        assertEquals("field wasn't retrieved properly", gettingCounter, 10);
    }
}
