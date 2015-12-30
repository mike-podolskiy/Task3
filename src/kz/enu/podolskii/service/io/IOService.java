package kz.enu.podolskii.service.io;

public interface  IOService {
	
	String readText(String src);
	void writeText(String src, String text);
}
