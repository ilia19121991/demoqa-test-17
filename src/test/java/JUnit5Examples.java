import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnit5Examples {
    @BeforeAll
    static void beforeAll(){
        System.out.println("###    @BeforeAll !");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("###    @AfterAll !");
    }

    @BeforeEach
    // open google
    void beforeEach(){
        System.out.println("###    @BeforeEach !");
    }

    @AfterEach
    void afterEach(){
        System.out.println("###    @AfterEach !");
    }

    @Test
    void firstTest(){
        System.out.println("###    @Test firstTest() !");
        assertTrue(2==2);
    }

    @Test
    void secondTest(){
        System.out.println("###    @Test secondTest() !");
    }
}
