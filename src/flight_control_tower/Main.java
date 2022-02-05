package flight_control_tower;

import java.util.*;

public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<FlightEvents> flight = new ArrayList<FlightEvents>();
		
		Scanner scanInt = new Scanner(System.in);
		Scanner scanStr = new Scanner(System.in);
		
		flight.add(new FlightEvents("F222", "747", "DUBLIN", "LONDON", 
				"Re-Fuel", "2021-03-29T10:00:00", 200));
		flight.add(new FlightEvents("F551", "747", "PARIS", "LONDON", 
				"Re-Fuel", "2021-03-29T10:00:00", 345));
		flight.add(new FlightEvents("F324", "313", "LONDON", "NEWYORK", 
				"Take-Off", "2021-03-29T12:00:00", 0));
		flight.add(new FlightEvents("F123", "747", "LONDON", "CAIRO", 
				"Re-Fuel", "2021-03-29T10:00:00", 428));
		flight.add(new FlightEvents("F123", "747", "LONDON", "CAIRO", 
				"Take-Off", "2021-03-29T12:00:00", 0));
		flight.add(new FlightEvents("F551", "747", "PARIS", "LONDON", 
				"Take-Off", "2021-03-29T11:00:00", 0));
		flight.add(new FlightEvents("F551", "747", "PARIS", "LONDON", 
				"Land", "2021-03-29T12:00:00", -120));
		flight.add(new FlightEvents("F123", "747", "LONDON", "CAIRO", 
				"Land", "2021-03-29T14:00:00", -324));
		
		
		int selection;
		
		do {
	        System.out.println("1.ADD");
	        System.out.println("2.DISPLAY");
	        System.out.println("3.SEARCH");
	        System.out.println("4.DELETE");
	        System.out.println("5.UPDATE");
			
			System.out.println(" ");
			System.out.print("Please enter a number between 1-4: ");
			selection = scanInt.nextInt();
			
			switch(selection) {
				case 1:
					//ADD
					System.out.print("Enter Plane ID:");
					String planeId = scanStr.nextLine();
					
					System.out.print("Enter Plane Model:");
					String planeModel = scanStr.nextLine();
					
					System.out.print("Enter Origin:");
					String origin = scanStr.nextLine();
	
					System.out.print("Enter Destination:");
					String destination = scanStr.nextLine();
	
					System.out.print("Enter Event Type:");
					String eventType = scanStr.nextLine();
	
					System.out.print("Enter Time Stamp:"); 
					String timeStamp = scanStr.nextLine();
	
					System.out.print("Enter Fuel Delta:");
					int fuelDelta = scanInt.nextInt();
					
					flight.add(new FlightEvents(planeId, planeModel, origin, destination, 
							eventType, timeStamp, fuelDelta));
					break;
				
				case 2:
					//DISPLAY
					System.out.println("----------------------------");
		            Iterator<FlightEvents> i = flight.iterator();
		            while(i.hasNext()){
		            	FlightEvents f = i.next(); 
		                System.out.println(f.getEvents());
		            }
		               
		            System.out.println("----------------------------");
		            break;
		            
				case 3:
					//SEARCH
					boolean found = false;
		            System.out.print("Enter the Time Stamp to Search :");
		            String timestmp = scanStr.nextLine();
		            
		            System.out.println("----------------------------");
		            
		            i = flight.iterator();
		            while(i.hasNext()){
		            	FlightEvents f = i.next();
		            	
		                if(f.getTimeStamp().equals(timestmp))  {
		                	
		                	status(f);
		                			                	
		                	found = true;		                	
		                }
		            }		               
		            if(!found){
		            	System.out.println("Record Not Found");
		            }
		            System.out.println("----------------------------");
					break;
					
				case 4:
					found = false;
		            System.out.println("Enter Plane ID and Time Stamp to Delete.");
		               
		            System.out.print("Enter Plane ID: ");
		            String pId = scanStr.nextLine();
		               
		            System.out.print("Enter Time Stamp: ");
		            timestmp = scanStr.nextLine();
		               
		            System.out.println("----------------------------");
		            i = flight.iterator();
		            
		            while(i.hasNext()){
		            	FlightEvents f = i.next();
		                if(f.getPlaneId().equals(pId) && f.getTimeStamp().equals(timestmp))  {
		                	i.remove();	                	
		                    found = true;
		                }
		            }
		               
		            if(!found){
		                System.out.println("Record Not Found");
		            }
		            else{
		                System.out.println("Record has been Deleted Successfully!");
		            }

		            System.out.println("----------------------------");
					break;
			}
			

		} while(selection!=0);
	}
	
	public static void status(FlightEvents f) {
		
    	if(f.getEventType().equals("Re-Fuel") && f.getEventType().equals("Take-Off") && f.getEventType().equals("Land")) {
    		System.out.println(f.getPlaneId() + " Landed " + f.getFuelDelta());
    	}
    	else if(f.getEventType().equals("Re-Fuel") && f.getEventType().equals("Take-Off")) {
    		System.out.println(f.getPlaneId() + " In-Flight " + f.getFuelDelta());
    	}
    	else {
    		System.out.println(f.getPlaneId() + " Re-Fuel " + f.getFuelDelta());
    	}
	}

}
