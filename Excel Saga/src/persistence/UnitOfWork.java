package persistence;

import java.util.ArrayList;

public class UnitOfWork
{
    ArrayList<Persistency> regNew = new ArrayList<>();
    ArrayList<Persistency> regDirty = new ArrayList<>();
    ArrayList<Persistency> regDeleted = new ArrayList<>();

    public void registerDirty(Persistency obj)
    {
        if(!regNew.contains(obj))
            regDirty.add(obj);
    }

    public void registerNew(Persistency obj)
    {
        regNew.add(obj);
    }

    public void registerDeleted(Persistency obj)
    {
        if(regNew.contains(obj))
            regNew.remove(obj);

        if(regDirty.contains(obj))
            regDirty.remove(obj);

        regDeleted.add(obj);
    }

    public void commit()
    {
        for(Persistency p : regNew)
            p.create();

        for(Persistency p : regDirty)
            p.update();

        for(Persistency p : regDeleted)
            p.delete();

        regNew.clear();
        regDirty.clear();
        regDeleted.clear();
    }
}
