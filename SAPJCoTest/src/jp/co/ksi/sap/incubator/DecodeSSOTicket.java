package jp.co.ksi.sap.incubator;

import iaik.security.provider.IAIK;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.security.Security;
import java.util.Calendar;
import java.util.StringTokenizer;

public class DecodeSSOTicket {

     public static java.security.cert.X509Certificate[] certificates = null;

     public static Socket clientSocket = null;



     //  ************** get Cookie from HTTP Request ***********************

     public static String getSSOCookie() {

          ServerSocket serverSocket = null;

          try {

               serverSocket = new ServerSocket(80);

               clientSocket = serverSocket.accept();

               DataInputStream is =

                    new DataInputStream(

                         new BufferedInputStream(clientSocket.getInputStream()));

               String inLine = new String();

               String Cookie = new String();

               while (true) {

                    inLine = is.readLine();

                    if (inLine.length() == 0)

                         break;

                    System.out.println(inLine);

                    if (inLine.substring(0, 7).compareToIgnoreCase("Cookie:")

                         == 0) {

                         StringTokenizer st =

                              new StringTokenizer(inLine.substring(7), ";");

                         while (st.hasMoreTokens()) {

                              Cookie = st.nextToken();

                              if (Cookie

                                   .substring(0, 10)

                                   .compareToIgnoreCase(" MYSAPSSO2")

                                   == 0) {

                                   Cookie = Cookie.substring(11);

                                   String base64Value =

                                        URLDecoder.decode(Cookie, "UTF-8");

                                   return (base64Value);

                              }

                         }

                    }

               }

               is.close();

          } catch (Exception e) {

               System.err.println("Exception: " + e);

               e.printStackTrace();

          }

          return ("* no MYSAPSSO2 Cookie found *");

     }

     //  ****************** load Certificates from PSE ***************

     public static void loadCertsFromPSE(String pse, String pwd) {

          char passwd[] = pwd.toCharArray();

          java.io.InputStream stream = null;

          java.util.ArrayList certs = new java.util.ArrayList();

          try {

               stream = new java.io.FileInputStream(pse);

               java.security.KeyStore store =

                    java.security.KeyStore.getInstance("JKS", "SUN");

               store.load(stream, passwd);

               java.util.Enumeration enu = store.aliases();

               while (enu.hasMoreElements()) {

                    String alias = (String) enu.nextElement();

                    if (store.isCertificateEntry(alias)) {

                         certs.add(store.getCertificate(alias));

                    }

               }

               stream.close();

               if (certs.size() < 1) {

                    System.out.println("PSE does not contain any certificates");

               }

               System.out.println(certs.toString());

               certificates =

                    (java.security.cert.X509Certificate[]) certs.toArray(

                         new java.security.cert.X509Certificate[0]);

          } catch (Exception e) {
        	  e.printStackTrace();
          }

     }

     public static void sendResponse(String portalUser) {

          try {

               PrintStream os =

                    new PrintStream(

                         new BufferedOutputStream(clientSocket.getOutputStream()),

                         true);

               os.print("HTTP/1.1 200 OK \n");

               os.print("Content-Type: text/html \n");

               os.print(

                    "<html><head><title>Ticket Response</title></head><body>\n");

               os.print("Userid from Ticket:" + portalUser + "\n");

               os.print("</body></html>\n");

               os.close();

          } catch (Exception e) {

          }

     }

     //*********** main *************************************

 

     public static void main(String[] args) {

          System.out.println("** waiting for http request ** ");

          System.out.println("***** http headers of request begin *******");

          String Cookie = "AjQxMDMBABg0ADUAMAAxADkAMQAxADAAMQAzACAAIAACAAY5ADAAMgADABBSAEUANQAgACAAIAAgACAABAAYMgAwADEAMwAwADYAMgA0ADAANQAxADMABQAEAAAACAYAAlgACQACSgD/A1QwggNQBgkqhkiG9w0BBwKgggNBMIIDPQIBATELMAkGBSsOAwIaBQAwCwYJKoZIhvcNAQcBoIICUzCCAk8wggIPAgcgEQQEExYFMAkGByqGSM44BAMwDjEMMAoGA1UEAxMDREU0MB4XDTExMDQwNDEzMTYwNVoXDTM4MDEwMTAwMDAwMVowDjEMMAoGA1UEAxMDREU0MIIBtzCCASwGByqGSM44BAEwggEfAoGBAP/xj!B47Lr!SRFHxMni7HS6i4UICAlsbwH5AU5bW52ST3cElPASiYkciYlKM9Dc0vcTx!jhN1j7Dw7tp71Rpxs3t6yBY3S1CpanVCURxLjm4VBVINmRX9fJQVXFuNtpcC9dCr1IcJ4LenmSHWJgFJ/QsK4R8hk6GUeFYAgvsbbTAhUAjCnu6GdzaKBE1tG5z4ksen6cSAsCgYEA1oenEWTrY/SGknhHZAHlFQOCs7XiSHV8vdG7IgZ1Da!5iLRpZ6yiyenVwEH16ifS5epjmVuFCNFrZJbbsrQv!19JyOfx0kHRVrDGYyZhtrmARbMpl8BEq5QvsEZbcLAft3XaaCpJozizCULViKILZWBAKx!OsFYwGB6N0gTfXS0DgYQAAoGAW!LcxvMveSAALvtINAMve8Ys/FCefVIxrV7pjdIG2UP5!SQBhmuuMV7ITLLwURaRZKXBbIj64I6R3VgFN9MGvtADA3Wa2hX0FuqY6U40fHuGMMzuM379xBbWCT0IaFw!MWsj1aZxk5PsGDDAYm4QWWORWvvu3PldAuEZnmLWi8gwCQYHKoZIzjgEAwMvADAsAhQhNSSM8zlabyORUxYt57XPyvdIHAIUbeH9pfFcdDJ6HpkcgLHAA0XbevIxgcYwgcMCAQEwGTAOMQwwCgYDVQQDEwNERTQCByARBAQTFgUwCQYFKw4DAhoFAKBdMBgGCSqGSIb3DQEJAzELBgkqhkiG9w0BBwEwHAYJKoZIhvcNAQkFMQ8XDTEzMDYyNDA1MTMxNVowIwYJKoZIhvcNAQkEMRYEFG5zq0STjyYKJE0WvK/yACiyes/kMAkGByqGSM44BAMELjAsAhQ4zHmaQv7StfR5e0!mz30/791vnAIUD6ONotWUD796j3!AaPoQieen98Q=";
//          Cookie= getSSOCookie();

          System.out.println("***** http headers of request end *******" + "\n");

          System.out.println(

               "***** extracted MYSAPSSO2 Cookie begin  (as UTF-8 encoded) *******");

          System.out.println(Cookie);

          System.out.println(

               "***** extracted MYSAPSSO2 - Cookie end *******" + "\n");

          System.out.println("***** loading certs from pse begin *******");

          loadCertsFromPSE("c:ep.pse", "password");

          System.out.println("***** loading certs from pse end   *******" + "\n");

          IAIK provider = new IAIK();

          Security.addProvider(provider);

          com.sap.security.core.ticket.imp.Ticket ticket =

               new com.sap.security.core.ticket.imp.Ticket();

          try {

               ticket.setCertificates(certificates);

               ticket.setTicket(Cookie);

               ticket.verify();

               com.sap.security.api.ticket.InfoUnit iu = ticket.getInfoUnit(0x20);

               String portalUser = new String();

               if (iu != null) {

                    String portal_user = iu.getString("UTF8");

                    portalUser = portal_user.substring(7);

               }

               System.out.println("***** Ticket Content begin *******");

               System.out.println("Userid:" + portalUser);

               System.out.println("SystemID:" + ticket.getSystemID());

               System.out.println("Client:" + ticket.getSystemClient());

               System.out.println("CodePage:" + ticket.getCodepage());

               Calendar cal = ticket.getStartValidDate();

               System.out.println(

                    "StartValidDate:"

                         + cal.get(Calendar.DATE)

                         + "."

                         + cal.get(Calendar.MONTH)

                         + "."

                         + cal.get(Calendar.YEAR)

                         + "/"

                         + cal.get(Calendar.HOUR)

                         + "."

                         + cal.get(Calendar.MINUTE)

                         + "."

                         + cal.get(Calendar.SECOND)

                         + "_"

                         + cal.get(Calendar.AM_PM));

               cal = ticket.getExpirationDate();

               System.out.println(

                    "ExpirationDate:"

                         + cal.get(Calendar.DATE)

                         + "."

                         + cal.get(Calendar.MONTH)

                         + "."

                         + cal.get(Calendar.YEAR)

                         + "/"

                         + cal.get(Calendar.HOUR)

                         + "."

                         + cal.get(Calendar.MINUTE)

                         + "."

                         + cal.get(Calendar.SECOND)

                         + "_"

                         + cal.get(Calendar.AM_PM));

               System.out.println(

                    "SignerCertificate:" + ticket.getSignerCertificate());

               System.out.println("***** Ticket Content end *******");

               sendResponse(portalUser);

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

     }

}
