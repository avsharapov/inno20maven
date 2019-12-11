package stc.inno20;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stc.inno20.ConnectionManager.ConnectionManager;
import stc.inno20.dao.MobileDao;
import stc.inno20.dao.MobileDaoJdbcImpl;
import stc.inno20.mocks.ConnectionManagerMock;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class MainTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(MainTest.class);

  private Main main;
  private MobileDao mobileDao;
  private ConnectionManager connectionManager;

  @BeforeEach
  void setUp() {
    LOGGER.trace("BeforeEach in MainTest");
    main = new Main();
    connectionManager = new ConnectionManagerMock();
    mobileDao = new MobileDaoJdbcImpl(connectionManager);
  }

  @BeforeAll
  static void tearDownAll() {
    LOGGER.trace("BeforeAll in MainTest");
  }

  @AfterAll
  static void setUpAll() {
    LOGGER.trace("AfterAll in MainTest");
  }

  @AfterEach
  void tearDown() {
    LOGGER.trace("AfterEach in MainTest");
  }

  @Test
  @DisplayName("ТЕСТ MAIN МЕТОДА, КОГДА ВСЁ ОК!")
  void main() {
    assumeTrue(main != null);
    assertDoesNotThrow(() -> main.method1(mobileDao));
  }

  @Test
  void mainWithException() {
    NullPointerException nullPointerException = assertThrows(NullPointerException.class, () -> main.method1(null));
    assertNull(nullPointerException.getMessage());
  }

  @Test
  @Disabled
  void disabledTest() {
    //
  }
}