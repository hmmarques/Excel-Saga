package persistence;    

import java.sql.*;

    public class Session {

        private static Session session;
        private Connection connection;
        private UnitOfWork unitOfWork;

        private Session()
        {
            if(connection == null)
            {
                try{
                    Class.forName("org.h2.Driver");
                    connection = DriverManager.
                            getConnection("jdbc:h2:~/test", "sa", ""); //user:sa pass:""

                    unitOfWork = new UnitOfWork();
                }catch(Exception e)
                {
                    e.printStackTrace();
                    //Logger.getLogger(Session.class.getName()).log(level.SEVERE, null, e);
                }
            }
        }

        public Connection getConnection()
        {
            return connection;
        }

        public UnitOfWork getUnitOfWork() { return unitOfWork; }

        public static Session getSession()
        {
            if(session == null)
            {
                session = new Session();
            }
            return session;
        }
    }
