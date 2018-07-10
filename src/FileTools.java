package djl.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileTools {
	
	public static void main(String args[]) throws Exception{
		String baseInputPath = "E:/src/a/";
		String baseOutputPath = "E:/src/c/";
		
		String filePath = "b/1.txt";//�����ļ������·��
		
		String fileDirs = getDirsFromPath(filePath);
		
		File in = new File(baseInputPath+filePath);
		File dirs = new File(baseOutputPath+fileDirs);
		if(!dirs.exists()){
			dirs.mkdirs();
		}
		File out = new File(baseOutputPath+filePath);
		if(!out.exists()){
			out.createNewFile();
		}
		fileChannelCopy(in,out);
	}
	
	private static String getDirsFromPath(String filePath) {
		int index = filePath.lastIndexOf("/");
		return filePath.substring(0,index);
	}

	private static String getNameFromPath(String filePath) {
		int index = filePath.lastIndexOf("/");
		return filePath.substring(index);
	}

	/**
	 * ʹ���ļ�ͨ���ķ�ʽ�����ļ�
	 * 
	 * @param s
	 *            Դ�ļ�
	 * @param t
	 *            ���Ƶ������ļ�
	 */

	public static void fileChannelCopy(File s, File t) {

		FileInputStream fi = null;

		FileOutputStream fo = null;

		FileChannel in = null;

		FileChannel out = null;

		try {

			fi = new FileInputStream(s);

			fo = new FileOutputStream(t);

			in = fi.getChannel();// �õ���Ӧ���ļ�ͨ��

			out = fo.getChannel();// �õ���Ӧ���ļ�ͨ��

			in.transferTo(0, in.size(), out);// ��������ͨ�������Ҵ�inͨ����ȡ��Ȼ��д��outͨ��

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				fi.close();

				in.close();

				fo.close();

				out.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

	}
}
