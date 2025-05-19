public class Person extends Object{
    private String name;
    private String giving;
    private boolean receving = false;
    private int family;


    public Person(String name, int family) {
        this.name = name;
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isReceving() {
        return receving;
    }

    public void setReceving(boolean receving) {
        this.receving = receving;
    }

    public String getGiving() {
        return giving;
    }

    public void setGiving(String giving) {
        this.giving = giving;
    }

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
    }
}
