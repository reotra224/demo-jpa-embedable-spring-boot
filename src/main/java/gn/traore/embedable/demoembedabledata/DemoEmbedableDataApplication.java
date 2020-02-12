package gn.traore.embedable.demoembedabledata;

import gn.traore.embedable.demoembedabledata.model.Address;
import gn.traore.embedable.demoembedabledata.model.Name;
import gn.traore.embedable.demoembedabledata.model.User;
import gn.traore.embedable.demoembedabledata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

        // Insert a new user in the database
        Name name = new Name("Ibrahima", "Sory", "TRAORE");
        Address address = new Address("747", "Golf View Road", "Bangalore", "Karnataka", "India", "560008");
        User user = new User(null, name, "rajeev@callicoder.com", address);

        userRepository.save(user);

        // Display all User saved before
        userRepository.findAll().forEach(System.out::println);
    }
}
