package gn.traore.embedable.demoembedabledata;

import gn.traore.embedable.demoembedabledata.model.Address;
import gn.traore.embedable.demoembedabledata.model.Name;
import gn.traore.embedable.demoembedabledata.model.User;
import gn.traore.embedable.demoembedabledata.model.UserIdentity;
import gn.traore.embedable.demoembedabledata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoEmbedableDataApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoEmbedableDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // On néttoie la table USER
        userRepository.deleteAllInBatch();

        // Insert a user with multiple phone numbers and addresses.
        Set<String> phoneNumbers = new HashSet<>();
        phoneNumbers.add("+221 77 440 86 02");
        phoneNumbers.add("+224 626 23 11 09");

        Set<Address> addresses = new HashSet<>();
        addresses.add(new Address("747", "Golf View Road", "Bangalore",
                "Karnataka", "India", "560008"));
        addresses.add(new Address("Plot No 44", "Electronic City", "Bangalore",
                "Karnataka", "India", "560001"));

        // Insert a new user in the database
        UserIdentity identity = new UserIdentity(1L, 3L);
        Name name = new Name("Ibrahima", "Sory", "TRAORE");
        // Address address = new Address("747", "Golf View Road", "Bangalore", "Karnataka", "India", "560008");
        User user = new User(identity, name, "rajeev@callicoder.com", phoneNumbers, addresses);

        userRepository.save(user);

        // Display all User saved before
        userRepository.findAll().forEach(System.out::println);
    }
}
