package bgu.spl.mics.application.passiveObjects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EwokTest {

    Ewok ewok;

    @BeforeEach
    public void setUp() {
        ewok = new Ewok (1);
    }

    @Test
    public void testAcquire() {
        ewok.acquire ();
        boolean check = ewok.getAvailable ();
        assertTrue ( !check,"supposed to be unavailable" );
    }

    @Test
    void testRelease() {
        ewok.acquire ();
        ewok.release ();
        boolean check = ewok.getAvailable ();
        assertTrue ( check,"supposed to be available" );
    }
}