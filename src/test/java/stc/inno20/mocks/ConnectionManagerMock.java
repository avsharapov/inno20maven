package stc.inno20.mocks;

import stc.inno20.ConnectionManager.ConnectionManager;

import java.sql.Connection;

public class ConnectionManagerMock implements ConnectionManager {
  @Override public Connection getConnection() {
    return new ConnectionMock();
  }

  @Override public int get15() {
    return 0;
  }
}
