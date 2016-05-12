package br.com.amil.util;

public class RegexUtil {

	private RegexUtil() {
	}

	public static final String REGEX_MATCH_LOG_SEPARATOR = "-";
	
	public static final String REGEX_EVENT_LOG_SEPARATOR = "\\s+";
	
	public static final String REGEX_MATCH_STARTED = "(.*) New match (.*) has started";
	public static final String REGEX_MATCH_STARTED_REPLACE = "(New match)|(has started)";

	public static final String REGEX_MATCH_ENDED = "(.*) Match (.*) has ended";
	public static final String REGEX_MATCH_ENDED_REPLACE = "(Match)|(has ended)";
	
	public static final String REGEX_MURDER = "(.*) killed (.*) (using|by) (.*)";
	public static final String REGEX_MURDER_REPLACE = "(killed)|(using|by)";
	
	public static final String DATE_LOG_FORMAT = "dd/MM/yyyy HH:mm:ss";

	public static String[] split(String line, String regexReplace,
			String regexSeparator) {
		
		return line.replaceAll(regexReplace, "").split(regexSeparator);
		
	}

}
