package connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by au_j on 18/10/2016.
 */
public class SampleConnectionPool {

   private String dburl;
   private String username;
   private String password;

   private ArrayList connectionPool = new ArrayList();
   private final int MAX_POOL_SIZE = 5;

   public SampleConnectionPool(String url, String user, String pass) {
      dburl = url;
      username = user;
      password = pass;

      while (!connectionPoolIsFull()) {
         connectionPool.add(createConnection());
      }
   }

   private synchronized boolean connectionPoolIsFull() {
      if (connectionPool.size() < MAX_POOL_SIZE) {
         return false;
      }

      return true;
   }

   private Connection createConnection() {
      Connection connection = null;

      try {
         Class.forName("com.mysql.jdbc.Driver");
         connection = DriverManager.getConnection(dburl, username, password);
         System.out.println("Creating connection: " + connection);

      } catch(SQLException sqle) {
         System.err.println("SQLException: " + sqle);
         return null;

      } catch(ClassNotFoundException cnfe) {
         System.err.println("ClassNotFoundException: " + cnfe);
         return null;
      }

      return connection;
   }

   public synchronized Connection checkout() throws SQLException {
      Connection newConnect = null;
      if (connectionPool.size() > 0) {
         newConnect = (Connection)connectionPool.get(connectionPool.size() - 1);
         connectionPool.remove(connectionPool.size() - 1);
      } else {
         System.out.println("No more Available Connections.");
      }

      return newConnect;
   }

   public synchronized void checkin(Connection c) {
      if (c != null) {
         connectionPool.add(c);
      }
   }

   public int availableCount()
   {
      return connectionPool.size();
   }
}
