import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Task_175 {
	public static void main(String[] args) {
		String outputPath = "OUTPUT.TXT";
		String inputPath = "INPUT.TXT";
		TimeChecker test = new TimeChecker(inputPath);
		try (BufferedWriter output = Files.newBufferedWriter(Paths.get(outputPath))) {
			output.write(test.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class TimeChecker {
	private int hour;
	private int minute;

	public TimeChecker(String path) {
		try (final BufferedReader input = Files.newBufferedReader(Paths.get(path))) {
			String data = input.lines().collect(Collectors.joining());
			String[] parsedData = data.split(":");
			hour = Integer.parseInt(parsedData[0]);
			minute = Integer.parseInt(parsedData[1]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int count() {
		if(hour < 10) {
			return 20 * 60 - (hour * 60 + minute);
		} else if (hour >= 17 && hour < 20) {
			return -(((hour * 60 + minute) - 24 * 60) - 5 * 60);
		} else if(hour < 20) {
			return 24 * 60 - (hour * 60 + minute);
		} else {
			return -(((hour * 60 + minute) - 24 * 60) - 10 * 60);
		}
	}

	@Override
	public String toString() {
		return String.valueOf(count());
	}
}