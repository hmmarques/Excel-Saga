package persistence;

import java.sql.*;


public class User implements Persistency{

    private String name;
    private Integer id;
    boolean persisted;

    public User(String name)
    {
        this.name = name;
        persisted = false;
        UnitOfWork work = Session.getSession().getUnitOfWork();
        work.registerNew(this);
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

    public Integer getID()
    {
        return id;
    }

    @Override
    public void create()
    {
        try
        {
            PreparedStatement pstatement = Session.getSession().getConnection().prepareStatement("insert into person (name, address) values (? ,?)"
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

    public static User load(Integer code)
    {
        User p = null;
        String query = "select * from person where id = " + code.toString();

        try
        {

            Statement stmt = Session.getSession().getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next())
            {
                p = new User(rs.getString("name"));
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
        String query = "update person set name = ?, address = ? where id = ?";

        try
        {
            PreparedStatement pstatement = Session.getSession().getConnection().prepareStatement(query);
            pstatement.setQueryTimeout(30);

            pstatement.setString(1, this.name);
            pstatement.setInt(3, this.id.intValue());

            pstatement.executeUpdate();

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void delete()
    {
        String query = "delete from person where id = " + this.id.toString();

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
