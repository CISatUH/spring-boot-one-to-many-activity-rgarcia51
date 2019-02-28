package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private CustomerEntityRepository customerEntityRepository;

    @Autowired
    private AddressEntityRepository addressEntityRepository;

    public static void main(String [] args){
        SpringApplication.run(Main.class);
    }
    @Override
    public void run(String... args) throws Exception {

        addData();
        for (CustomerEntity customerEntity: customerEntityRepository.findAll()){
            System.out.print(customerEntity);
        }

    }

    private void addData() {
        AddressEntity address = new AddressEntity();
        address.setStreetName("Mockingbird Lane");
        address.setStreetNumber("1313A");
        address.setState("Texas");
        address.setZipcode(123456);

        AddressEntity address2 = new AddressEntity();
        address2.setStreetName("Mockingbird Ln");
        address2.setStreetNumber("1313B");
        address2.setState("Texas");
        address2.setZipcode(123456);

        Set<AddressEntity> addresses = new HashSet<>();
        addresses.add(address);
        addresses.add(address2);

        CustomerEntity customerEntity = new CustomerEntity("Terrific","Tom");
        customerEntity.setAddresses(addresses);
        customerEntityRepository.save(customerEntity);
    }
}
