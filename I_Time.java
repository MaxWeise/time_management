package organisationsprogramm_v2_java;

/**
 * @author Max Weise
 *
 */
interface I_Time {
	void stopwatch();
	
	/**
	 * Defaultmethod to better display time
	 * 
	 * @param seconds
	 * @return Time in the format hh:mm:ss
	 */
	static String timeDelta(int seconds) {
		int minutes =(seconds / 60) % 60;
		int hours = (seconds / 3600) % 60;
		seconds = seconds % 60;
		
		String output = String.format("%02d:%02d:%02d", hours, minutes, seconds);
		return output;
	}
}
