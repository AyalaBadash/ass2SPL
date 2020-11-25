package bgu.spl.mics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;


public class FutureTest {

    private Future<String> future;

    @BeforeEach
    public void setUp(){
        future = new Future<>();
    }

    @Test
    public void testResolve(){
        String str = "someResult";
        future.resolve(str);
        assertTrue(future.isDone());
        assertTrue(str.equals(future.get()));
    }

    @Test
    void testGet() {
        String str = "someResult";
        future.resolve(str);
        assertEquals ( str,future.get (),"supposed to return someResult");
    }

    @Test
    void testIsDone() {
        future.resolve ( "someResult" );
        assertTrue ( future.isDone (),"isDone should return true" );
    }

    @Test
    void testGetWithTime() {
        assertEquals ( null,future.get ( 5,TimeUnit.SECONDS ),"suppose to return null");
        String str = "someResult";
        future.resolve(str);
        assertEquals ( str,future.get ( 5,TimeUnit.SECONDS ),"suppose to return someResult");
    }
}
