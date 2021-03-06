package model.facilityuse;

import dal.FacilityUseDAO;
import model.facilityuse.AptUser;
import model.facility.Inspection;
import java.util.Set;



public class FacilityUse implements FacilityUseIntf {
	
	private Set<AptUser> aptusers;
	
	public Set<AptUser> getAptusers() {
		return aptusers;
	}

	public void setAptusers(Set<AptUser> aptusers) {
		this.aptusers = aptusers;
	}

	private FacilityUseDAO facUseDAO = new FacilityUseDAO();
	
	/**
	 * Check if is a certain unit is in use or not
	 * @param apartmentID
	 * @param UnitNo
	 * @return
	 */
	
	public String isInUseDuringInterval(String apartmentID, String UnitNo)
	{
		return facUseDAO.isInUseDuringInterval(apartmentID, UnitNo);
		
		
	}
	
	/**
	 * Calculate the usage rate of an apartment
	 * @param apartmentID
	 * @return
	 */
	public float calcUsagerate(String apartmentID)
	{
		return facUseDAO.getUsedCount(apartmentID)/facUseDAO.getCapacity(apartmentID)*100;
		
	}
	
	/**
	 * Mark a unit as available
	 * @param apartmentID
	 * @param unitNo
	 * @return
	 */
	public String vacateFacility(String apartmentID, String unitNo)
	{
		return facUseDAO.vacateFacility(apartmentID, unitNo);
		
	}
	
	/**
	 * Assign a unit to a user
	 * @param apartmentID
	 * @param unitNo
	 * @param useApt
	 * @return
	 */
	
	public String assignFacility(String apartmentID, String unitNo, AptUser useApt)
	{
		return facUseDAO.assignFacility(apartmentID, unitNo, useApt);
		
	}
	
	/**
	 * List all the units that rented out
	 * @param apartmentID
	 * @return
	 */
	public Set<Inspection> listInspections(String apartmentID)
	{
		return facUseDAO.listInspections(apartmentID);
		
	}

}
