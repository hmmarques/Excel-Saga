package persistence;

import java.sql.*;


public class User implements Persistency{

    private String name;
    private static Integer id;
    boolean persisted;

    
    public User(String name)
    {
        this.name = name;
        persisted = false;
        UnitOfWork work = Session.getSession().getUnitOfWork();
        work.registerNew(this);
    }
    
    public User(String name, int n)
    {
        this.name = name;
        persisted = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

        if(persisted)
        {
            UnitOfWork work = Session.getSession().getUnitOfWork();

            work.registerDirty(this);
        }
    }

    public static Integer getID()
    {
        return id;
    }

    @Override
    public void create()
    {
        try
        {
            PreparedStatement pstatement = Session.getSession().getConnection().prepareStatement("insert into USERS (name) values (?)"
                                                                                                    , Statement.RETURN_GENERATED_KEYS);
            pstatement.setQueryTimeout(30);
            pstatement.setString(1, this.name);

            pstatement.execute();

            ResultSet rs = pstatement.getGeneratedKeys();

            if (rs != null && rs.next())
                this.id = new Integer(rs.getInt(1));

            this.persisted = true;

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static User load(String name)
    {
        User p = null;
        String query = "select * from USERS where name = '" + name + "'";

        try
        {

            Statement stmt = Session.getSession().getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next())
            {
                p = new User(rs.getString("name"),1);
                p.id = rs.getInt("id");
                p.persisted = true;
            }
        } catch (SQLException e )
        {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void update()
    {
        String query = "update USERS set name = ? where id = ?";

        try
        {
            PreparedStatement pstatement = Session.getSession().getConnection().prepareStatement(query);
            pstatement.setQueryTimeout(30);

            pstatement.setString(1, this.name);
            pstatement.setInt(2, this.id.intValue());

            pstatement.executeUpdate();

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void delete()
    {
        String query = "delete from USERS where id = " + this.id.toString();

        try
        {
            Statement statement = Session.getSession().getConnection().createStatement();

            statement.execute(query);

            this.persisted = false;

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
