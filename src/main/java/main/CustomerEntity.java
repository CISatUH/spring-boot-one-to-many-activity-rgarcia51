package main;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CUSTOMER", schema = "PUBLIC")
public class CustomerEntity {
    private int customerId;
    private String lastName;
    private String firstName;
    private Set<AddressEntity> addresses;

    public CustomerEntity() {
    }

    public CustomerEntity(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }



    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customerEntity", cascade = CascadeType.ALL)
    public Set<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressEntity> addresses) {
        addresses.forEach(addressEntity -> addressEntity.setCustomerEntity(this));
        this.addresses = addresses;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID", nullable = false)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "FIRST_NAME", nullable = false, length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerEntity that = (CustomerEntity) o;

        if (customerId != that.customerId) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }


}
