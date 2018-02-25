package cn.honosayaka.jt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReadFile {
	public static void starChange(File f) {
		BufferedReader read = null;
		File writefile = new File("e:/srt_new/"+f.getName());
		BufferedWriter write = null;
		String readline = null;
		try {
			read = new BufferedReader(new InputStreamReader(new FileInputStream(f),"utf-8"));
			write =  new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writefile,false)));
			read.readLine();
			write.write(1+"\r\n");
			while((readline = read.readLine()) != null) {
				if(readline.startsWith("00")) {
					write.write(Change.changeTime(readline)+"\r\n");
					write.flush();
				}else {
					write.write(readline+"\r\n");
					write.flush();
				}
			}
		}
			catch (IOException e) {
			e.printStackTrace();
		}
		try {
			write.flush();
			write.close();
			read.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		File file = new File("e:/srt_old/");
		for(File f : file.listFiles()) {
			starChange(f) ;
			System.out.println(f.getAbsolutePath()+" is OK!");
		}
	} 
}
