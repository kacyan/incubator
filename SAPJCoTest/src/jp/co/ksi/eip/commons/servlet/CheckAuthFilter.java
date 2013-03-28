package jp.co.ksi.eip.commons.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * 認証情報をチェックするフィルタ
 * <pre>
 * １．セッションにauthが存在するか
 * ２．authが有効か
 * </pre>
 * @author kac
 * @since 2013/03/27
 * @version 2013/03/27
 */
public class CheckAuthFilter implements Filter
{
	/**
	 * 認証情報を示すセッション属性
	 */
	public static final String SESS_ATTR_NAME_AUTH= "auth";
	
	private static Logger log= Logger.getLogger( CheckAuthFilter.class );

	/**
	 * ログイン画面のURL(認証エラー時にこのURLにリダイレクトします)
	 */
	private String loginURL;
	/**
	 * チェック対象外のURL(正規表現)
	 */
	private String excludeURL;
	/**
	 * リダイレクトするか？
	 */
	private String redirect;

	@Override
	public void destroy()
	{
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain ) throws IOException, ServletException
	{
		HttpServletRequest	request= (HttpServletRequest)req;
		HttpServletResponse	response= (HttpServletResponse)res;
		
		//	チェック対象のURLか？
		String	requestURL= request.getRequestURI();
		log.debug( "requestURL="+ requestURL );
		
		if( !excludeURL.equals( "" ) && requestURL.matches( excludeURL ) )
		{//	除外対象のURL -> 後続処理へ
			chain.doFilter( req, res );
			return;
		}
		
		HttpSession	session= request.getSession();
		Auth	auth= (Auth)session.getAttribute( SESS_ATTR_NAME_AUTH );
		log.debug( "auth="+ auth );
		if( auth != null )
		{//	セッションにauthがある
			if( auth.isValid() )
			{//	authが有効 -> 後続処理へ
				chain.doFilter( req, res );
				return;
			}
		}
		
		//	認証エラー
		if( redirect.equalsIgnoreCase( "true" ) )
		{//	リダイレクトする
			String contextPath= request.getContextPath();
			String	redirectPath= contextPath + loginURL;
			log.debug( "auth error. redirect "+ redirectPath );
			if( requestURL.matches( redirectPath ) )
			{//	ログインURL -> 後続処理へ
				chain.doFilter( req, res );
			}
			else
			{//	リダイレクトする
				response.sendRedirect( redirectPath );
			}
		}
		else
		{//	フォワードする
			log.debug( "auth error. forward "+ loginURL );
			request.getRequestDispatcher( loginURL ).forward( req, res );
		}
	}

	@Override
	public void init( FilterConfig config ) throws ServletException
	{
		loginURL= config.getInitParameter( "loginURL" );
		excludeURL= config.getInitParameter( "excludeURL" );
		if( excludeURL == null )	excludeURL= "";
		redirect= config.getInitParameter( "redirect" );
		if( redirect == null )	redirect= "false";

		log.info( "loginURL="+ loginURL );
		log.info( "excludeURL="+ excludeURL );
		log.info( "redirect="+ redirect );
	}

}
