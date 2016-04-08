package test;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.emc.fibonacci.engine.PrintableFibonacciSequence;

/**
 * Check against 10000th fibonacci number value.
 * Actually replaces all previous tests, maybe exept SeqLimits0 and SeqLimits2.
 * Other tests are left for ease of debugging, should any issue arise 
 * @author Ilya Afanasiev (ilya.afanasiev@gmail.com)
 */
public class SeqLimits6 implements IUnitTest {

	private static String GOLDEN_DATA;
	static {
		StringBuilder sb = new StringBuilder();
		sb.append("[33644764876431783266621612005107543310302148460680063906564769974680081442166662368155595513633734025582065332680836");
		sb.append("1593737347904838652682630408924630564318873545443695598274916066020998841839338646527313000888302692356736131351175792");
		sb.append("9743785441375213052050434770160226475831890652789085515436615958298727968298751063120057542878345321551510387081829896");
		sb.append("9791613127856265033195487140214287532698187962046936097879900350962302291026368131493195275630227837628441540360584402");
		sb.append("5721143349611800230912082870460889239623288354615057765832712525460935911282039252853934346209042452489294039017062338");
		sb.append("8899108584106518317336043747073790855263176432573399371287193758774689747992630583706574283016163740896917842637862421");
		sb.append("2835258112820516370298089332099905707920064367426202389783111470054074998459250360633560933883831923386783056136435351");
		sb.append("8921332797329081337326426526339897639227234078829281779535805709936910491754708089318410561463223382174656373212482263");
		sb.append("8309210329770164805472624384237486241145309381220656491403275108664339451751216152654536133311131404243685480510676584");
		sb.append("3493523836959653428071768775328348234345557366719731392746273629108210679280784718035329131176778924659089938635459327");
		sb.append("8945237776744061922403376386740402133034329749690202832814593341882681768389307200363479562311710310129195316979460763");
		sb.append("2737589253530772552375943788434504067715555779056450443016640119462580972216729758615026968443146952034614932291105970");
		sb.append("6762432685159928347098912847067408620085871350162603120719031720860940812983215810772820763531866246112782455372085323");
		sb.append("6530577595643007251774431505153960090516860322034916322264088524885243315805153484962243484829938090507048348244932745");
		sb.append("3732624567755879089187190803662058009594743150052402532709746995318770724376825907419939632265984147498193609285223945");
		sb.append("0397071654431564213281576889080587831834049174345562705202235648464951961124602683139709750693826487066132645076650746");
		sb.append("1151267752274862159864253071129844118262266105716351506926002986170494542504749137811515413994155067125627119713325276");
		sb.append("3631939606902895650288268608362241082050562430701794976171121233066073310059947366875]");
		GOLDEN_DATA=sb.toString();
	}
	
	public String testName() {
		return getClass().getSimpleName();
	}
	
	public boolean execute() {
		try {
			//NB: item# starts from 0
			PrintableFibonacciSequence seq = new PrintableFibonacciSequence();
			seq.setLimits(10000, 10000);
	    	StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			seq.directPrint(pw);
	        pw.flush();
	        pw.close();
	        return sw.toString().compareTo(GOLDEN_DATA) == 0;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		SeqLimits6 test = new SeqLimits6();
		test.execute();
	}
	

}