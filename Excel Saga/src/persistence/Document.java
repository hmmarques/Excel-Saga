package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Document implements Persistency{
    
    String name;
    Integer id;
    boolean persisted;
    
    
    public Document(String name)
    {
        this.name = name;
        
        persisted = false;
        UnitOfWork work = Session.getSession().getUnitOfWork();
        work.registerNew(this);
    }
    
    public Document(String name, int n)
    {
        this.name = name;
        
        persisted = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
    
    @Override
    public void create()
    {
        try
        {   
            PreparedStatement pstatement = Session.getSession().getConnection().prepareStatement("insert into DOCUMENTS (id, userID, name) values (1,?, ?)"
                                                                                                    , Statement.RETURN_GENERATED_KEYS);
            pstatement.setQueryTimeout(30);
            pstatement.setInt(1, User.getID());
            pstatement.setString(2, this.name);
            
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

    public static ArrayList<Document> load(Integer userID)
    {
        ArrayList<Document> ListDocument = new ArrayList<>();
      
        //retorna todos os docs de um determinado user
        String query = "select * from DOCUMENTS where userID = " + userID.toString();

        try
        {

            Statement stmt = Session.getSession().getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next())
            {
                Document doc = new Document(rs.getString("name"),1);
                
                doc.persisted = true;
                
                ListDocument.add(doc);
                
                
            }
        } catch (SQLException e )
        {
            e.printStackTrace();
        }
        return ListDocument;
    }

    @Override
    public void update()
    {
        String query = "update DOCUMENTS set name = ? where id = ?";

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
        String query = "delete from DOCUMENTS where id = " + this.id.toString();

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
