import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromFile<T> {

	private static String[] fields;

	public static <T> T readObject(File file) throws ClassNotFoundException {
		String line = "";
		try {
			Scanner read = new Scanner(file);
			line = read.nextLine();
			read.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("File not found!!!");
		}
		fields = line.split(",");
		try {
			return convertObject();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private static <T> T convertObject()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {

		Class<?> c = Class.forName(fields[0].trim());
		T object = (T) c.newInstance();
		int j = 1;
		Type[] fields2;
		for (int i = 1; i < fields.length; i++) {
			String[] field = fields[i].split(":");
			String name = field[0];
			Class<?> type = Class.forName(getClassName(field[1]));
			String textValue = field[2];

			Object value = type.getConstructor(String.class).newInstance(textValue);

			System.out.println(fields[i]);
			Field f = c.getDeclaredField(name);
			f.setAccessible(true);
			f.set(object, value);
		}
		return object;
	}

	private static String getClassName(String className) {
		switch (className) {
		case "int":
			return "java.lang.Integer";
		case "double":
			return "java.lang.Double";
		case "boolean":
			return "java.lang.Boolean";
		default:
			return className;
		}
	}

}
