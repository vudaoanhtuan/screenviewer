package util;

import main.Main;

public class Log {
	public static void syslog(String mess) {
		Main.ui.sysLogPanel.log(mess);
	}
}
