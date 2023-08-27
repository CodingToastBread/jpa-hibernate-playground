package coding.toast;

import static coding.toast.DefaultExecutionWrapper.wrapAndExecute;

public class MainClass {
	public static void main(String[] args) {
		wrapAndExecute("postgresUnit", (emf, em, tx) -> {
		});
	}
}
