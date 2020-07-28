package com.mongo.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class MongodbApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {

		Customer c1 = new Customer("1","Kate","Hudson");
		Customer c2 = new Customer("2","Mary","Poppins");
		Customer c3 = new Customer("3","Jennifer","Alison");
		Customer c4 = new Customer("4","Jennifer","Gardner");

		ArrayList<Customer> customerArrayList = new ArrayList<Customer>();

		customerArrayList.add(c1);
		customerArrayList.add(c2);
		customerArrayList.add(c3);
		customerArrayList.add(c4);

		customerRepository.saveAll(customerArrayList);

		for(Customer customer : customerArrayList){

			System.out.println(customer.toString());
		}
	}
}
