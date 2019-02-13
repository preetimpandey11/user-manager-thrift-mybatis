package com.user;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserClient {

    private static Logger logger = LoggerFactory.getLogger(UserClient.class);

    public static void main(String a[]) {
        TTransport transport = new TSocket("localhost", 9090);
        TProtocol protocol = new TBinaryProtocol(transport);
        try {
            transport.open();
            UserService.Client client = new UserService.Client(protocol);

            logger.info("Creating new User");
            client.addUser(new User().setEmail("abc@gmail.com").setGname("anc").setLname("ndck").setSsn(29834839));

            logger.info("Getting all users");
            List<User> all = client.getAll();
            all.forEach(System.out::println);

            int userId = all.get(0).getId();

            logger.info("Retrieving user");
            User user = client.getUser(userId);
            logger.info(user.toString());

            logger.info("Updating user");
            client.updateUser(user.getId(), user.setGname("Harry").setLname("Potter").setSsn(3857).setEmail("abbd@gmail.com"));

            logger.info("Retrieving updated user");
            user = client.getUser(userId);
            logger.info(user.toString());

            logger.info("Creating another User");
            client.addUser(new User().setEmail("prehj@gmail.com").setGname("Anna").setLname("Morris").setSsn(384958));

            logger.info("Getting all users");
            all = client.getAll();
            all.forEach(System.out::println);

            logger.info("Deleting user");
            client.deleteUser(user.getId());

            logger.info("Getting all users");
            all = client.getAll();
            all.forEach(System.out::println);

            userId = all.get(0).getId();

            logger.info("Deleting user");
            client.deleteUser(userId);

            logger.info("Getting all users");
            all = client.getAll();
            all.forEach(System.out::println);

        } catch (TTransportException e) {
            logger.error("Unable to open transport", e);
        } catch (TException e) {
            logger.error("Internal server error", e);
        } finally {
            transport.close();
        }
    }

}
