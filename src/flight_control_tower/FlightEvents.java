package flight_control_tower;

import java.io.Serializable;

public class FlightEvents {
	
	private String planeId;
	private String planeModel;
	private String origin;
	private String destination;
	private String eventType;
	private String timeStamp;
	private int fuelDelta;
	
	FlightEvents(String planeId, String planeModel, String origin, String destination,
			String eventType, String timeStamp, int fuelDelta){
		this.planeId = planeId;
		this.planeModel = planeModel;
		this.origin = origin;
		this.destination = destination;
		this.eventType = eventType;
		this.timeStamp = timeStamp;
		this.fuelDelta = fuelDelta;
	};
    
    public String getPlaneId(){
        return planeId;
    }
    public String getPlaneModel(){
        return planeModel;
    }
    public String getOrigin(){
        return origin;
    }
    public String getDestination(){
        return destination;
    }
    public String getEventType(){
        return eventType;
    }
    public String getTimeStamp(){
        return timeStamp;
    }
    public int getFuelDelta(){
        return fuelDelta;
    }
    
    public String getEvents() {
    	return planeId + " " + planeModel + " " + origin + " " + 
    			destination + " " + eventType + " " + timeStamp + " " + 
    			fuelDelta;
    }

}
