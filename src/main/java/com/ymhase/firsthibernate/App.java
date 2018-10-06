package com.ymhase.firsthibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ymhase.firsthibernate.model.UserEight;
import com.ymhase.firsthibernate.model.UserEleven;
import com.ymhase.firsthibernate.model.UserFive;
import com.ymhase.firsthibernate.model.UserFour;
import com.ymhase.firsthibernate.model.UserNine;
import com.ymhase.firsthibernate.model.UserOne;
import com.ymhase.firsthibernate.model.UserSeven;
import com.ymhase.firsthibernate.model.UserSix;
import com.ymhase.firsthibernate.model.UserTen;
import com.ymhase.firsthibernate.model.UserThree;
import com.ymhase.firsthibernate.model.UserTwelve;
import com.ymhase.firsthibernate.model.UserTwo;
import com.ymhase.firsthibernate.model.address.AddressModel;
import com.ymhase.firsthibernate.model.vehicle.FourWheeler;
import com.ymhase.firsthibernate.model.vehicle.TwoWheeler;
import com.ymhase.firsthibernate.model.vehicle.Vehicle;
import com.ymhase.firsthibernate.model.vehicle.VehicleOne;
import com.ymhase.firsthibernate.model.vehicle.VehicleThree;

public class App {
	public static void main(String[] args) {

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		int key = 7;

		AddressModel addr = new AddressModel();
		addr.setCity("pune");
		addr.setPin("1234");
		addr.setState("MH");
		addr.setStreet("street five");

		AddressModel addrHome = new AddressModel();
		addrHome.setCity("home_ah");
		addrHome.setState("home_st");
		addrHome.setPin("home_pin");
		addrHome.setStreet("home_street");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Ferrari");

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("jeep");

		VehicleOne vehicle3 = new VehicleOne();
		vehicle2.setVehicleName("vehicle one 1");

		VehicleOne vehicle4 = new VehicleOne();
		vehicle4.setVehicleName("vehicle one 2");

		VehicleThree vehicle5 = new VehicleThree();
		vehicle5.setVehicleName("vehicle one 3");

		VehicleThree vehicle6 = new VehicleThree();
		vehicle6.setVehicleName("vehicle one 4");
		
		TwoWheeler tw = new TwoWheeler();
		tw.setHandle("two wheeler handle");
		
		FourWheeler fw = new FourWheeler();
		fw.setSteeringWheel("Set steering wheeler");

		switch (key) {
		case 1:
			// @ Entity and @Id
			UserOne userone = new UserOne();
			userone.setId(2);
			userone.setName("user-two");
			session.save(userone);

			break;
		case 2:
			// @ Entity(name = "user_two") we can give name to the table
			UserTwo usertwo = new UserTwo();
			usertwo.setId(1);
			usertwo.setName("user- two");
			session.save(usertwo);

			break;
		case 3:
			// @Transient - igonres the field from the class
			// @Temporal (temporaDate.DATE) - will insert only time
			// @Temporal (Temporaldate.time) - this will insert time and date

			UserThree userthree = new UserThree();
			userthree.setId(1);
			userthree.setName("Yogesh");
			userthree.setIgnoreField("ignore field");
			userthree.setJoinedDate(new Date());
			userthree.setCheckintime(new Date());
			session.save(userthree);

			break;

		case 4:
			// @table(name = " name") give name to the table
			// @column (name = "name of the column")
			// @embedded
			// @GeneratedValue(strategy = Auto) auto increment the column

			UserFour userfour = new UserFour();
			userfour.setName("user four");
			userfour.setAddress(addr);
			session.save(userfour);
			break;

		case 5:
			// Attributeoverride - A class may have two or more model of same type
			// in such case it is important to give different name for the model used
			// also column name. Hence, this annotation along with the attribute column is
			// used for giving names to the column

			UserFive userfive = new UserFive();
			userfive.setName("user five");
			userfive.setAddress(addr);
			userfive.setHomeAddress(addrHome);

			session.save(userfive);
			break;

		case 6:
			// To add more than 2 model use sets, array list, collection
			// @ Elementcollection is used for inserting mutiple object of same type
			// this annotation created seperate table of address
			// whereas embedable integrate fieldsz of object in same table
			// name of address table is name of collection given in the usersix model
			// how is FK generated?->it takes @id field from object which is saved along
			// with
			// this collection

			UserSix usersix = new UserSix();
			usersix.setName("User six");
			usersix.getAddressSet().add(addr);
			usersix.getAddressSet().add(addrHome);
			session.save(usersix);
			break;

		case 7:
			// @jointable - gives name to the collection table
			// FK column name is given by @JoinColumn annotation
			// to use Index avoid set -set does not allow index
			// @collectionID
			UserSeven userseven = new UserSeven();
			userseven.setUsername("User Seven");
			userseven.getAddressSet().add(addr);
			userseven.getAddressSet().add(addrHome);
			session.save(userseven);
			break;

		case 8:
			//
			//
			UserEight usereight = new UserEight();
			usereight.setUsername("user eight");
			usereight.getAddressSet().add(addr);
			usereight.getAddressSet().add(addrHome);
			session.save(usereight);
			usereight = null;
			session = sessionfactory.openSession();
			usereight = session.get(UserEight.class, 1);
			System.out.println(usereight.getAddressSet().size());
			break;

		case 9:
			// @oneTOone creates two table and creates ID for
			// @JoinColumn(name = "VEHICLE_ID") this can name column
			// that is genrated automatically
			UserNine usernine = new UserNine();
			usernine.setName("user nine");
			usernine.setVehicleID(vehicle);
			session.save(usernine);
			break;

		case 10:
			// @onetoMany
			// join column is optional
			// use collection for many ojects
			// @collection vs @onetomany?
			// this creates 3 tables - users, vehicle and
			// onetomany mapping table user_vehicle table
			UserTen userten = new UserTen();
			userten.setUsername("user ten");
			userten.getVehiclelist().add(vehicle);
			userten.getVehiclelist().add(vehicle2);
			session.save(vehicle);
			session.save(vehicle2);
			session.save(userten);
			break;

		case 11:
			//
			// @onetoMany
			// joincolumn is optional
			// use collection for many ojects
			// @collction vs @onetomany?
			// this creates 3 tables - users, vehicle and
			// onetomany mapping table user_vehicle table
			UserEleven userEleven = new UserEleven();
			userEleven.setUsername("user eleven");
			vehicle3.setUserDetails(userEleven);
			vehicle4.setUserDetails(userEleven);
			userEleven.getVehiclelist().add(vehicle3);
			userEleven.getVehiclelist().add(vehicle4);
			session.save(vehicle3);
			session.save(vehicle4);
			session.save(userEleven);
			break;

		case 12:

			//ManytoMany creates 4 tables
			//user, vehicle, user-vehicle , and vehicle-users
			// to avoid repeatation of userID_vehicleID table
			//user mappedby annotation to let hibernate know that 
			//there is already a table for manytomany relation
			UserTwelve userTwelve = new UserTwelve();
			userTwelve.setUsername("user twelve");
			vehicle5.getUserList().add(userTwelve);
			vehicle6.getUserList().add(userTwelve);
			userTwelve.getVehiclelist().add(vehicle5);
			userTwelve.getVehiclelist().add(vehicle6);
			session.save(vehicle5);
			session.save(vehicle6);
			session.save(userTwelve);
			break;
			
			
		case 13:

			//ManytoMany creates 4 tables
			//user, vehicle, user-vehicle , and vehicle-users
			// to avoid repeatation of userID_vehicleID table
			//user mappedby annotation to let hibernate know that 
			//there is already a table for manytomany relation
			
			session.save(tw);
			session.save(fw);
			break;

		default:
			break;
		}

		session.getTransaction().commit();

	}
}
