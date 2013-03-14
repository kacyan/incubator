/**
 * BapiBankGetdetail
 */
public interface BapiBankGetdetail {

	/**
	 * bapiBankGetdetail
	 * @param BANKCOUNTRY 銀行国コード (in) (must)
	 * @param BANKKEY 銀行コード (in) (must)
	 * @param BANK_ADDRESS 銀行住所データ (out) (option)
	 * @param BANK_DETAIL 銀行詳細データ (out) (option)
	 * @param RETURN 確認 (out) (option)
	 * @since Thu Feb 14 18:10:26 JST 2013
	 */

	public void bapiBankGetdetail( java.lang.String BANKCOUNTRY, java.lang.String BANKKEY, com.sap.conn.jco.JCoStructure BANK_ADDRESS, com.sap.conn.jco.JCoStructure BANK_DETAIL, com.sap.conn.jco.JCoStructure RETURN );

}