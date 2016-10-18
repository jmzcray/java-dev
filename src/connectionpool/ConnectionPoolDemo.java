package connectionpool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by au_j on 18/10/2016.
 */
public class ConnectionPoolDemo {

   public static void main (String[] args)
   {
      try
      {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
      }
      catch (Exception E)
      {
         System.err.println("Exception while loading driver");
         E.printStackTrace();
      }

      try
      {
         SampleConnectionPool cp = new SampleConnectionPool("jdbc:mysql://localhost:3306/test","root","");

         Connection[]connArr = new Connection[7];

         for(int i=0; i<connArr.length;i++)
         {
            connArr[i] = cp.checkout();
            System.out.println("Checking out..." + connArr[i]);
            System.out.println("Available Connections ... " + cp.availableCount());
         }

         for(int i=0; i<connArr.length;i++)
         {
            cp.checkin(connArr[i]);
            System.out.println("Checked in..." + connArr[i]);
            System.out.println("Available Connections ... " + cp.availableCount());
         }
      }
      catch(SQLException sqle)
      {
         sqle.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }


}
