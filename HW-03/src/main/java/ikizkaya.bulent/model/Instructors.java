package ikizkaya.bulent.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Instructors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private int phoneNumber;

    @OneToMany(mappedBy = "instructors")
    private List<Course> courselist= new ArrayList<Course>();



    public Instructors() {
    }

    public Instructors(int id, String name, String address, int phoneNumber, List<Course> courselist) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.courselist = courselist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Course> getCourselist() {
        return courselist;
    }

    public void setCourselist(List<Course> courselist) {
        this.courselist = courselist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instructors that)) return false;

        if (getId() != that.getId()) return false;
        if (getPhoneNumber() != that.getPhoneNumber()) return false;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getPhoneNumber();
        return result;
    }

    @Override
    public String toString() {
        return "Instructors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", courselist=" + courselist +
                '}';
    }

}
