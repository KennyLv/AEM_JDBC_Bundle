package com.adobe.aem.sql.model;

public class PhonePairResult {
	private int resultId;
	private int pairInstId;
	  
	private String phCOMPANY;
	private String phCARRIER;
	private String phMODEL;
	private String phVERSION;   //2.0.1
	private String phIMG;       //IPhone_4mw1r.gif
	private String phANNOUNCE;   //2011
	  
	private String phRESULT; // Passed / Failed
	
	private PhonePairFeatureNote phPAIR;     //Pairing,  YES (id) / NO    
	private PhonePairFeatureNote phCONNECT;  //Connecton, YES (id) / NO  
	private PhonePairFeatureNote phHFT;      //Hands Free Calling, YES (id) / NO
	private PhonePairFeatureNote phHUC;      // Hang Up Call
	private PhonePairFeatureNote phTTP;      // Transfer To Privacy
	private PhonePairFeatureNote phCALLID;   // Caller ID
	private PhonePairFeatureNote phREDIAL;   // Redial
	private PhonePairFeatureNote phMCH;      // Multiple call Handling
	private PhonePairFeatureNote phIBS;      // IBS Indicator Battery Symbol
	private PhonePairFeatureNote phAPD;      // Auto Phonebook Downloading
	private PhonePairFeatureNote phSTREAM;   // Streaming
	private String phICC;
	private String phOGC;
	private String phAUDIOX;
	private String phHANG;
	private String phPB_DEV;
	private String phPB_SIM;
	private String ph3WAY;
	private String phRCP;
	private String phROR;
	private String phHOLD;
	private String phWAIT;
	private String phIDA;
	  
	private int phTYPE;  // 1 / 3/ 
	private int phHIDE; // 1 / NULL
	
	public int getResultId() {
		return resultId;
	}
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}
	public int getPairInstId() {
		return pairInstId;
	}
	public void setPairInstId(int pairInstId) {
		this.pairInstId = pairInstId;
	}
	public String getPhCOMPANY() {
		return phCOMPANY;
	}
	public void setPhCOMPANY(String phCOMPANY) {
		this.phCOMPANY = phCOMPANY;
	}
	public String getPhCARRIER() {
		return phCARRIER;
	}
	public void setPhCARRIER(String phCARRIER) {
		this.phCARRIER = phCARRIER;
	}
	public String getPhMODEL() {
		return phMODEL;
	}
	public void setPhMODEL(String phMODEL) {
		this.phMODEL = phMODEL;
	}
	public String getPhVERSION() {
		return phVERSION;
	}
	public void setPhVERSION(String phVERSION) {
		this.phVERSION = phVERSION;
	}
	public String getPhIMG() {
		return phIMG;
	}
	public void setPhIMG(String phIMG) {
		this.phIMG = phIMG;
	}
	public String getPhANNOUNCE() {
		return phANNOUNCE;
	}
	public void setPhANNOUNCE(String phANNOUNCE) {
		this.phANNOUNCE = phANNOUNCE;
	}
	public String getPhRESULT() {
		return phRESULT;
	}
	public void setPhRESULT(String phRESULT) {
		this.phRESULT = phRESULT;
	}
	public PhonePairFeatureNote getPhPAIR() {
		return phPAIR;
	}
	public void setPhPAIR(PhonePairFeatureNote phPAIR) {
		this.phPAIR = phPAIR;
	}
	public PhonePairFeatureNote getPhCONNECT() {
		return phCONNECT;
	}
	public void setPhCONNECT(PhonePairFeatureNote phCONNECT) {
		this.phCONNECT = phCONNECT;
	}
	public PhonePairFeatureNote getPhHFT() {
		return phHFT;
	}
	public void setPhHFT(PhonePairFeatureNote phHFT) {
		this.phHFT = phHFT;
	}
	public PhonePairFeatureNote getPhHUC() {
		return phHUC;
	}
	public void setPhHUC(PhonePairFeatureNote phHUC) {
		this.phHUC = phHUC;
	}
	public PhonePairFeatureNote getPhTTP() {
		return phTTP;
	}
	public void setPhTTP(PhonePairFeatureNote phTTP) {
		this.phTTP = phTTP;
	}
	public PhonePairFeatureNote getPhCALLID() {
		return phCALLID;
	}
	public void setPhCALLID(PhonePairFeatureNote phCALLID) {
		this.phCALLID = phCALLID;
	}
	public PhonePairFeatureNote getPhREDIAL() {
		return phREDIAL;
	}
	public void setPhREDIAL(PhonePairFeatureNote phREDIAL) {
		this.phREDIAL = phREDIAL;
	}
	public PhonePairFeatureNote getPhMCH() {
		return phMCH;
	}
	public void setPhMCH(PhonePairFeatureNote phMCH) {
		this.phMCH = phMCH;
	}
	public PhonePairFeatureNote getPhIBS() {
		return phIBS;
	}
	public void setPhIBS(PhonePairFeatureNote phIBS) {
		this.phIBS = phIBS;
	}
	public PhonePairFeatureNote getPhAPD() {
		return phAPD;
	}
	public void setPhAPD(PhonePairFeatureNote phAPD) {
		this.phAPD = phAPD;
	}
	public PhonePairFeatureNote getPhSTREAM() {
		return phSTREAM;
	}
	public void setPhSTREAM(PhonePairFeatureNote phSTREAM) {
		this.phSTREAM = phSTREAM;
	}
	public String getPhICC() {
		return phICC;
	}
	public void setPhICC(String phICC) {
		this.phICC = phICC;
	}
	public String getPhOGC() {
		return phOGC;
	}
	public void setPhOGC(String phOGC) {
		this.phOGC = phOGC;
	}
	public String getPhAUDIOX() {
		return phAUDIOX;
	}
	public void setPhAUDIOX(String phAUDIOX) {
		this.phAUDIOX = phAUDIOX;
	}
	public String getPhHANG() {
		return phHANG;
	}
	public void setPhHANG(String phHANG) {
		this.phHANG = phHANG;
	}
	public String getPhPB_DEV() {
		return phPB_DEV;
	}
	public void setPhPB_DEV(String phPB_DEV) {
		this.phPB_DEV = phPB_DEV;
	}
	public String getPhPB_SIM() {
		return phPB_SIM;
	}
	public void setPhPB_SIM(String phPB_SIM) {
		this.phPB_SIM = phPB_SIM;
	}
	public String getPh3WAY() {
		return ph3WAY;
	}
	public void setPh3WAY(String ph3way) {
		ph3WAY = ph3way;
	}
	public String getPhRCP() {
		return phRCP;
	}
	public void setPhRCP(String phRCP) {
		this.phRCP = phRCP;
	}
	public String getPhROR() {
		return phROR;
	}
	public void setPhROR(String phROR) {
		this.phROR = phROR;
	}
	public String getPhHOLD() {
		return phHOLD;
	}
	public void setPhHOLD(String phHOLD) {
		this.phHOLD = phHOLD;
	}
	public String getPhWAIT() {
		return phWAIT;
	}
	public void setPhWAIT(String phWAIT) {
		this.phWAIT = phWAIT;
	}
	public String getPhIDA() {
		return phIDA;
	}
	public void setPhIDA(String phIDA) {
		this.phIDA = phIDA;
	}
	public int getPhTYPE() {
		return phTYPE;
	}
	public void setPhTYPE(int phTYPE) {
		this.phTYPE = phTYPE;
	}
	public int getPhHIDE() {
		return phHIDE;
	}
	public void setPhHIDE(int phHIDE) {
		this.phHIDE = phHIDE;
	}
}
