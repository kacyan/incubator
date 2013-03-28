package jp.co.ksi.eip.commons.servlet;

public interface Auth
{

	/**
	 * この認証情報が有効かを示します
	 * @return boolean
	 */
	public abstract boolean isValid();

	public abstract Class getAuthClass();

}