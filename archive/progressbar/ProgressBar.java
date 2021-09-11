package progressbar;

public class ProgressBar {

	public static void main(String[] args) throws Exception {
		StringBuilder str = new StringBuilder();

		for (int i = 0; i <= 25; i++) {
			str.append("#");
			Thread.sleep(250);
			if (i == 25) {
				System.out.println("[" + str.toString() + "] " + i * 4 + "%" + " - TASK COMPLETED!");
			} else {
				System.out.println("[" + str.toString() + "] " + i * 4 + "%");
			}
		}
	}
}
