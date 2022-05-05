public class User {
    String name;
    String surname;
    int personalnumber;

    public User(String name, String surname, int personalnumber) {
        this.name = name;
        this.surname = surname;
        this.personalnumber = personalnumber;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPersonalnumber() {
        return personalnumber;
    }

    public void setPersonalnumber(int personalnumber) {
        this.personalnumber = personalnumber;
    }
}
