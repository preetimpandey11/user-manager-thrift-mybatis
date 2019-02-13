package com.user;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServer {

    private static Logger logger = LoggerFactory.getLogger(UserServer.class);

    public static void main(String a[]) {
        try (TServerTransport transport = new TServerSocket(9090)) {
            UserService.Processor<UserServiceImpl> processor = new UserService.Processor<>(new UserServiceImpl());
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(transport).processor(processor));
            logger.info("Starting server on port 9090");
            server.serve();
        } catch (TTransportException e) {
            logger.error("Unable to create server", e);
        }

    }

}
