package ikizkaya.bulent.model;

import jakarta.persistence.Entity;

import java.util.List;
@Entity
public class PermanentInstructor extends Instructors{

    private double fixedSalary;

    public PermanentInstructor() {
    }

    public PermanentInstructor(int id, String fatihKale, String tuzla, int phoneNumber, String s, double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor(int id, String name, String address, int phoneNumber, List<Course> courselist, double fixedSalary) {
        super(id, name, address, phoneNumber, courselist);
        this.fixedSalary = fixedSalary;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PermanentInstructor that)) return false;
        if (!super.equals(o)) return false;

        return Double.compare(that.getFixedSalary(), getFixedSalary()) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getFixedSalary());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "fixedSalary=" + fixedSalary +
                '}';
    }
}
