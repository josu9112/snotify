package snotify;

/**
 * @author John Sundemo & Rustam Stanikzai
 *	Class Trip is used to recieve information about a Journey from a destaniation to another
 */
public class Trip {

	private Token token;
	private final String baseRequestAddress = "https://api.vasttrafik.se/bin/rest.exe/v2/trip";
	private String originId;
	private String originCoordLat;
	private String originCoordLong;
	private String originCoordName;
	private String destId;
	private String destCoordLat;
	private String destCoordLong;
	private String destCoordName;
	private String viaId;
	private String date; //YYYY-MM-DD
	private String time; //HH:MM
	private String searchForArrival;
	private boolean useVasttag;
	private boolean useLongDistanceTrain;
	private boolean useRegionalTrain;
	private boolean useBus;
	private boolean useMedical;
	private boolean originMedicalConnection;
	private boolean destMedicalConnection;
	private boolean wheelChairSpace;
	private boolean strollerSpace;
	private boolean lowFloor;
	private boolean rampOrLift;
	private boolean useBoat;
	private boolean useTram;
	private boolean usePublicTransportation;
	private boolean excludeDR;
	private int maxWalkDist;
	private double walkSpeed;
	private String originWalk;
	private String destWalk;
	private boolean onlyWalk;
	private String originBike;
	private int maxBikeDist;
	private String bikeCriterion;
	private String bikeProfile;
	private boolean onlyBike;
	private boolean originCar;
	private boolean originCarWithParking;
	private int maxCarDist;
	private boolean onlyCar;
	private int maxChanges;
	private int addiotionalChangeTime;
	private boolean disregardDefaultChangeMargin;
	private boolean needJourneyDetail;
	private boolean needGeo;
	private boolean needltinerary;
	private int numTrips;
	
	
	/**
	 * Constructs Trip. All parameters are initialized and set to default valuse. Use set methods to give parameters values.
	 * @param token Access-token from Västtrafik.
	 */
	public Trip(Token token) {
		this.token = token;
		resetAllParameters();
	}
	
	
	public void resetAllParameters() {
		
	}
	
	
}
