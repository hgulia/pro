package Utilities;
public class TestConfig{


	
	public static String server="smtp.gmail.com";
	public static String from = "hgulia@akkadianlabs.com";
	public static String password = "Manu$1980";
	public static String[] to ={"hgulia@akkadianlabs.com","Kchan@akkadianlabs.com"};
	public static String subject = "Extent Project Report for Provision ";
	
	public static String messageBody ="PME Provision Report QA Automation, Click on Extent Report.";
	public static String attachmentPath="C:/Users/hgulia/git/Pro/PmeProvisionJobs/target/surefire-reports/html/extent.html";
	public static String attachmentName="Extent Report";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$ql$!!1"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "selenium";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/acs";
	
	
	
	
	
	
	
	
	
}
