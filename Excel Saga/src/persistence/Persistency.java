package persistence;



public interface Persistency
{
    public void create();

    public void update();

    public void delete();

    @Override
    public boolean equals(Object o);
}
