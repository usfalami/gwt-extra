package com.gwt.extra.server;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwt.extra.client.service.DataService;
import com.gwt.extra.shared.Value;

public class DataServiceImpl extends RemoteServiceServlet implements DataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 336023103847922271L;


	private static final List<Value> list;
	

	@Override
	public List<Value> getValues(String value) {
		return null;
	}

	static{
		list = new ArrayList<Value>();
		list.add(new Value("AC ", "Ascension Island"));
		list.add(new Value("AD", "Andorra"));
		list.add(new Value("AE", "United Arab Emirates"));
		list.add(new Value("AF", "Afghanistan"));
		list.add(new Value("AG", "Antigua and Barbuda"));
		list.add(new Value("AI", "Anguilla"));
		list.add(new Value("AL", "Albania"));
		list.add(new Value("AM", "Armenia"));
		list.add(new Value("AN", "Netherlands Antilles"));
		list.add(new Value("AO", "Angola"));
		list.add(new Value("AQ", "Antarctica"));
		list.add(new Value("AR", "Argentina"));
		list.add(new Value("AS", "American Samoa"));
		list.add(new Value("AT", "Austria"));
		list.add(new Value("AU", "Australia"));
		list.add(new Value("AW", "Aruba"));
		list.add(new Value("AX", "Åland Islands"));
		list.add(new Value("AZ", "Azerbaijan"));
		list.add(new Value("BA", "Bosnia and Herzegovina"));
		list.add(new Value("BB", "Barbados"));
		list.add(new Value("BD", "Bangladesh"));
		list.add(new Value("BE", "Belgium"));
		list.add(new Value("BF", "Burkina Faso"));
		list.add(new Value("BG", "Bulgaria"));
		list.add(new Value("BH", "Bahrain"));
		list.add(new Value("BI", "Burundi"));
		list.add(new Value("BJ", "Benin"));
		list.add(new Value("BL", "Saint Barthélemy"));
		list.add(new Value("BM", "Bermuda"));
		list.add(new Value("BN", "Brunei"));
		list.add(new Value("BO", "Bolivia"));
		list.add(new Value("BQ", "British Antarctic Territory"));
		list.add(new Value("BR", "Brazil"));
		list.add(new Value("BS", "Bahamas"));
		list.add(new Value("BT", "Bhutan"));
		list.add(new Value("BV", "Bouvet Island"));
		list.add(new Value("BW", "Botswana"));
		list.add(new Value("BY", "Belarus"));
		list.add(new Value("BZ", "Belize"));
		list.add(new Value("CA", "Canada"));
		list.add(new Value("CC", "Cocos [Keeling] Islands"));
		list.add(new Value("CD", "Congo - Kinshasa"));
		list.add(new Value("CF", "Central African Republic"));
		list.add(new Value("CG", "Congo - Brazzaville"));
		list.add(new Value("CH", "Switzerland"));
		list.add(new Value("CI", "Côte d’Ivoire"));
		list.add(new Value("CK", "Cook Islands"));
		list.add(new Value("CL", "Chile"));
		list.add(new Value("CM", "Cameroon"));
		list.add(new Value("CN", "China"));
		list.add(new Value("CO", "Colombia"));
		list.add(new Value("CP", "Clipperton Island"));
		list.add(new Value("CR", "Costa Rica"));
		list.add(new Value("CS", "Serbia and Montenegro"));
		list.add(new Value("CT", "Canton and Enderbury Islands"));
		list.add(new Value("USF", "Youssef"));
		list.add(new Value("CU", "Cuba"));
		list.add(new Value("CV", "Cape Verde"));
		list.add(new Value("CX", "Christmas Island"));
		list.add(new Value("CY", "Cyprus"));
		list.add(new Value("CZ", "Czech Republic"));
		list.add(new Value("DD", "East Germany"));
		list.add(new Value("DE", "Germany"));
		list.add(new Value("DG", "Diego Garcia"));
		list.add(new Value("DJ", "Djibouti"));
		list.add(new Value("DK", "Denmark"));
		list.add(new Value("DM", "Dominica"));
		list.add(new Value("DO", "Dominican Republic"));
		list.add(new Value("DZ", "Algeria"));
		list.add(new Value("EA", "Ceuta and Melilla"));
		list.add(new Value("EC", "Ecuador"));
		list.add(new Value("EE", "Estonia"));
		list.add(new Value("EG", "Egypt"));
		list.add(new Value("EH", "Western Sahara"));
		list.add(new Value("ER", "Eritrea"));
		list.add(new Value("ES", "Spain"));
		list.add(new Value("ET", "Ethiopia"));
		list.add(new Value("EU", "European Union"));
		list.add(new Value("FI", "Finland"));
		list.add(new Value("FJ", "Fiji"));
		list.add(new Value("FK", "Falkland Islands"));
		list.add(new Value("FM", "Micronesia"));
		list.add(new Value("FO", "Faroe Islands"));
		list.add(new Value("FQ", "French Southern and Antarctic Territories"));
		list.add(new Value("FR", "France"));
		list.add(new Value("FX", "Metropolitan France"));
		list.add(new Value("GA", "Gabon"));
		list.add(new Value("GB", "United Kingdom"));
		list.add(new Value("GD", "Grenada"));
		list.add(new Value("GE", "Georgia"));
		list.add(new Value("GF", "French Guiana"));
		list.add(new Value("GG", "Guernsey"));
		list.add(new Value("GH", "Ghana"));
		list.add(new Value("GI", "Gibraltar"));
		list.add(new Value("GL", "Greenland"));
		list.add(new Value("GM", "Gambia"));
		list.add(new Value("GN", "Guinea"));
		list.add(new Value("GP", "Guadeloupe"));
		list.add(new Value("GQ", "Equatorial Guinea"));
		list.add(new Value("GR", "Greece"));
		list.add(new Value("GS", "South Georgia and the South Sandwich Islands"));
		list.add(new Value("GT", "Guatemala"));
		list.add(new Value("GU", "Guam"));
		list.add(new Value("GW", "Guinea-Bissau"));
		list.add(new Value("GY", "Guyana"));
		list.add(new Value("HK", "Hong Kong SAR China"));
		list.add(new Value("HM", "Heard Island and McDonald Islands"));
		list.add(new Value("HN", "Honduras"));
		list.add(new Value("HR", "Croatia"));
		list.add(new Value("HT", "Haiti"));
		list.add(new Value("HU", "Hungary"));
		list.add(new Value("IC", "Canary Islands"));
		list.add(new Value("ID", "Indonesia"));
		list.add(new Value("IE", "Ireland"));
		list.add(new Value("IM", "Isle of Man"));
		list.add(new Value("IN", "India"));
		list.add(new Value("IO", "British Indian Ocean Territory"));
		list.add(new Value("IQ", "Iraq"));
		list.add(new Value("IR", "Iran"));
		list.add(new Value("IS", "Iceland"));
		list.add(new Value("IT", "Italy"));
		list.add(new Value("JE", "Jersey"));
		list.add(new Value("JM", "Jamaica"));
		list.add(new Value("JO", "Jordan"));
		list.add(new Value("JP", "Japan"));
		list.add(new Value("JT", "Johnston Island"));
		list.add(new Value("KE", "Kenya"));
		list.add(new Value("KG", "Kyrgyzstan"));
		list.add(new Value("KH", "Cambodia"));
		list.add(new Value("KI", "Kiribati"));
		list.add(new Value("KM", "Comoros"));
		list.add(new Value("KN", "Saint Kitts and Nevis"));
		list.add(new Value("KP", "North Korea"));
		list.add(new Value("KR", "South Korea"));
		list.add(new Value("KW", "Kuwait"));
		list.add(new Value("KY", "Cayman Islands"));
		list.add(new Value("KZ", "Kazakhstan"));
		list.add(new Value("LA", "Laos"));
		list.add(new Value("LB", "Lebanon"));
		list.add(new Value("LC", "Saint Lucia"));
		list.add(new Value("LI", "Liechtenstein"));
		list.add(new Value("LK", "Sri Lanka"));
		list.add(new Value("LR", "Liberia"));
		list.add(new Value("LS", "Lesotho"));
		list.add(new Value("LT", "Lithuania"));
		list.add(new Value("LU", "Luxembourg"));
		list.add(new Value("LV", "Latvia"));
		list.add(new Value("LY", "Libya"));
		list.add(new Value("MA", "Morocco"));
		list.add(new Value("MC", "Monaco"));
		list.add(new Value("MD", "Moldova"));
		list.add(new Value("ME", "Montenegro"));
		list.add(new Value("MF", "Saint Martin"));
		list.add(new Value("MG", "Madagascar"));
		list.add(new Value("MH", "Marshall Islands"));
		list.add(new Value("MI", "Midway Islands"));
		list.add(new Value("MK", "Macedonia"));
		list.add(new Value("ML", "Mali"));
		list.add(new Value("MM", "Myanmar [Burma]"));
		list.add(new Value("MN", "Mongolia"));
		list.add(new Value("MO", "Macau SAR China"));
		list.add(new Value("MP", "Northern Mariana Islands"));
		list.add(new Value("MQ", "Martinique"));
		list.add(new Value("MR", "Mauritania"));
		list.add(new Value("MS", "Montserrat"));
		list.add(new Value("MT", "Malta"));
		list.add(new Value("MU", "Mauritius"));
		list.add(new Value("MV", "Maldives"));
		list.add(new Value("MW", "Malawi"));
		list.add(new Value("MX", "Mexico"));
		list.add(new Value("MY", "Malaysia"));
		list.add(new Value("MZ", "Mozambique"));
		list.add(new Value("NA", "Namibia"));
		list.add(new Value("NC", "New Caledonia"));
		list.add(new Value("NE", "Niger"));
		list.add(new Value("NF", "Norfolk Island"));
		list.add(new Value("NG", "Nigeria"));
		list.add(new Value("NI", "Nicaragua"));
		list.add(new Value("NL", "Netherlands"));
		list.add(new Value("NO", "Norway"));
		list.add(new Value("NP", "Nepal"));
		list.add(new Value("NQ", "Dronning Maud Land"));
		list.add(new Value("NR", "Nauru"));
		list.add(new Value("NT", "Neutral Zone"));
		list.add(new Value("NU", "Niue"));
		list.add(new Value("NZ", "New Zealand"));
		list.add(new Value("OM", "Oman"));
		list.add(new Value("PA", "Panama"));
		list.add(new Value("PC", "Pacific Islands Trust Territory"));
		list.add(new Value("PE", "Peru"));
		list.add(new Value("PF", "French Polynesia"));
		list.add(new Value("PG", "Papua New Guinea"));
		list.add(new Value("PH", "Philippines"));
		list.add(new Value("PK", "Pakistan"));
		list.add(new Value("PL", "Poland"));
		list.add(new Value("PM", "Saint Pierre and Miquelon"));
		list.add(new Value("PN", "Pitcairn Islands"));
		list.add(new Value("PR", "Puerto Rico"));
		list.add(new Value("PS", "Palestinian"));
		list.add(new Value("PT", "Portugal"));
		list.add(new Value("PU", "U.S. Miscellaneous Pacific Islands"));
		list.add(new Value("PW", "Palau"));
		list.add(new Value("PY", "Paraguay"));
		list.add(new Value("PZ", "Panama Canal Zone"));
		list.add(new Value("QA", "Qatar"));
		list.add(new Value("QO", "Outlying Oceania"));
		list.add(new Value("RE", "Réunion"));
		list.add(new Value("RO", "Romania"));
		list.add(new Value("RS", "Serbia"));
		list.add(new Value("RU", "Russia"));
		list.add(new Value("RW", "Rwanda"));
		list.add(new Value("SA", "Saudi Arabia"));
		list.add(new Value("SB", "Solomon Islands"));
		list.add(new Value("SC", "Seychelles"));
		list.add(new Value("SD", "Sudan"));
		list.add(new Value("SE", "Sweden"));
		list.add(new Value("SG", "Singapore"));
		list.add(new Value("SH", "Saint Helena"));
		list.add(new Value("SI", "Slovenia"));
		list.add(new Value("SJ", "Svalbard and Jan Mayen"));
		list.add(new Value("SK", "Slovakia"));
		list.add(new Value("SL", "Sierra Leone"));
		list.add(new Value("SM", "San Marino"));
		list.add(new Value("SN", "Senegal"));
		list.add(new Value("SO", "Somalia"));
		list.add(new Value("SR", "Suriname"));
		list.add(new Value("ST", "São Tomé and Príncipe"));
		list.add(new Value("SU", "Union of Soviet Socialist Republics"));
		list.add(new Value("SV", "El Salvador"));
		list.add(new Value("SY", "Syria"));
		list.add(new Value("SZ", "Swaziland"));
		list.add(new Value("TA", "Tristan da Cunha"));
		list.add(new Value("TC", "Turks and Caicos Islands"));
		list.add(new Value("TD", "Chad"));
		list.add(new Value("TF", "French Southern Territories"));
		list.add(new Value("TG", "Togo"));
		list.add(new Value("TH", "Thailand"));
		list.add(new Value("TJ", "Tajikistan"));
		list.add(new Value("TK", "Tokelau"));
		list.add(new Value("TL", "Timor-Leste"));
		list.add(new Value("TM", "Turkmenistan"));
		list.add(new Value("TN", "Tunisia"));
		list.add(new Value("TO", "Tonga"));
		list.add(new Value("TR", "Turkey"));
		list.add(new Value("TT", "Trinidad and Tobago"));
		list.add(new Value("TV", "Tuvalu"));
		list.add(new Value("TW", "Taiwan"));
		list.add(new Value("TZ", "Tanzania"));
		list.add(new Value("UA", "Ukraine"));
		list.add(new Value("UG", "Uganda"));
		list.add(new Value("UM", "U.S. Minor Outlying Islands"));
		list.add(new Value("US", "United States"));
		list.add(new Value("UY", "Uruguay"));
		list.add(new Value("UZ", "Uzbekistan"));
		list.add(new Value("VA", "Vatican City"));
		list.add(new Value("VC", "Saint Vincent and the Grenadines"));
		list.add(new Value("VD", "North Vietnam"));
		list.add(new Value("VE", "Venezuela"));
		list.add(new Value("VG", "British Virgin Islands"));
		list.add(new Value("VI", "U.S. Virgin Islands"));
		list.add(new Value("VN", "Vietnam"));
		list.add(new Value("VU", "Vanuatu"));
		list.add(new Value("WF", "Wallis and Futuna"));
		list.add(new Value("WK", "Wake Island"));
		list.add(new Value("WS", "Samoa"));
		list.add(new Value("YD", "People's Democratic Republic of Yemen"));
		list.add(new Value("YE", "Yemen"));
		list.add(new Value("YT", "Mayotte"));
		list.add(new Value("ZA", "South Africa"));
		list.add(new Value("ZM", "Zambia"));
		list.add(new Value("ZW", "Zimbabwe"));
		list.add(new Value("ZZ", "Unknown Region"));
	}



	public static void main(String[] args) {

		String s = "<Nav><Navtype><NavItemtext='Menu1'></NavItem><NavItemtext='Menu2'></NavItem><NavItemactive='true' text='Menu3'></NavItem><NavItemtext='Menu4'></NavItem></Navtype></Nav>";
		String tmp = ""; int sp=0;
		Matcher m = Pattern.compile("(<[\\w\\s=']+>[\\w\\s]*</[\\w]+>)|(<[\\w\\s=']+>)|(</[\\w]+>)").matcher(s);
		
		while(m.find()) 
			tmp += (m.group(1)!=null?m1(sp):m.group(2)!=null?m1(sp++):m1(--sp))  + m.group()+ '\n';
		System.out.println(tmp);
		
//		m= p2.matcher(tmp);
	}

	public static String m1(int count) {
		char s[] = new char[count];
		for(int i=0; i<count; i++) s[i]=' ';
		return new String(s); 
	}

}