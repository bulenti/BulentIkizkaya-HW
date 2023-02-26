package ikizkaya.bulent.model;

import jakarta.persistence.Entity;

import java.util.List;
@Entity
public class VisitingResearcher extends Instructors{

    private double hourlySalary;

    public VisitingResearcher() {
    }

    public VisitingResearcher(int id, String yavuzSan, String tuzla, int phoneNumber, String s, double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher(int id, String name, String address, int phoneNumber, List<Course> courselist, double hourlySalary) {
        super(id, name, address, phoneNumber, courselist);
        this.hourlySalary = hourlySalary;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VisitingResearcher that)) return false;
        if (!super.equals(o)) return false;

        return Double.compare(that.getHourlySalary(), getHourlySalary()) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getHourlySalary());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "hourlySalary=" + hourlySalary +
                '}';
    }


}
