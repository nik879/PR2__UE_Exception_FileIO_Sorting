package FileIO_Exceptions_Sorting_HashMap;

public class Einwohner implements Comparable<Einwohner> {
    private int id;
    private String Name;
    private String Bundesland;
    private int Geburtsjahr;

    public Einwohner(int id, String name, String bundesland, int geburtsjahr) {
        this.id = id;
        Name = name;
        Bundesland = bundesland;
        Geburtsjahr = geburtsjahr;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getBundesland() {
        return Bundesland;
    }

    public int getGeburtsjahr() {
        return Geburtsjahr;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setBundesland(String bundesland) {
        Bundesland = bundesland;
    }

    public void setGeburtsjahr(int geburtsjahr) {
        Geburtsjahr = geburtsjahr;
    }

    @Override
    public String toString() {
        return "Einwohner{" + "id=" + id + ", Name='" + Name + '\'' + ", Bundesland='" + Bundesland + '\'' + ", Geburtsjahr=" + Geburtsjahr + '}'+"\n";
    }

    @Override
    public int compareTo(Einwohner o) {
        return o.getName().compareTo(this.Name);
    }
}
