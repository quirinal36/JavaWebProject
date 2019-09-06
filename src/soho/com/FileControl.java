package soho.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.json.JSONObject;

public class FileControl {
	static final Logger logger = Logger.getLogger(FileControl.class.getSimpleName());
	/**
	 * 파일 삭제하기
	 * 
	 * @param title
	 * @return
	 */
	public boolean deleteFile(String title) {
		boolean result = false;
		File storedFile = new File(title);
		if(storedFile.exists()) {
			result = storedFile.delete();
		}
		return result;
	}
	
	/**
	 * 파일 수정하기
	 * 
	 * @param title
	 * @param content
	 */
	public void appendFile(String title, String content) {
		File storedFile = new File(title);
		try(BufferedWriter writer = new BufferedWriter(
				new FileWriter(storedFile, true))){
			writer.append(content);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 파일 읽기
	 * 
	 * @param title
	 * @return
	 */
	public String readFile(String title) {
		StringBuilder result = new StringBuilder();
		File storedFile = new File(title);
		if(storedFile.exists()) {
			try(BufferedReader reader = new BufferedReader(
					new FileReader(storedFile))){
				String line;
				while((line = reader.readLine()) != null) {
					result.append(line);
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return result.toString();
	}
	
	/**
	 * 파일 생성 및 텍스트쓰기
	 * 
	 * @param title
	 * @param content
	 */
	public void writeFile(String title, String content) {
		File newFile = new File(title);
		
		try (BufferedWriter writer = 
				new BufferedWriter(new FileWriter(newFile))){
			writer.write(content);
			System.out.println(newFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
