package com.bex.spring.MVC.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.TreeSet;

@XmlRootElement(name = "Employee")
@Entity(name = "employee")
public class Employee implements Cloneable, Comparable {

    @XmlTransient
    @Transient
    private int hash;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder obj = new StringBuilder();
        obj.append("{");
        obj.append("id: ");
        obj.append(getId());
        obj.append(", name: ");
        obj.append(getName());
        obj.append(", email: ");
        obj.append(getEmail());
        obj.append(", hash: ");
        obj.append(hashCode());
        obj.append("}");
        return obj.toString();
    }

    @Override
    public int compareTo(Object o) {
        Employee obj = (Employee) o;
        if (obj.id < this.id)
            return 1;
        else {
            if (obj.id == this.id)
                return 0;
            else
                return -1;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        int h = hash;
        if (h == 0 && id != null) {
            h = new HashCodeBuilder(19,37).append(id.toString()).append(name).append(email).toHashCode();
            hash = h;
        }
        return h;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Employee))
            return false;
        if (this == obj)
            return true;
        final Employee to = (Employee) obj;
        return new EqualsBuilder().append(to.id,this.id).append(to.email,this.email).append(to.name,this.name).isEquals();
    }

    public final static void main(String[] args) {
        Employee obj1 = new Employee();
        obj1.setEmail("email1");
        obj1.setName("name1");
        obj1.setId(1);
        Employee obj2 = new Employee();
        obj2.setEmail("email2");
        obj2.setName("name2");
        obj2.setId(2);

        Employee obj3 = new Employee();
        obj3.setName("name3");
        obj3.setId(3);

        Employee obj4 = new Employee();
        obj4.setName("name3");
        obj4.setId(3);

        TreeSet set = new TreeSet();
        set.add(obj1);
        set.add(obj2);
        set.add(obj3);

        System.out.println(set);
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);
        System.out.println(obj4);

        System.out.println(obj1.equals(obj2));
        System.out.println(obj2.equals(obj3));
        System.out.println(obj3.equals(obj4));

    }
}