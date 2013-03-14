

/**
 * BAPI1011_ADDRESS
 */

public class BAPI1011_ADDRESS {

	/**
	 * 銀行名 length=60 BANKA
	 */
	private java.lang.String BANK_NAME;

	/**
	 * 地域 (都道府県) length=3 REGIO
	 */
	private java.lang.String REGION;

	/**
	 * 地名/番地-号 length=35 STRAS_GP
	 */
	private java.lang.String STREET;

	/**
	 * 市区町村 length=35 ORT01_GP
	 */
	private java.lang.String CITY;

	/**
	 * 国際決済方法 SWIFT コード length=11 SWIFT
	 */
	private java.lang.String SWIFT_CODE;

	/**
	 * 銀行グループ (銀行ネットワーク) length=2 BGRUP
	 */
	private java.lang.String BANK_GROUP;

	/**
	 * 郵便貯金勘定 length=1 XPGRO
	 */
	private java.lang.String POBK_CURAC;

	/**
	 * 銀行番号 length=15 BANKL
	 */
	private java.lang.String BANK_NO;

	/**
	 * 郵便局口座番号 length=16 PSKTO_CH
	 */
	private java.lang.String POST_BANK;

	/**
	 * 銀行支店名 length=40 BRNCH
	 */
	private java.lang.String BANK_BRANCH;

	/**
	 * アドレス番号 length=10 AD_ADDRNUM
	 */
	private java.lang.String ADDR_NO;

	public java.lang.String getBANK_NAME() {
		return BANK_NAME;
	}

	public void setBANK_NAME(java.lang.String bANK_NAME) {
		BANK_NAME = bANK_NAME;
	}

	public java.lang.String getREGION() {
		return REGION;
	}

	public void setREGION(java.lang.String rEGION) {
		REGION = rEGION;
	}

	public java.lang.String getSTREET() {
		return STREET;
	}

	public void setSTREET(java.lang.String sTREET) {
		STREET = sTREET;
	}

	public java.lang.String getCITY() {
		return CITY;
	}

	public void setCITY(java.lang.String cITY) {
		CITY = cITY;
	}

	public java.lang.String getSWIFT_CODE() {
		return SWIFT_CODE;
	}

	public void setSWIFT_CODE(java.lang.String sWIFT_CODE) {
		SWIFT_CODE = sWIFT_CODE;
	}

	public java.lang.String getBANK_GROUP() {
		return BANK_GROUP;
	}

	public void setBANK_GROUP(java.lang.String bANK_GROUP) {
		BANK_GROUP = bANK_GROUP;
	}

	public java.lang.String getPOBK_CURAC() {
		return POBK_CURAC;
	}

	public void setPOBK_CURAC(java.lang.String pOBK_CURAC) {
		POBK_CURAC = pOBK_CURAC;
	}

	public java.lang.String getBANK_NO() {
		return BANK_NO;
	}

	public void setBANK_NO(java.lang.String bANK_NO) {
		BANK_NO = bANK_NO;
	}

	public java.lang.String getPOST_BANK() {
		return POST_BANK;
	}

	public void setPOST_BANK(java.lang.String pOST_BANK) {
		POST_BANK = pOST_BANK;
	}

	public java.lang.String getBANK_BRANCH() {
		return BANK_BRANCH;
	}

	public void setBANK_BRANCH(java.lang.String bANK_BRANCH) {
		BANK_BRANCH = bANK_BRANCH;
	}

	public java.lang.String getADDR_NO() {
		return ADDR_NO;
	}

	public void setADDR_NO(java.lang.String aDDR_NO) {
		ADDR_NO = aDDR_NO;
	}

}

