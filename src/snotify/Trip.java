package snotify;

/**
 * @author John Sundemo & Rustam Stanikzai
 *	Class Trip is used to receive information about a trip from a destination to another
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
	private int searchForArrival;
	private int useVasttag;
	private int useLongDistanceTrain;
	private int useRegionalTrain;
	private int useBus;
	private int useMedical;
	private int originMedicalConnection;
	private int destMedicalConnection;
	private int wheelChairSpace;
	private int strollerSpace;
	private int lowFloor;
	private int rampOrLift;
	private int useBoat;
	private int useTram;
	private int usePublicTransportation;
	private int excludeDR;
	private int maxWalkDist;
	private double walkSpeed;
	private int originWalk;
	private int destWalk;
	private int onlyWalk;
	private int originBike;
	private int maxBikeDist;
	private String bikeCriterion;
	private String bikeProfile;
	private int onlyBike;
	private int originCar;
	private int originCarWithParking;
	private int maxCarDist;
	private int onlyCar;
	private int maxChanges;
	private int addiotionalChangeTime;
	private int disregardDefaultChangeMargin;
	private int needJourneyDetail;
	private int needGeo;
	private int needltinerary;
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
		this.originId = null;
		this.originCoordLat = null;
		this.originCoordLong = null;
		this.originCoordName = null;
		this.destId = null;
		this.destCoordLat = null;
		this.destCoordLong = null;
		this.destCoordName = null;
		this.viaId = null;
		this.date = null; 
		this.time = null;
		this.searchForArrival = 0;
		this.useVasttag = 1;
		this.useLongDistanceTrain = 1;
		this.useRegionalTrain = 1;
		this.useBus = 1;
		this.useMedical = 0;
		this.originMedicalConnection = 0;
		this.destMedicalConnection = 0;
		this.wheelChairSpace = 0;
		this.strollerSpace = 0;
		this.lowFloor = 0;
		this.rampOrLift = 0;
		this.useBoat = 1;
		this.useTram = 1;
		this.usePublicTransportation = 1;
		this.excludeDR = 0;
		this.maxWalkDist = 0;
		this.walkSpeed = 1.00;
		this.originWalk = 1;
		this.destWalk = 1;
		this.onlyWalk = 0;
		this.originBike = 0;
		this.maxBikeDist = 0;
		this.bikeCriterion = null;
		this.bikeProfile = null;
		this.onlyBike = 1;
		this.originCar = 0;
		this.originCarWithParking = 0;
		this.maxCarDist = 0;
		this.onlyCar = 0;
		this.maxChanges = 0;
		this.addiotionalChangeTime = 0;
		this.disregardDefaultChangeMargin = 0;
		this.needJourneyDetail = 0;
		this.needGeo = 0;
		this.needltinerary = 0;
		this.numTrips = 10;
	}


	public void setOriginId(String originId) {
		this.originId = originId;
	}


	public void setOriginCoordLat(String originCoordLat) {
		this.originCoordLat = originCoordLat;
	}


	public void setOriginCoordLong(String originCoordLong) {
		this.originCoordLong = originCoordLong;
	}


	public void setOriginCoordName(String originCoordName) {
		this.originCoordName = originCoordName;
	}


	public void setDestId(String destId) {
		this.destId = destId;
	}


	public void setDestCoordLat(String destCoordLat) {
		this.destCoordLat = destCoordLat;
	}


	public void setDestCoordLong(String destCoordLong) {
		this.destCoordLong = destCoordLong;
	}


	public void setDestCoordName(String destCoordName) {
		this.destCoordName = destCoordName;
	}


	public void setViaId(String viaId) {
		this.viaId = viaId;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public void setSearchForArrival(boolean searchForArrival) {
		this.searchForArrival = (searchForArrival) ? 1 : 0;
	}


	public void setUseVasttag(boolean useVasttag) {
		this.useVasttag = (useVasttag) ? 1 : 0;
	}


	public void setUseLongDistanceTrain(boolean useLongDistanceTrain) {
		this.useLongDistanceTrain = (useLongDistanceTrain) ? 1 : 0;
	}


	public void setUseRegionalTrain(boolean useRegionalTrain) {
		this.useRegionalTrain = (useRegionalTrain) ? 1 : 0;
	}


	public void setUseBus(boolean useBus) {
		this.useBus = (useBus) ? 1 : 0;
	}


	public void setUseMedical(boolean useMedical) {
		this.useMedical = (useMedical) ? 1 : 0;
	}


	public void setOriginMedicalConnection(boolean originMedicalConnection) {
		this.originMedicalConnection = (originMedicalConnection) ? 1 : 0;
	}


	public void setDestMedicalConnection(boolean destMedicalConnection) {
		this.destMedicalConnection = (destMedicalConnection) ? 1 : 0;
	}


	public void setWheelChairSpace(boolean wheelChairSpace) {
		this.wheelChairSpace = (wheelChairSpace) ? 1 : 0;
	}


	public void setStrollerSpace(boolean strollerSpace) {
		this.strollerSpace = (strollerSpace) ? 1 : 0;
	}


	public void setLowFloor(boolean lowFloor) {
		this.lowFloor = (lowFloor) ? 1 : 0;
	}


	public void setRampOrLift(boolean rampOrLift) {
		this.rampOrLift = (rampOrLift) ? 1 : 0;
	}


	public void setUseBoat(boolean useBoat) {
		this.useBoat = (useBoat) ? 1 : 0;
	}


	public void setUseTram(boolean useTram) {
		this.useTram = (useTram) ? 1 : 0;
	}


	public void setUsePublicTransportation(boolean usePublicTransportation) {
		this.usePublicTransportation = (usePublicTransportation) ? 1 : 0;
	}


	public void setExcludeDR(boolean excludeDR) {
		this.excludeDR = (excludeDR) ? 1 : 0;
	}


	public void setMaxWalkDist(int maxWalkDist) {
		this.maxWalkDist = maxWalkDist;
	}


	public void setWalkSpeed(double walkSpeed) {
		this.walkSpeed = walkSpeed;
	}


	public void setOriginWalk(boolean originWalk) {
		this.originWalk = (originWalk) ? 1 : 0;
	}


	public void setDestWalk(boolean destWalk) {
		this.destWalk = (destWalk) ? 1 : 0;
	}


	public void setOnlyWalk(boolean onlyWalk) {
		this.onlyWalk = (onlyWalk) ? 1 : 0;
	}


	public void setOriginBike(boolean originBike) {
		this.originBike = (originBike) ? 1 : 0;
	}


	public void setMaxBikeDist(int maxBikeDist) {
		this.maxBikeDist = maxBikeDist;
	}


	public void setBikeCriterion(String bikeCriterion) {
		this.bikeCriterion = bikeCriterion;
	}


	public void setBikeProfile(String bikeProfile) {
		this.bikeProfile = bikeProfile;
	}


	public void setOnlyBike(boolean onlyBike) {
		this.onlyBike = (onlyBike) ? 1 : 0;
	}


	public void setOriginCar(boolean originCar) {
		this.originCar = (originCar) ? 1 : 0;
	}


	public void setOriginCarWithParking(boolean originCarWithParking) {
		this.originCarWithParking = (originCarWithParking) ? 1 : 0;
	}


	public void setMaxCarDist(int maxCarDist) {
		this.maxCarDist = maxCarDist;
	}


	public void setOnlyCar(boolean onlyCar) {
		this.onlyCar = (onlyCar) ? 1 : 0;
	}


	public void setMaxChanges(int maxChanges) {
		this.maxChanges = maxChanges;
	}


	public void setAddiotionalChangeTime(int addiotionalChangeTime) {
		this.addiotionalChangeTime = addiotionalChangeTime;
	}


	public void setDisregardDefaultChangeMargin(boolean disregardDefaultChangeMargin) {
		this.disregardDefaultChangeMargin = (disregardDefaultChangeMargin) ? 1 : 0;
	}


	public void setNeedJourneyDetail(boolean needJourneyDetail) {
		this.needJourneyDetail = (needJourneyDetail) ? 1 : 0;
	}


	public void setNeedGeo(boolean needGeo) {
		this.needGeo = (needGeo) ? 1 : 0;
	}


	public void setNeedltinerary(boolean needltinerary) {
		this.needltinerary = (needltinerary) ? 1 : 0;
	}


	public void setNumTrips(int numTrips) {
		this.numTrips = numTrips;
	}
	
	
}
